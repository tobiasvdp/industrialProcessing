package mod.industrialProcessing.plants.transport.fluids.tank;

import java.util.Arrays;

import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.blockContainer.transport.IConnectedTile;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.ITankSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TankHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TileTankSyncHandler;
import mod.industrialProcessing.fluids.FluidTransfers;
import mod.industrialProcessing.fluids.IFluidInfo;
import mod.industrialProcessing.fluids.tank.IPressuredTank;
import mod.industrialProcessing.transport.fluids.tileEntity.TileEntityTransportFluidsBase;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityTank extends TileEntityBlockContainerIP implements IFluidHandler, IConnectedTile, IFluidInfo, ITankSyncable, IPressuredTank, IRotateableEntity {

    private static final int PRESSURE_CONSTANT = 220;
    private FluidTank tank = new FluidTank(10 * FluidContainerRegistry.BUCKET_VOLUME);
    private boolean isTop = false;

    private AnimationHandler animation = new AnimationHandler(AnimationMode.CLAMP, 10f, true);
    private ConnectionState[] states = new ConnectionState[6];
    private boolean unverified = true;
    private TankHandler tankHandler;
    private float pressure;
    private float pressureAbove;
    private ForgeDirection forward;
    private int tanksInStack;
    private int tanksAbove;
    private int tanksBelow;

    public TileEntityTank() {
	Arrays.fill(states, ConnectionState.DISCONNECTED);
	this.tankHandler = new TankHandler(this, new int[] { 0 });
    }

    @Override
    public boolean canUpdate() {
	return true;
    }

    public void searchForNeighbors() {
	this.unverified = true;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (unverified && !this.worldObj.isRemote) {
	    System.out.println("Tank update at :" + xCoord + " " + yCoord + " " + zCoord);
	    tanksAbove = getTanks(ForgeDirection.UP);
	    tanksBelow = getTanks(ForgeDirection.DOWN);

	    this.setForwardDirection(getLowestForward(tanksBelow, ForgeDirection.DOWN));
	    tanksInStack = 1 + tanksBelow + tanksAbove;
	    setTankSize(tanksAbove, ForgeDirection.UP);
	    setTankSize(tanksBelow, ForgeDirection.DOWN);
	    System.out.println("counting tanks: " + tanksInStack);

	    for (int i = 2; i < 6; i++) {
		ForgeDirection direction = ForgeDirection.getOrientation(i);
		setState(direction, verifyState(direction));
	    }
	    unverified = false;
	    this.notifyBlockChange(); // mark nbt as changed
	}
	if (!this.states[ForgeDirection.UP.ordinal()].isConnected())
	    this.pressureAbove = 0;

	if (!this.worldObj.isRemote) {
	    this.pressure = this.tank.getFluidAmount() * PRESSURE_CONSTANT / this.tank.getCapacity();

	    if (tanksBelow > 0) {
		TileEntity entityBelow = this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);
		if (entityBelow instanceof TileEntityTank) {
		    TileEntityTank tankBelow = (TileEntityTank) entityBelow;
		    if (tank.getFluidAmount() > 0)// let the fluid fall!
			FluidTransfers.transfer(this.tank.getCapacity(), this.tank, tankBelow.tank);
		    tankBelow.pressureAbove = this.pressure + pressureAbove;
		}
	    }

	    if (this.tankHandler.readDataFromTanks())
		TileTankSyncHandler.sendTankData(this, this.tankHandler);
	}

    }

    private ForgeDirection getLowestForward(int distance, ForgeDirection up) {

	TileEntity entityAbove = this.worldObj.getTileEntity(xCoord + up.offsetX * distance, yCoord + up.offsetY * distance, zCoord + up.offsetZ * distance);
	if (entityAbove instanceof TileEntityTank) {
	    TileEntityTank tankAbove = (TileEntityTank) entityAbove;
	    return tankAbove.forward;
	}
	return ForgeDirection.NORTH;
    }

    private void setTankSize(int tanksAbove, ForgeDirection direction) {
	for (int i = 1; i <= tanksAbove; i++) {
	    TileEntity entityAbove = this.worldObj.getTileEntity(xCoord + direction.offsetX * i, yCoord + direction.offsetY * i, zCoord + direction.offsetZ * i);
	    if (entityAbove instanceof TileEntityTank) {
		TileEntityTank otherTank = (TileEntityTank) entityAbove;
		otherTank.tanksInStack = this.tanksInStack;
		otherTank.setForwardDirection(this.forward);
		if (direction == ForgeDirection.UP) {
		    otherTank.tanksAbove = this.tanksAbove - i;
		    otherTank.tanksBelow = this.tanksBelow + i;
		} else { // propagating downwards
		    otherTank.tanksAbove = this.tanksAbove + i;
		    otherTank.tanksBelow = this.tanksBelow - i;
		}
		otherTank.setState(ForgeDirection.UP, otherTank.tanksAbove > 0);
		// if there are tanks below, it is connected!
		otherTank.setState(ForgeDirection.DOWN, otherTank.tanksBelow > 0);
		// if there are tanks above, it is connected!
	    }
	}
    }

    private void setState(ForgeDirection direction, boolean b) {
	setState(direction, b ? ConnectionState.CONNECTED : verifyState(direction));
    }

    private void setState(ForgeDirection direction, ConnectionState connectionState) {
	if (connectionState != this.states[direction.ordinal()]) {
	    this.states[direction.ordinal()] = connectionState;
	    this.notifyBlockChange(); // mark nbt as changed
	    this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType());
	}
    }

    private ConnectionState verifyState(ForgeDirection dir) {
	TileEntity tank = this.worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
	if (tank instanceof TileEntityTransportFluidsBase)
	    return ConnectionState.PLUGGED;
	else
	    return ConnectionState.DISCONNECTED;
    }

    private int getTanks(ForgeDirection up) {
	TileEntity entityAbove = this.worldObj.getTileEntity(xCoord + up.offsetX, yCoord + up.offsetY, zCoord + up.offsetZ);
	if (entityAbove instanceof TileEntityTank) {
	    TileEntityTank tank = (TileEntityTank) entityAbove;
	    return 1 + tank.getTanks(up);
	}
	return 0;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	this.tank.writeToNBT(nbt);
	nbt.setInteger("Forward", this.forward == null ? ForgeDirection.NORTH.ordinal() : this.forward.ordinal());
	int[] stateValues = new int[this.states.length];
	for (int i = 0; i < this.states.length; i++) {
	    stateValues[i] = this.states[i].ordinal();
	}
	nbt.setIntArray("States", stateValues);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.tank.setFluid(null);
	this.tank.readFromNBT(nbt);
	if (nbt.hasKey("Forward"))
	    this.forward = ForgeDirection.getOrientation(nbt.getInteger("Forward"));
	else
	    this.forward = ForgeDirection.NORTH;

	if (nbt.hasKey("States")) {
	    int[] stateValues = nbt.getIntArray("States");
	    for (int i = 0; i < states.length; i++) {
		states[i] = ConnectionState.values()[stateValues[i]];
	    }
	}
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
	if (tank.getFluidAmount() == tank.getCapacity()) {
	    return fillAbove(resource, doFill);
	}
	int fill = tank.fill(resource, doFill);
	return fill;
    }

    private int fillAbove(FluidStack resource, boolean doFill) {
	TileEntity entityAbove = this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
	if (entityAbove instanceof TileEntityTank) {
	    TileEntityTank tankAbove = (TileEntityTank) entityAbove;
	    int fill = tankAbove.fill(ForgeDirection.DOWN, resource, doFill);
	    return fill;
	}
	return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
	if (resource != null && resource.isFluidEqual(tank.getFluid())) {
	    FluidStack drain = tank.drain(resource.amount, doDrain);
	    return drain;
	}
	return null;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
	FluidStack stack = tank.drain(maxDrain, doDrain);
	return stack;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
	return true;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
	return true;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {

	FluidTankInfo info = tank.getInfo();
	return new FluidTankInfo[] { new FluidTankInfo(info.fluid, info.capacity * this.tanksInStack) };
    }

    @Override
    public ConnectionState getConnection(ForgeDirection direction) {
	return this.states[direction.ordinal()];
    }

    @Override
    public FluidTankInfo[] getTanks() {
	return new FluidTankInfo[] { this.tank.getInfo() };
    }

    @Override
    public TankHandler getTankHandler() {
	return this.tankHandler;
    }

    @Override
	public IFluidTank getTankInSlot(int slot) {
	if (slot == 0)
	    return this.tank;
	return null;
    }

    @Override
    public int getTankCount() {
	return 1;
    }

    @Override
    public float getPressure(ForgeDirection from) {
	if (from == ForgeDirection.UP)
	    return 0;
	if (from == ForgeDirection.DOWN)
	    return this.pressure + this.pressureAbove;
	return this.pressure / 2 + this.pressureAbove;
    }

    @Override
    public void addPressure(ForgeDirection from, float pressure) {
    }

    @Override
    public ForgeDirection getForwardDirection() {
	return this.forward;
    }

    @Override
    public void setForwardDirection(ForgeDirection forward) {
	this.forward = forward;
	this.notifyBlockChange();
	for (int i = 1; i <= tanksAbove; i++) {

	    TileEntity entityBelow = this.worldObj.getTileEntity(xCoord, yCoord + i, zCoord);
	    if (entityBelow instanceof TileEntityTank) {
		TileEntityTank tank = ((TileEntityTank) entityBelow);
		tank.forward = forward;
		tank.notifyBlockChange();
	    }
	}
	for (int i = 1; i <= tanksBelow; i++) {

	    TileEntity entityBelow = this.worldObj.getTileEntity(xCoord, yCoord - i, zCoord);
	    if (entityBelow instanceof TileEntityTank) {
		TileEntityTank tank = ((TileEntityTank) entityBelow);
		tank.forward = forward;
		tank.notifyBlockChange();
	    }
	}
    }

    @Override
    public boolean canWrenchRotate() {
	return true;
    }

    public void showDebug(EntityPlayer player) {
    }

    /*@Override
    protected boolean isValidInput(int slot, Item itemID) {
	return slot == 0 && FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 0, 1));
    }*/

    @Override
    public FluidTankInfo getTankInfoForSlot(int slot) {
	if (slot == 0) {
	    int capacity = this.tanksInStack * this.tank.getCapacity();
	    int amount = 0;
	    int fluid = -1;
	    for (int i = tanksBelow; i >= -tanksAbove; i--) {
		TileEntity lower = this.worldObj.getTileEntity(xCoord, yCoord - i, zCoord);
		if (lower instanceof TileEntityTank) {
		    TileEntityTank tank = (TileEntityTank) lower;
		    if (tank.tank.getFluidAmount() > 0) {
			amount += tank.tank.getFluidAmount();
			fluid = tank.tank.getFluid().fluidID;
		    } else
			break;
		}
	    }
	    if (fluid == -1)
		return new FluidTankInfo(null, capacity);
	    else
		return new FluidTankInfo(new FluidStack(fluid, amount), capacity);
	}
	return tank.getInfo();
    }
}

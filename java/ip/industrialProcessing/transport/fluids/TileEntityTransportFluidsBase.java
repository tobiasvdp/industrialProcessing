package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.utils.FluidTransfers;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public abstract class TileEntityTransportFluidsBase extends TileEntityTransport implements IFluidInfo, ITankSyncable {

    private static final int CONNECTION_GROUPS = 16;
    protected TankHandler tankHandler;
    protected int connectionGroup = 1;

    public void setConnectionGroup(int color) {
	connectionGroup = color;
	updateConnections();
    }

    public TileEntityTransportFluidsBase() {
    }

    @Override
    protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {
	if (this.canConnect(direction)) {
	    ForgeDirection from = direction.getOpposite();
	    if (entity instanceof TileEntityTransportFluidsBase) {
		TileEntityTransportFluidsBase other = (TileEntityTransportFluidsBase) entity;
		if ((other.connectionGroup == this.connectionGroup || other.connectionGroup == 1 || this.connectionGroup == 1) && other.canConnect(direction.getOpposite()))
		    return TransportConnectionState.TRANSPORT;
		return TransportConnectionState.NONE;
	    }

	    if (entity instanceof TileEntityManoMeter && direction == ForgeDirection.UP)
		return TransportConnectionState.TRANSPORT;

	    if (entity instanceof TileEntityPump) {
		TileEntityPump pump = (TileEntityPump) entity;
		if (pump.isFluidOuptut(from))
		    return TransportConnectionState.OUTPUT;
		if (pump.isFluidInput(from))
		    return TransportConnectionState.INPUT;
	    }
	    if (entity instanceof IFluidHandler) {
		IFluidHandler handler = (IFluidHandler) entity;
		return canInsertOrExtractFluid(handler, from);
	    }
	}
	return TransportConnectionState.NONE;
    }

    private TransportConnectionState canInsertOrExtractFluid(IFluidHandler handler, ForgeDirection from) {
	FluidTankInfo[] info = handler.getTankInfo(from);
	if (info != null && info.length > 0)
	    return TransportConnectionState.DUAL; // can't decide if input only
	// or input/output
	return TransportConnectionState.NONE;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (this.worldObj.isRemote)
	    return;
	handleSides();
	leakPressure();

	if (this.tankHandler.readDataFromTanks())
	    TileTankSyncHandler.sendTankData(this, this.tankHandler);

    }

    private void handleSides() {

	float totalIncomingPressureDifference = 0f;
	float totalOutgoingPressureDifference = 0f;
	int totalIncomingVolumeDifference = 0;
	int totalOutgoingVolumeDifference = 0;
	int totalOutgoingCapacity = 0;
	int totalIncomingCapacity = 0;
	float[] pressureDifferences = new float[6];
	int[] volumeDifferences = new int[6];
	int[] outgoingCapacities = new int[6];
	int[] incomingCapacities = new int[6];
	for (int i = 0; i < pressureDifferences.length; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    if (isConnected(direction)) {
		float pressure = getPressure(direction);

		IFluidTank tank = getTank(direction);
		int fluidAmount = tank.getFluidAmount();
		int tankCapacity = tank.getCapacity();

		float pressureDifference = pressure;
		int volumeDifference = fluidAmount;
		TileEntity entity = getNeighbor(direction);

		ForgeDirection oppositeDirection = direction.getOpposite();

		int volume = 0;
		int capacity = 0;
		int outgoingCapacity = 0;
		int incomingCapacity = 0;

		if (entity instanceof TileEntityPump) {
		    pressureDifference -= getPumpPressure((TileEntityPump) entity, oppositeDirection, pressure);
		    volume = getPumpVolume((TileEntityPump) entity, oppositeDirection);
		    capacity = getPumpCapacity((TileEntityPump) entity, oppositeDirection);
		    volumeDifference -= volume;
		} else if (entity instanceof TileEntityTransportFluidsBase) {
		    pressureDifference -= getPipePressure((TileEntityTransportFluidsBase) entity, oppositeDirection, pressure);
		    volume = getPipeVolume((TileEntityTransportFluidsBase) entity, oppositeDirection);
		    capacity = getPipeCapacity((TileEntityTransportFluidsBase) entity, oppositeDirection);
		    volumeDifference -= volume;
		} else if (entity instanceof IFluidHandler) {
		    pressureDifference -= getFluidHandlerPressure((IFluidHandler) entity, oppositeDirection, pressure);
		    volume = getFluidHandlerVolume((IFluidHandler) entity, oppositeDirection);
		    capacity = getFluidHandlerCapacity((IFluidHandler) entity, oppositeDirection);
		    volumeDifference -= volume;
		} else
		    continue;

		outgoingCapacity = Math.min(capacity - volume, fluidAmount);
		incomingCapacity = Math.min(tankCapacity - fluidAmount, volume);

		outgoingCapacities[i] = outgoingCapacity;
		incomingCapacities[i] = incomingCapacity;
		pressureDifferences[i] = pressureDifference;
		volumeDifferences[i] = volumeDifference;

		totalIncomingCapacity += incomingCapacity;
		totalOutgoingCapacity += outgoingCapacity;

		if (pressureDifference < 0)
		    totalIncomingPressureDifference -= pressureDifference;
		else if (pressureDifference > 0) // other pressure is lower
		    totalOutgoingPressureDifference += pressureDifference;

		if (volumeDifference < 0)
		    totalIncomingVolumeDifference -= volumeDifference;
		else if (volumeDifference > 0)
		    totalOutgoingVolumeDifference += volumeDifference;

	    }
	}
	if (totalIncomingPressureDifference > 0 || totalOutgoingPressureDifference > 0) {
	    for (int i = 0; i < volumeDifferences.length; i++) {

		ForgeDirection direction = ForgeDirection.getOrientation(i);
		if (isConnected(direction)) {
		    float pressureFlow = pressureDifferences[i];
		    float flowRate = 0f;

		    float equalizeFlow = volumeDifferences[i] / 1000f;

		    if (pressureFlow < 0)
			flowRate = -pressureFlow / totalIncomingPressureDifference;
		    else if (pressureFlow > 0)
			flowRate = pressureFlow / totalOutgoingPressureDifference;

		    int volumeDifference = volumeDifferences[i];

		    float volumeFlowRate = Math.abs(volumeDifference) / 1000f;
		    if (volumeFlowRate > 1)
			volumeFlowRate = 1;
		    // TODO: balance this for equilibrium

		    this.transferPressure(direction, pressureFlow * flowRate * 0.75f);

		    if (pressureFlow > 0 && totalOutgoingCapacity > 0) {
			int outgoingVolume = outgoingCapacities[i] * outgoingCapacities[i] / totalOutgoingCapacity / 2;
			this.transfer(direction, outgoingVolume);
		    } else if (totalIncomingCapacity > 0) {
			int incomingVolume = incomingCapacities[i] * incomingCapacities[i] / totalIncomingCapacity / 2;
			this.transfer(direction, -incomingVolume);
		    }
		}
	    }
	}
    }

    private int getFluidHandlerCapacity(IFluidHandler entity, ForgeDirection oppositeDirection) {
	int capacity = 0;
	FluidTankInfo[] info = entity.getTankInfo(oppositeDirection);
	if (info != null) {
	    for (int i = 0; i < info.length; i++) {
		capacity += info[i].capacity;
	    }
	}
	return capacity;
    }

    private int getPipeCapacity(TileEntityTransportFluidsBase entity, ForgeDirection oppositeDirection) {
	IFluidTank tank = entity.getTank(oppositeDirection);
	if (tank == null)
	    return 0;
	return tank.getCapacity();
    }

    private int getPumpCapacity(TileEntityPump entity, ForgeDirection oppositeDirection) {
	IFluidTank tank = entity.tank;
	if (tank == null)
	    return 0;
	return tank.getCapacity();
    }

    private void transferPressure(ForgeDirection direction, float amount) {
	if (amount == 0)
	    return;
	TileEntity entity = getNeighbor(direction);
	ForgeDirection oppositeDirection = direction.getOpposite();
	if (entity instanceof TileEntityPump) {
	    TileEntityPump pump = (TileEntityPump) entity;
	    if (pump.isFluidInput(oppositeDirection))
		pump.setInputPressure(pump.getInputPressure() + amount);
	    else if (pump.isFluidOuptut(oppositeDirection))
		pump.setOutputPressure(pump.getOutputPressure() + amount);
	} else if (entity instanceof TileEntityTransportFluidsBase) {
	    TileEntityTransportFluidsBase other = (TileEntityTransportFluidsBase) entity;
	    other.addPressure(oppositeDirection, amount);
	} else if (entity instanceof IFluidHandler) {
	    if (entity instanceof IPressuredTank) {
		IPressuredTank pressuredTank = (IPressuredTank) entity;
		pressuredTank.addPressure(oppositeDirection, amount);
	    }
	} else
	    return;
	this.addPressure(direction, -amount);
    }

    private void transfer(ForgeDirection direction, int amount) {
	if (amount == 0)
	    return;
	TileEntity entity = getNeighbor(direction);
	IFluidTank tank = getTank(direction);
	ForgeDirection oppositeDirection = direction.getOpposite();
	if (entity instanceof TileEntityPump) {
	    if (amount > 0)
		FluidTransfers.transfer(amount, tank, ((TileEntityPump) entity).getTank());
	    else
		FluidTransfers.transfer(-amount, ((TileEntityPump) entity).getTank(), tank);
	} else if (entity instanceof TileEntityTransportFluidsBase) {
	    IFluidTank otherTank = ((TileEntityTransportFluidsBase) entity).getTank(oppositeDirection);
	    if (amount > 0)
		FluidTransfers.transfer(amount, tank, otherTank);
	    else
		FluidTransfers.transfer(-amount, otherTank, tank);
	} else if (entity instanceof IFluidHandler) {
	    if (amount > 0)
		FluidTransfers.transfer(amount, tank, (IFluidHandler) entity, oppositeDirection);
	    else
		FluidTransfers.transfer(-amount, (IFluidHandler) entity, oppositeDirection, tank);
	}
    }

    private int getFluidHandlerVolume(IFluidHandler entity, ForgeDirection oppositeDirection) {
	FluidTankInfo[] info = entity.getTankInfo(oppositeDirection);
	int volume = 0;
	if (info != null) {
	    for (int i = 0; i < info.length; i++) {
		FluidStack stack = info[i].fluid;
		if (stack != null)
		    volume += stack.amount;
	    }
	}
	return volume;
    }

    private int getPipeVolume(TileEntityTransportFluidsBase entity, ForgeDirection oppositeDirection) {
	IFluidTank tank = entity.getTank(oppositeDirection);
	return tank.getFluidAmount();
    }

    private int getPumpVolume(TileEntityPump entity, ForgeDirection oppositeDirection) {
	IFluidTank tank = entity.getTank();
	return tank.getFluidAmount();
    }

    private boolean isConnected(ForgeDirection direction) {
	TransportConnectionState state = this.states[direction.ordinal()];
	return state.isConnected();
    }

    private float getFluidHandlerPressure(IFluidHandler entity, ForgeDirection direction, float equalPressure) {
	if (entity instanceof IPressuredTank)
	    return ((IPressuredTank) entity).getPressure(direction);
	return 0;
    }

    private float getPipePressure(TileEntityTransportFluidsBase entity, ForgeDirection direction, float equalPressure) {
	return entity.getPressure(direction);
    }

    private float getPumpPressure(TileEntityPump entity, ForgeDirection direction, float equalPressure) {
	if (entity.isFluidInput(direction))
	    return entity.getInputPressure();
	else if (entity.isFluidOuptut(direction))
	    return entity.getOutputPressure();
	return equalPressure;
    }

    @Override
    public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
	super.writeToNBT(par1nbtTagCompound);
	par1nbtTagCompound.setInteger("Group", this.connectionGroup);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
	super.readFromNBT(par1nbtTagCompound);
	this.connectionGroup = par1nbtTagCompound.getInteger("Group");
    }

    protected abstract void leakPressure();

    protected abstract IFluidTank getTank(ForgeDirection direction);

    protected abstract float getPressure(ForgeDirection direction);

    protected abstract void addPressure(ForgeDirection direction, float value);

    protected abstract boolean canConnect(ForgeDirection direction);

    private float getGravityFlow(TileEntityTransportFluidsBase other, ForgeDirection direction) {

	float scale = 0.15f;// 15f;
	float amount = this.getTank(direction).getFluidAmount();
	float otherAmount = other.getTank(direction.getOpposite()).getFluidAmount();

	if (direction == ForgeDirection.DOWN) {
	    // other tank is below this tank.
	    return amount * scale;
	}

	if (direction == ForgeDirection.UP) {
	    // other tank is above this tank.
	    return -otherAmount * scale;
	}

	return (amount - otherAmount) * scale;
    }

    private void addTankPressure(IFluidHandler other, ForgeDirection direction, float flow) {
	if (other instanceof IPressuredTank) {
	    IPressuredTank tank = (IPressuredTank) other;
	    tank.addPressure(direction.getOpposite(), flow);
	}
    }

    private float getTankPressure(IFluidHandler other, ForgeDirection direction) {
	if (other instanceof IPressuredTank) {
	    IPressuredTank tank = (IPressuredTank) other;
	    return tank.getPressure(direction.getOpposite());
	}
	return 0;
    }

    private IFluidHandler getNeighborFluidHandler(ForgeDirection direction) {
	TileEntity ent = getNeighbor(direction);
	if (ent instanceof IFluidHandler)
	    return (IFluidHandler) ent;
	return null;
    }

    private TileEntity getNeighbor(ForgeDirection direction) {
	return this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
    }

    private TileEntityTransportFluidsBase getNeighborPipe(ForgeDirection direction) {
	TileEntity ent = getNeighbor(direction);
	if (ent instanceof TileEntityTransportFluidsBase)
	    return (TileEntityTransportFluidsBase) ent;
	return null;
    }

    private TileEntityPump getNeighborPump(ForgeDirection direction) {
	TileEntity ent = getNeighbor(direction);
	if (ent instanceof TileEntityPump)
	    return (TileEntityPump) ent;
	return null;
    }

    @Override
    public abstract FluidTankInfo[] getTanks();

    @Override
    public TankHandler getTankHandler() {
	return this.tankHandler;
    }

    @Override
    public abstract IFluidTank getTankInSlot(int slot);

    public void cycleGroups(boolean sneaking) {
	if (sneaking)
	    connectionGroup--;
	else
	    connectionGroup++;

	if (connectionGroup < 0)
	    connectionGroup += CONNECTION_GROUPS;
	else if (connectionGroup >= CONNECTION_GROUPS)
	    connectionGroup -= CONNECTION_GROUPS;

	searchForConnections();
	this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, getBlockType().blockID);
    }

    @Override
	public void setBounds() {

	float xMin = -3 / 16f;
	float yMin = -3 / 16f;
	float zMin = -3 / 16f;
	float xMax = 3 / 16f;
	float yMax = 3 / 16f;
	float zMax = 3 / 16f;

	for (int i = 0; i < 6; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    TransportConnectionState state = this.states[i];
	    if (state.isConnected()) {
		float dx = direction.offsetX / 2f;
		float dz = direction.offsetZ / 2f;
		float dy = direction.offsetY / 2f;

		xMin = Math.min(xMin, dx);
		yMin = Math.min(yMin, dy);
		zMin = Math.min(zMin, dz);

		xMax = Math.max(xMax, dx);
		yMax = Math.max(yMax, dy);
		zMax = Math.max(zMax, dz);

	    }
	}

	this.getBlockType().setBlockBounds(xMin + 0.5f, yMin + 0.5f, zMin + 0.5f, xMax + 0.5f, yMax + 0.5f, zMax + 0.5f);
    }

    @Override
	public void addCollisionBoxesToList(AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

	for (int i = 0; i < 6; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    TransportConnectionState state = this.states[i];
	    if (state.isConnected()) {

		double xMin = -3 / 16f;
		double yMin = -3 / 16f;
		double zMin = -3 / 16f;
		double xMax = 3 / 16f;
		double yMax = 3 / 16f;
		double zMax = 3 / 16f;

		double dx = direction.offsetX / 2f;
		double dz = direction.offsetZ / 2f;
		double dy = direction.offsetY / 2f;

		xMin = Math.min(xMin, dx) + xCoord + 0.5f;
		yMin = Math.min(yMin, dy) + yCoord + 0.5f;
		zMin = Math.min(zMin, dz) + zCoord + 0.5f;

		xMax = Math.max(xMax, dx) + xCoord + 0.5f;
		yMax = Math.max(yMax, dy) + yCoord + 0.5f;
		zMax = Math.max(zMax, dz) + zCoord + 0.5f;

		AxisAlignedBB bbx = AxisAlignedBB.getBoundingBox(xMin, yMin, zMin, xMax, yMax, zMax);
		if (bbx.intersectsWith(par5AxisAlignedBB)) {
		    par6List.add(bbx);
		}
	    }
	}
    }
}

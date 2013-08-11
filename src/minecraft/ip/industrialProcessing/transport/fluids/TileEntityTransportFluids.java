package ip.industrialProcessing.transport.fluids;

import java.util.ArrayList;

import buildcraft.api.transport.IPipe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.IMachineTanks;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.transport.TileEntityTransport;

public class TileEntityTransportFluids extends TileEntityTransport implements IFluidHandler, IMachineTanks {

	private ArrayList<MachineFluidTank> fluidTanks = new ArrayList<MachineFluidTank>();
	private int[][] fluidTankSideslots = new int[6][0];
	private boolean neighborChanged = true; 
	
    @Override
    public void writeToNBT(net.minecraft.nbt.NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeTanks(nbt);
    };

    private void writeTanks(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.fluidTanks.size(); ++i) {
		    MachineFluidTank tank = this.fluidTanks.get(i);
		    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
		    nbttagcompound1.setByte("Slot", (byte) i);
		    tank.writeToNBT(nbttagcompound1);
		    nbttaglist.appendTag(nbttagcompound1);
		}
		nbt.setTag("Tanks", nbttaglist);
    }

    @Override
    public void readFromNBT(net.minecraft.nbt.NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readTanks(nbt);
    };

    private void readTanks(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Tanks");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
		    NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
		    byte b0 = nbttagcompound1.getByte("Slot");
	
		    if (b0 >= 0 && b0 < this.fluidTanks.size()) {
			MachineFluidTank machineTank = this.fluidTanks.get(b0);
			machineTank.readFromNBT(nbttagcompound1);
		    }
		}
    }
	
	public TileEntityTransportFluids() {
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.LEFT, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.FRONT, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.BACK, true, false);
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		FluidTank tank = getInputTankForFluidStack(from, resource);
		if (tank == null)
		    return 0;
		int amount = tank.fill(resource, doFill);
		if (doFill)
		    onTanksChanged();
		return amount;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		FluidTank tank = getOutputTankForFluidStack(from, resource);
		if (tank == null)
		    return null;
		FluidStack amount = tank.drain(tank.getFluidAmount(), doDrain);
		if (doDrain)
		    onTanksChanged();
		return amount;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		FluidTank tank = getOutputTank(from);
		if (tank == null)
		    return null;
		FluidStack amount = tank.drain(tank.getFluidAmount(), doDrain);
		if (doDrain)
		    onTanksChanged();
		return amount;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		FluidTank tank = getInputTankForFluid(from, fluid);
		return tank != null;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		FluidTank tank = getInputTankForFluid(from, fluid);
		return tank != null;
	}

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		LocalDirection localFrom = DirectionUtils.GetLocalDirection(from, getForwardDirection());
		int[] sides = this.fluidTankSideslots[localFrom.ordinal()];
	
		FluidTankInfo[] tanks = new FluidTankInfo[sides.length];
		for (int i = 0; i < sides.length; i++) {
		    tanks[i] = getTankInSlot(sides[i]).getInfo();
		}
		return tanks;
    }
    public FluidTankInfo getFluidTankInfoForSlot(int slot) {
		MachineFluidTank tank = getFluidTankForSlot(slot);
		if (tank == null)
		    return null;
		return tank.getInfo();
    }
    
    protected ForgeDirection getForwardDirection(){
   	 int meta = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
   	 return BlockMachine.getForwardFromMetadata(meta);
    }
    protected boolean isLiquidContainerValidForTank(int tankslot, ItemStack inputStack) {
    	FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(inputStack);
    	if (fluid == null)
    	    return false;
    	return isTankValidForFluid(tankslot, fluid.fluidID);
    }
    protected void addTank(int capacity, LocalDirection side, boolean input, boolean output) {
    	addTank(capacity, new LocalDirection[] { side }, input, output);
    }
    protected void addTank(int capacity, LocalDirection[] sides, boolean input, boolean output) {
		int index = fluidTanks.size();
	
		int[] sideIndices = new int[sides.length];
		for (int i = 0; i < sideIndices.length; i++) {  
		    sideIndices[i] = sides[i].ordinal();
		}
	
		fluidTanks.add(new MachineFluidTank(this, capacity, sideIndices, input, output));
	
		for (int i = 0; i < sideIndices.length; i++) {
		    int sideIndex = sideIndices[i];
		    int[] slots = fluidTankSideslots[sideIndex];
		    int[] newSlots = new int[slots.length + 1];
		    System.arraycopy(slots, 0, newSlots, 0, slots.length);
		    newSlots[slots.length] = index;
		    fluidTankSideslots[sideIndex] = newSlots;
		}
    }
    private MachineFluidTank getTankInSlot(int i) {
		if (i < 0 || i > this.fluidTanks.size())
		    return null;
		return this.fluidTanks.get(i);
    }
    
    protected boolean isTankValidForFluid(int slot, int fluidId){return true;}
    
    private MachineFluidTank getFluidTankForSlot(int slot) {
	if (slot < 0 || slot > fluidTanks.size())
	    return null;
	return this.fluidTanks.get(slot);
    }
    private FluidTank getInputTankForFluid(ForgeDirection from, Fluid resource) {
		if (resource == null)
		    return null;
		LocalDirection localFrom = DirectionUtils.GetLocalDirection(from, getForwardDirection());
		int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
		    int slotIndex = sideSlots[i];
		    if (isTankValidForFluid(slotIndex, resource.getID())) {
			MachineFluidTank tank = this.getTankInSlot(slotIndex);
			if (tank.input && tank.getFluidAmount() < tank.getCapacity()) {
			    FluidStack tankFluid = tank.getFluid();
			    if (tankFluid == null || tankFluid.fluidID == resource.getID()) {
				return tank;
			    }
			}
		    }
		}
		return null;
    }
    private FluidTank getInputTankForFluidStack(ForgeDirection from, FluidStack resource) {
		if (resource == null)
		    return null;
		LocalDirection localFrom = DirectionUtils.GetLocalDirection(from, getForwardDirection());
		int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
		    int slotIndex = sideSlots[i];
		    if (isTankValidForFluid(slotIndex, resource.fluidID)) {
			MachineFluidTank tank = this.getTankInSlot(slotIndex);
			if (tank.input && tank.getFluidAmount() < tank.getCapacity()) {
			    FluidStack tankFluid = tank.getFluid();
			    if (tankFluid == null || tankFluid.isFluidEqual(resource)) {
				return tank;
			    }
			}
		    }
	
		}
		return null;
    }
    private FluidTank getOutputTankForFluid(ForgeDirection from, Fluid resource) {
	if (resource == null)
	    return null;
	LocalDirection localFrom = DirectionUtils.GetLocalDirection(from, getForwardDirection());
	int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
	for (int i = 0; i < sideSlots.length; i++) {
	    int slotIndex = sideSlots[i];
	    if (isTankValidForFluid(slotIndex, resource.getID())) {
		MachineFluidTank tank = this.getTankInSlot(slotIndex);
		if (tank.output && tank.getFluidAmount() > 0) {
		    FluidStack tankFluid = tank.getFluid();
		    if (tankFluid.fluidID == resource.getID()) {
			return tank;
		    }
		}
	    }

	}
	return null;
    }

    private FluidTank getOutputTankForFluidStack(ForgeDirection from, FluidStack resource) {
	if (resource == null)
	    return null;
	LocalDirection localFrom = DirectionUtils.GetLocalDirection(from, getForwardDirection());
	int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
	for (int i = 0; i < sideSlots.length; i++) {
	    int slotIndex = sideSlots[i];
	    if (isTankValidForFluid(slotIndex, resource.fluidID)) {
		MachineFluidTank tank = this.getTankInSlot(slotIndex);
		if (tank.output && tank.getFluidAmount() > 0) {
		    FluidStack tankFluid = tank.getFluid();
		    if (tankFluid.isFluidEqual(resource)) {
			return tank;
		    }
		}
	    }
	}
	return null;
    }
    private FluidTank getOutputTank(ForgeDirection from) {
	LocalDirection localFrom = DirectionUtils.GetLocalDirection(from, getForwardDirection());
	int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
	for (int i = 0; i < sideSlots.length; i++) {
	    int slotIndex = sideSlots[i];
	    MachineFluidTank tank = this.getTankInSlot(slotIndex);
	    if (tank.output && tank.getFluidAmount() > 0) {
		return tank;
	    }
	}
	return null;
    }
    protected void onTanksChanged() {
    	for(int i  = 0;i<fluidTanks.size();i++){
    	System.out.println(fluidTanks.get(i).getFluidAmount());
    	}
    	this.onInventoryChanged();
    	super.notifyBlockChange();
    }

	@Override
	public boolean tankContains(int slot, int itemId, int amount) {
		MachineFluidTank tank = getTankInSlot(slot);
		if (tank == null)
		    return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
		    return false;
		return stack.fluidID == itemId && stack.amount >= amount;
	}

	@Override
	public boolean tankHasRoomFor(int slot, FluidStack addStack) {
		MachineFluidTank tank = getTankInSlot(slot);
		if (tank == null)
		    return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
		    return true;
		return stack.isFluidEqual(addStack) && stack.amount + addStack.amount <= tank.getCapacity();
	}

    @Override
    public boolean tankHasRoomFor(int slot, int itemId, int amount) {
	MachineFluidTank tank = getTankInSlot(slot);
	if (tank == null)
	    return false;
	FluidStack stack = tank.getFluid();
	if (stack == null)
	    return true;
	return stack.fluidID == itemId && stack.amount + amount <= tank.getCapacity();
    }

    @Override
    public boolean addToTank(int index, int itemId, int amount) {
	MachineFluidTank tank = getTankInSlot(index);
	if (tank == null)
	    return false;
	FluidStack stack = tank.getFluid();
	FluidStack newStack = new FluidStack(itemId, amount);
	if (stack == null) {
	    tank.setFluid(newStack);
	    super.notifyBlockChange();
	    return true;
	} else if (stack.fluidID == itemId && stack.amount + amount < tank.getCapacity()) {
	    tank.fill(newStack, true);
	    onTanksChanged();
	    return true;
	}
	return false;
    }

    @Override
    public boolean removeFromTank(int index, int itemId, int amount) {
	MachineFluidTank tank = getTankInSlot(index);
	if (tank == null)
	    return false;
	FluidStack stack = tank.getFluid();
	if (stack == null)
	    return false;
	if (stack.fluidID == itemId && stack.amount >= amount) {
	    tank.drain(amount, true);
	    onTanksChanged();
	    return true;
	}
	return false;
    }
    public int getTankCount() {
    	return this.fluidTanks.size();
    }
	public boolean canPipeConnect(TileEntity tile, ForgeDirection side) {
		return false;
	}

	@Override
	public boolean senseSide(World world, ForgeDirection dir){
		TileEntity entity =  world.getBlockTileEntity(this.xCoord + dir.offsetX,this.yCoord + dir.offsetY,this.zCoord + dir.offsetZ);
		if (entity == null) return false;
		if (entity instanceof IFluidHandler || entity instanceof IPipe){System.out.println(dir.toString()); return true;}
		return false;
	}

	public void setNeighborChanged(boolean b) {
		neighborChanged = b;
	}
	public boolean isNeighborChanged() {
		return neighborChanged;
	}

}

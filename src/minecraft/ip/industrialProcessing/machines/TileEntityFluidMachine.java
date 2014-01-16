package ip.industrialProcessing.machines;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.api.tanks.IPfluidTank;
import ip.industrialProcessing.api.tanks.ITank;
import ip.industrialProcessing.machines.containers.IFluidMachineContainerEntity;
import ip.industrialProcessing.subMod.logic.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.utils.DirectionUtils;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;

public abstract class TileEntityFluidMachine extends TileEntityMachine implements ITank, IMachineTanks, IFluidMachineContainerEntity {

	private int[][] fluidTankSideslots = new int[6][0];
	private ArrayList<IPfluidTank> fluidTanks = new ArrayList<IPfluidTank>();

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeTanks(nbt);
	};

	private void writeTanks(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.fluidTanks.size(); ++i) {
			IPfluidTank tank = this.fluidTanks.get(i);
			NBTTagCompound nbttagcompound1 = new NBTTagCompound();
			nbttagcompound1.setByte("Slot", (byte) i);
			tank.writeToNBT(nbttagcompound1);
			nbttaglist.appendTag(nbttagcompound1);
		}
		nbt.setTag("Tanks", nbttaglist);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readTanks(nbt);
	};

	private void readTanks(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Tanks");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.fluidTanks.size()) {
				IPfluidTank machineTank = this.fluidTanks.get(b0);
				machineTank.readFromNBT(nbttagcompound1);
			}
		}
	}

	protected void getBucketFromTank(int inputSlot, int outputSlot, int tankSlot) {
		if (!this.worldObj.isRemote) {
			ItemStack bucketOutputStack = getStackInSlot(outputSlot);
			if (bucketOutputStack == null) {
				ItemStack inputStack = getStackInSlot(inputSlot);
				if (inputStack != null) {
					FluidTank tank = getTankInSlot(tankSlot);
					if (tank != null) {
						ItemStack singleItem = inputStack.copy();
						singleItem.stackSize = 1;

						FluidStack fluid = tank.getFluid();
						ItemStack filled = FluidContainerRegistry.fillFluidContainer(fluid, singleItem);

						if (filled != null) {
							FluidStack removeFluid = FluidContainerRegistry.getFluidForFilledItem(filled);
							tank.drain(removeFluid.amount, true);
							this.decrStackSize(inputSlot, 1);
							setInventorySlotContents(outputSlot, filled);
							onTanksChanged();
						}
					}
				}
			}
		}
	}

	protected void addBucketToTank(int inputSlot, int outputSlot, int tankSlot) {
		if (!this.worldObj.isRemote) {
			ItemStack bucketOutputStack = getStackInSlot(outputSlot);
			if (bucketOutputStack == null) // output available
			{
				ItemStack inputStack = getStackInSlot(inputSlot);
				FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(inputStack);
				if (fluid != null) {
					if (isTankValidForFluid(tankSlot, fluid.fluidID)) {

						ItemStack emptyContainer = getEmptyContainerFromContainer(inputStack);
						if (emptyContainer != null) {
							if (this.tankHasRoomFor(tankSlot, fluid)) {
								emptyContainer.stackSize = 1;
								this.decrStackSize(inputSlot, 1);
								getTankInSlot(tankSlot).fill(fluid, true);
								this.setInventorySlotContents(outputSlot, emptyContainer);
								onTanksChanged();
							}
						}
					}
				}
			}
		}
	}

	private ItemStack getEmptyContainerFromContainer(ItemStack stack) {
		FluidContainerData[] data = FluidContainerRegistry.getRegisteredFluidContainerData();
		for (int i = 0; i < data.length; i++) {
			FluidContainerData containerData = data[i];
			if (containerData.filledContainer.isItemEqual(stack))
				return containerData.emptyContainer.copy();
		}
		return null;
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

		fluidTanks.add(new IPfluidTank(this, capacity,index, sideIndices, input, output));

		for (int i = 0; i < sideIndices.length; i++) {
			int sideIndex = sideIndices[i];
			int[] slots = fluidTankSideslots[sideIndex];
			int[] newSlots = new int[slots.length + 1];
			System.arraycopy(slots, 0, newSlots, 0, slots.length);
			newSlots[slots.length] = index;
			fluidTankSideslots[sideIndex] = newSlots;
		}
	}

	public IPfluidTank getTankInSlot(int i) {
		if (i < 0 || i > this.fluidTanks.size())
			return null;
		return this.fluidTanks.get(i);
	}

	protected abstract boolean isTankValidForFluid(int slot, int fluidId);

	public FluidTankInfo getFluidTankInfoForSlot(int slot) {
		IPfluidTank tank = getFluidTankForSlot(slot);
		if (tank == null)
			return null;
		return tank.getInfo();
	}

	private IPfluidTank getFluidTankForSlot(int slot) {
		if (slot < 0 || slot > fluidTanks.size())
			return null;
		return this.fluidTanks.get(slot);
	}

	private FluidTank getInputTankForFluid(ForgeDirection from, Fluid resource) {
		if (resource == null)
			return null;
		LocalDirection localFrom = DirectionUtils.getLocalDirection(from, getForwardDirection());
		int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			if (isTankValidForFluid(slotIndex, resource.getID())) {
				IPfluidTank tank = this.getTankInSlot(slotIndex);
				if (tank.input) { // tank remains an input tank, even if full:
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
		LocalDirection localFrom = DirectionUtils.getLocalDirection(from, getForwardDirection());
		int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			if (isTankValidForFluid(slotIndex, resource.fluidID)) {
				IPfluidTank tank = this.getTankInSlot(slotIndex);
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
		LocalDirection localFrom = DirectionUtils.getLocalDirection(from, getForwardDirection());
		int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			IPfluidTank tank = this.getTankInSlot(slotIndex);
			if (tank.output) { // tank remains an output tank, even if empty
				FluidStack tankFluid = tank.getFluid();
				if (tankFluid != null && tankFluid.fluidID == resource.getID()) {
					return tank;
				}
			}

		}
		return null;
	}

	private FluidTank getOutputTankForFluidStack(ForgeDirection from, FluidStack resource) {
		if (resource == null)
			return null;
		LocalDirection localFrom = DirectionUtils.getLocalDirection(from, getForwardDirection());
		int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			IPfluidTank tank = this.getTankInSlot(slotIndex);
			if (tank.output && tank.getFluidAmount() > 0) {
				FluidStack tankFluid = tank.getFluid();
				if (tankFluid.isFluidEqual(resource)) {
					return tank;
				}
			}
		}
		return null;
	}

	private FluidTank getOutputTank(ForgeDirection from) {
		LocalDirection localFrom = DirectionUtils.getLocalDirection(from, getForwardDirection());
		int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			IPfluidTank tank = this.getTankInSlot(slotIndex);
			if (tank.output && tank.getFluidAmount() > 0) {
				return tank;
			}
		}
		return null;
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
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		FluidTank tank = getOutputTankForFluidStack(from, resource);
		if (tank == null)
			return null;
		FluidStack amount = tank.drain(resource.amount, doDrain);
		if (doDrain)
			onTanksChanged();
		return amount;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {

		FluidTank tank = getOutputTank(from);
		if (tank == null)
			return null;
		FluidStack amount = tank.drain(maxDrain, doDrain);
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
		FluidTank tank = getOutputTankForFluid(from, fluid);
		return tank != null;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		LocalDirection localFrom = DirectionUtils.getLocalDirection(from, getForwardDirection());
		int[] sides = this.fluidTankSideslots[localFrom.ordinal()];

		FluidTankInfo[] tanks = new FluidTankInfo[sides.length];
		for (int i = 0; i < sides.length; i++) {
			tanks[i] = getTankInSlot(sides[i]).getInfo();
		}
		return tanks;
	}

	@Override
	public boolean tankContains(int slot, int itemId, int amount) {
		IPfluidTank tank = getTankInSlot(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return false;
		return stack.fluidID == itemId && stack.amount >= amount;
	}

	@Override
	public boolean tankHasRoomFor(int slot, FluidStack addStack) {
		IPfluidTank tank = getTankInSlot(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return true;
		return stack.isFluidEqual(addStack) && stack.amount + addStack.amount <= tank.getCapacity();
	}

	@Override
	public boolean tankHasRoomFor(int slot, int itemId, int amount) {
		IPfluidTank tank = getTankInSlot(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return true;
		return stack.fluidID == itemId && stack.amount + amount <= tank.getCapacity();
	}

	@Override
	public boolean addToTank(int index, int itemId, int amount) {
		IPfluidTank tank = getTankInSlot(index);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		FluidStack newStack = new FluidStack(itemId, amount);
		if (stack == null) {
			tank.setFluid(newStack);
			onTanksChanged();
			return true;
		} else if (stack.fluidID == itemId && stack.amount + amount <= tank.getCapacity()) {
			tank.fill(newStack, true);
			onTanksChanged();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeFromTank(int index, int itemId, int amount) {
		IPfluidTank tank = getTankInSlot(index);
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

	protected void onTanksChanged() {
		this.onInventoryChanged(); 
	}

	@Override
	public FluidTankInfo getTankInfoForSlot(int slot) {
		IPfluidTank tank = this.getTankInSlot(slot);
		if (tank != null)
			return tank.getInfo();
		return null;
	}

	public int getTankCount() {
		return this.fluidTanks.size();
	}

	@Override
	public FluidTankInfo[] getTanks() {
		FluidTankInfo[] info = new FluidTankInfo[this.fluidTanks.size()];
		for (int i = 0; i < info.length; i++) {
			info[i] = this.fluidTanks.get(i).getInfo();
		}
		return info;
	}

	@Override
	public float getPressure(ForgeDirection from) {
		FluidTankInfo[] info = getTankInfo(from);
		float pressure = 0;
		for (int i = 0; i < info.length; i++) {
			FluidTankInfo tank = info[i];
			if(tank.fluid != null)
			{
				pressure += (float)tank.fluid.amount / tank.capacity;
			}
		}
		return pressure * 500 / info.length;
	}
	
	@Override
	public void addPressure(ForgeDirection from, float pressure) { 
	}
	
    @Override
    public InterfaceType[] getConnectionTypes(){
    	return new InterfaceType[]{InterfaceType.single,InterfaceType.inventory,InterfaceType.tank};
    };
    
    @Override
    public IPfluidTank getTank(int index) {
    	if(fluidTanks.size() > index)
    		return fluidTanks.get(index);
    	return null;
    }
}

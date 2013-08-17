package ip.industrialProcessing.multiblock.extended.inventory.tank;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.tank.MultiblockTank;

public class TileEntityMultiblockCoreTank extends TileEntityMultiblockCoreInv {
	private ArrayList<MultiblockTank> fluidTanks = new ArrayList<MultiblockTank>();

	public TileEntityMultiblockCoreTank(MultiblockLayout structure) {
		super(structure);
	}

	protected void addTank(int capacity, boolean input, boolean output) {
		fluidTanks.add(new MultiblockTank(this, capacity, input, output));
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeTanks(nbt);
	};

	private void writeTanks(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.fluidTanks.size(); ++i) {
			MultiblockTank tank = this.fluidTanks.get(i);
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
				MultiblockTank machineTank = this.fluidTanks.get(b0);
				machineTank.readFromNBT(nbttagcompound1);
			}
		}
	}

	protected void getBucketFromTank(int inputSlot, int outputSlot, int tankSlot) {
		ItemStack bucketOutputStack = getStackInSlot(outputSlot);
		if (bucketOutputStack == null) {
			ItemStack inputStack = getStackInSlot(inputSlot);
			if (inputStack != null) {
				FluidTank tank = fluidTanks.get(tankSlot);
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

	protected void addBucketToTank(int inputSlot, int outputSlot, int tankSlot) {

		ItemStack bucketOutputStack = getStackInSlot(outputSlot);
		if (bucketOutputStack == null) // output available
		{
			ItemStack inputStack = getStackInSlot(inputSlot);
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(inputStack);
			if (fluid != null) {
				//if (isTankValidForFluid(tankSlot, fluid.fluidID)) {

					ItemStack emptyContainer = getEmptyContainerFromContainer(inputStack);
					if (emptyContainer != null) {
						if (this.tankHasRoomFor(tankSlot, fluid)) {
							emptyContainer.stackSize = 1;
							this.decrStackSize(inputSlot, 1);
							fluidTanks.get(tankSlot).fill(fluid, true);
							this.setInventorySlotContents(outputSlot, emptyContainer);
							onTanksChanged();
						}
					}
				//}
			}
		}
	}
	
    public boolean tankHasRoomFor(int slot, FluidStack addStack) {
	MultiblockTank tank = fluidTanks.get(slot);
	if (tank == null)
	    return false;
	FluidStack stack = tank.getFluid();
	if (stack == null)
	    return true;
	return stack.isFluidEqual(addStack) && stack.amount + addStack.amount <= tank.getCapacity();
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

	public int fill(int tankSlot, FluidStack resource, boolean doFill) {
		FluidTank tank = fluidTanks.get(tankSlot);
		if (tank == null)
			return 0;
		int amount = tank.fill(resource, doFill);
		if (doFill)
			onTanksChanged();
		return amount;
	}

	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		FluidTankInfo[] info = new FluidTankInfo[this.fluidTanks.size()];
		for (int i = 0; i < info.length; i++) {
			info[i] = this.fluidTanks.get(i).getInfo();
		}
		return info;
	}

	protected void onTanksChanged() {
		this.onInventoryChanged();
		super.notifyBlockChange();
	}

	public FluidStack drain(int tankSlot, FluidStack resource, boolean doDrain) {
		FluidTank tank = fluidTanks.get(tankSlot);
		if (tank == null)
			return null;
		FluidStack amount = tank.drain(resource.amount, doDrain);
		if (doDrain)
			onTanksChanged();
		return amount;
	}

	public FluidStack drain(int tankSlot, int maxDrain, boolean doDrain) {
		FluidTank tank = fluidTanks.get(tankSlot);
		if (tank == null)
			return null;
		FluidStack amount = tank.drain(maxDrain, doDrain);
		if (doDrain)
			onTanksChanged();
		return amount;
	}

	public boolean canDrain(int tankSlot, Fluid fluid) {
		// TODO dependent on worker
		return true;
	}

	public boolean canFill(int tankSlot, Fluid fluid) {
		// TODO dependent on worker
		return true;
	}

	public int firstValidTankID(boolean isInput) {
		for (int i = 0; i < fluidTanks.size(); i++) {
			if (fluidTanks.get(i).getIsInput() == isInput) {
				return i;
			}
		}
		return -1;
	}

	public FluidTankInfo getFluidTankInfoForSlot(int slot) {
		return this.fluidTanks.get(slot).getInfo();
	}

	public int prevValidTankID(int inventoryID) {
		boolean isInput = fluidTanks.get(inventoryID).getIsInput();

		for (int i = inventoryID - 1; i >= 0; i--) {
			if (fluidTanks.get(i).getIsInput() == isInput) {
				return i;
			}
		}
		return inventoryID;
	}

	public int nextValidTankID(int inventoryID) {
		boolean isInput = fluidTanks.get(inventoryID).getIsInput();

		for (int i = inventoryID + 1; i < fluidTanks.size(); i++) {
			if (fluidTanks.get(i).getIsInput() == isInput) {
				return i;
			}
		}
		return inventoryID;
	}

}

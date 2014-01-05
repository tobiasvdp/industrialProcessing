package ip.industrialProcessing.multiblock.core.extend;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.api.tanks.IPfluidTank;
import ip.industrialProcessing.api.tanks.ITank;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.utils.tanks.IMultiblockFluidTank;
import ip.industrialProcessing.multiblock.utils.tanks.IMultiblockTanks;
import ip.industrialProcessing.multiblock.utils.tanks.MultiblockFluidTank;

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
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;

public abstract class TileEntityMultiblockCoreTank extends TileEntityMultiblockCoreInv implements ITank, IMultiblockTanks {

	public ArrayList<MultiblockFluidTank> fluidTanks = new ArrayList<MultiblockFluidTank>();

	public TileEntityMultiblockCoreTank(StructureMultiblock structure, TierCollection tierRequirments, RecipesMultiblock recipes) {
		super(structure, tierRequirments, recipes);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeTanks(nbt);
	};
	
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
							onInventoryChanged();
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
					if (isTankValidForFluid(-1,tankSlot, fluid.fluidID)) {

						ItemStack emptyContainer = getEmptyContainerFromContainer(inputStack);
						if (emptyContainer != null) {
							if (this.tankHasRoomFor(tankSlot, fluid)) {
								emptyContainer.stackSize = 1;
								this.decrStackSize(inputSlot, 1);
								getTankInSlot(tankSlot).fill(fluid, true);
								this.setInventorySlotContents(outputSlot, emptyContainer);
								onInventoryChanged();
							}
						}
					}
				}
			}
		}
	}
	protected void addTank(int capacity, int multiblockID, ForgeDirection[] sides, boolean input, boolean output) {
		int index = fluidTanks.size();

		int[] sideIndices = new int[sides.length];
		for (int i = 0; i < sideIndices.length; i++) {
			sideIndices[i] = sides[i].ordinal();
		}

		fluidTanks.add(new MultiblockFluidTank(this, capacity, index, sideIndices, input, output, multiblockID));
	}

	public void writeTanks(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.fluidTanks.size(); ++i) {
			MultiblockFluidTank tank = this.fluidTanks.get(i);
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

	public void readTanks(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Tanks");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.fluidTanks.size()) {
				MultiblockFluidTank tank = this.fluidTanks.get(b0);
				tank.readFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
	public float getPressure(ForgeDirection from) {
		return getPressure(0, from);
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return fill(0, from, resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		return drain(0, from, resource, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return drain(0, from, maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		System.out.println("TEmultiblockCoreTank.canFill() " + canFill(0, from, fluid));
		return canFill(0, from, fluid);
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return canDrain(0, from, fluid);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return getTankInfo(0, from);
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
	public int fill(int multiblockID, ForgeDirection from, FluidStack resource, boolean doFill) {
		if (resource != null) {
			int amount = 0;
			int totalAmount = resource.amount;
			MultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
			for (int i = 0; i < tanks.length; i++) {
				if (tanks[i] == null || !tanks[i].input)
					return 0;
				amount += tanks[i].fill(resource, doFill);
				if (doFill)
					onInventoryChanged();
				if (amount == resource.amount)
					return amount;
				else
					resource.amount = totalAmount - amount;
			}
			return amount;
		} else {
			return 0;
		}
	}

	@Override
	public FluidStack drain(int multiblockID, ForgeDirection from, FluidStack resource, boolean doDrain) {
		MultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		if (tanks[0] == null || !tanks[0].output)
			return null;
		FluidStack amount = tanks[0].drain(resource.amount, doDrain);
		if (doDrain)
			onInventoryChanged();
		return amount;
	}

	@Override
	public FluidStack drain(int multiblockID, ForgeDirection from, int maxDrain, boolean doDrain) {

		MultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		if (tanks[0] == null || !tanks[0].output)
			return null;
		FluidStack amount = tanks[0].drain(maxDrain, doDrain);
		if (doDrain)
			onInventoryChanged();
		return amount;
	}

	@Override
	public boolean canFill(int multiblockID, ForgeDirection from, Fluid fluid) {
		MultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		for (int i = 0; i < tanks.length; i++) {
			if (tanks[i].input && isTankValidForFluid(multiblockID,tanks[i].slot, fluid.getID()))
				return true;
		}
		return false;
	}

	protected abstract boolean isTankValidForFluid(int groupid,int slot, int fluidId);

	@Override
	public boolean canDrain(int multiblockID, ForgeDirection from, Fluid fluid) {
		MultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		for (int i = 0; i < tanks.length; i++) {
			if (tanks[i].output)
				return true;
		}
		return false;
	}

	private MultiblockFluidTank[] getTanksOnSide(int multiblockID, ForgeDirection from) {
		from = ForgeDirection.getOrientation(transformSideToLayoutSide(from.ordinal()));
		ArrayList<MultiblockFluidTank> tanks = new ArrayList<MultiblockFluidTank>();
		for (int i = 0; i < fluidTanks.size(); i++) {
			MultiblockFluidTank fluidTank = fluidTanks.get(i);
			if (fluidTank.getMultiblockID() == multiblockID && fluidTank.isConnectedToSide(from)) {
				tanks.add(fluidTank);
			}
		}
		MultiblockFluidTank[] tank = new MultiblockFluidTank[tanks.size()];
		for (int i = 0; i < tank.length; i++) {
			tank[i] = tanks.get(i);
		}
		return tank;
	}

	@Override
	public FluidTankInfo[] getTankInfo(int multiblockID, ForgeDirection from) {
		MultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		FluidTankInfo[] tanksInfo = new FluidTankInfo[tanks.length];
		for (int i = 0; i < tanks.length; i++) {
			tanksInfo[i] = tanks[i].getInfo();
		}
		return tanksInfo;
	}

	@Override
	public float getPressure(int multiblockID, ForgeDirection from) {
		FluidTankInfo[] info = getTankInfo(multiblockID, from);
		float pressure = 0;
		for (int i = 0; i < info.length; i++) {
			FluidTankInfo tank = info[i];
			if (tank.fluid != null) {
				pressure += (float) tank.fluid.amount / tank.capacity;
			}
		}
		return pressure * 500 / info.length;
	}
	
	@Override
	public void addPressure(ForgeDirection from, float pressure) { 
	}
	
	public MultiblockFluidTank getTankInSlot(int i) {
		if (i < 0 || i > this.fluidTanks.size())
			return null;
		return this.fluidTanks.get(i);
		
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
	
	public boolean tankHasRoomFor(int slot, FluidStack addStack) {
		IPfluidTank tank = getTankInSlot(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return true;
		return stack.isFluidEqual(addStack) && stack.amount + addStack.amount <= tank.getCapacity();
	}

	public boolean tankHasRoomFor(int slot, int itemId, int amount) {
	    IPfluidTank tank = getTankInSlot(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return true;
		return stack.fluidID == itemId && stack.amount + amount <= tank.getCapacity();
	}
	
	public boolean tankContains(int slot, int itemId, int amount) {
		IPfluidTank tank = getTankInSlot(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return false;
		return stack.fluidID == itemId && stack.amount >= amount;
	}

	public boolean addToTank(int index, int itemId, int amount) {
		IPfluidTank tank = getTankInSlot(index);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		FluidStack newStack = new FluidStack(itemId, amount);
		if (stack == null) {
			tank.setFluid(newStack);
			onInventoryChanged();
			return true;
		} else if (stack.fluidID == itemId && stack.amount + amount <= tank.getCapacity()) {
			tank.fill(newStack, true);
			onInventoryChanged();
			return true;
		}
		return false;
	}

	public boolean removeFromTank(int index, int itemId, int amount) {
		IPfluidTank tank = getTankInSlot(index);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return false;
		if (stack.fluidID == itemId && stack.amount >= amount) {
			tank.drain(amount, true);
			onInventoryChanged();
			return true;
		}
		return false;
	}
}

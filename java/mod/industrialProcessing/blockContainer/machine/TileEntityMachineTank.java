package mod.industrialProcessing.blockContainer.machine;

import java.util.ArrayList;

import mod.industrialProcessing.utils.fluids.tank.IPfluidTank;
import mod.industrialProcessing.utils.fluids.tank.ITank;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;

public abstract class TileEntityMachineTank extends TileEntityMachineInv implements ITank {

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
			if (tank != null && tank.getFluidAmount() > 0) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				tank.writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Tanks", nbttaglist);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readTanks(nbt);
	};

	private void readTanks(NBTTagCompound nbt) {
		for (int i = 0; i < fluidTanks.size(); i++) {
			fluidTanks.get(i).setFluid(null);
		}
		NBTTagList nbttaglist = nbt.getTagList("Tanks", 0);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.fluidTanks.size()) {
				IPfluidTank machineTank = this.fluidTanks.get(b0);
				machineTank.readFromNBT(nbttagcompound1);
			}
		}
	}

	private void onTanksChanged() {
		markDirty();
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

	@Override
	public float getPressure(ForgeDirection from) {
		FluidTankInfo[] info = getTankInfo(from);
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

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		FluidTank tank = getInputTankForFluid(from, resource.getFluid());
		if (tank == null)
			return 0;
		int amount = tank.fill(resource, doFill);
		if (doFill)
			onTanksChanged();
		return amount;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		FluidTank tank = getOutputTankForFluid(from, resource.getFluid());
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

	private FluidTank getOutputTank(ForgeDirection from) {
		LocalDirection localFrom = getLocalDirection(from);
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

	protected void addTank(int capacity, LocalDirection side, boolean input, boolean output) {
		addTank(capacity, new LocalDirection[] { side }, input, output);
	}

	protected void addTank(int capacity, LocalDirection[] sides, boolean input, boolean output) {
		int index = fluidTanks.size();

		int[] sideIndices = new int[sides.length];
		for (int i = 0; i < sideIndices.length; i++) {
			sideIndices[i] = sides[i].ordinal();
		}

		fluidTanks.add(new IPfluidTank(this, capacity, index, sideIndices, input, output));

		for (int i = 0; i < sideIndices.length; i++) {
			int sideIndex = sideIndices[i];
			int[] slots = fluidTankSideslots[sideIndex];
			int[] newSlots = new int[slots.length + 1];
			System.arraycopy(slots, 0, newSlots, 0, slots.length);
			newSlots[slots.length] = index;
			fluidTankSideslots[sideIndex] = newSlots;
		}
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		FluidTank tank = getInputTankForFluid(from, fluid);
		return tank != null;
	}

	private FluidTank getInputTankForFluid(ForgeDirection from, Fluid resource) {
		if (resource == null)
			return null;
		LocalDirection localFrom = getLocalDirection(from);
		int[] sideSlots = fluidTankSideslots[localFrom.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			if (isTankValidForFluid(slotIndex, resource)) {
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

	protected abstract boolean isTankValidForFluid(int slot, Fluid fluid);

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		FluidTank tank = getOutputTankForFluid(from, fluid);
		return tank != null;
	}

	private FluidTank getOutputTankForFluid(ForgeDirection from, Fluid resource) {
		if (resource == null)
			return null;
		LocalDirection localFrom = getLocalDirection(from);
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

	public IPfluidTank getTankInSlot(int i) {
		if (i < 0 || i > this.fluidTanks.size())
			return null;
		return this.fluidTanks.get(i);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		LocalDirection localFrom = getLocalDirection(from);
		int[] sides = this.fluidTankSideslots[localFrom.ordinal()];

		FluidTankInfo[] tanks = new FluidTankInfo[sides.length];
		for (int i = 0; i < sides.length; i++) {
			tanks[i] = getTankInSlot(sides[i]).getInfo();
		}
		return tanks;
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
	public IPfluidTank getTank(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}

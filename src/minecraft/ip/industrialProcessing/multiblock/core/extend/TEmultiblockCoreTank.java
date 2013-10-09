package ip.industrialProcessing.multiblock.core.extend;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.api.tanks.IPfluidTank;
import ip.industrialProcessing.api.tanks.ITank;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.utils.tanks.IIPMultiblockFluidTank;
import ip.industrialProcessing.multiblock.utils.tanks.IMultiblockTanks;
import ip.industrialProcessing.multiblock.utils.tanks.IPMultiblockFluidTank;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public abstract class TEmultiblockCoreTank extends TEmultiblockCoreInv implements ITank, IMultiblockTanks {

	public ArrayList<IPMultiblockFluidTank> fluidTanks = new ArrayList<IPMultiblockFluidTank>();

	public TEmultiblockCoreTank(StructureMultiblock structure, TierCollection tierRequirments, RecipesMachine recipe) {
		super(structure, tierRequirments, recipe);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeTanks(nbt);
	};

	protected void addTank(int capacity, int multiblockID, ForgeDirection[] sides, boolean input, boolean output) {
		int index = fluidTanks.size();

		int[] sideIndices = new int[sides.length];
		for (int i = 0; i < sideIndices.length; i++) {
			sideIndices[i] = sides[i].ordinal();
		}

		fluidTanks.add(new IPMultiblockFluidTank(this, capacity, index, sideIndices, input, output, multiblockID));
	}

	public void writeTanks(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.fluidTanks.size(); ++i) {
			IPMultiblockFluidTank tank = this.fluidTanks.get(i);
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
				IPMultiblockFluidTank tank = this.fluidTanks.get(b0);
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
			IPMultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
			for (int i = 0; i < tanks.length; i++) {
				if (tanks[i] == null)
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
		int totalAmount = 0;
		IPMultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		for (int i = 0; i < tanks.length; i++) {
			if (tanks[i] == null)
				return null;
			FluidStack stack = tanks[i].drain(resource.amount, doDrain);
			totalAmount += stack.amount;
			resource.amount = resource.amount - stack.amount;

		}
		if (doDrain)
			onInventoryChanged();
		return new FluidStack(resource.fluidID, totalAmount);
	}

	@Override
	public FluidStack drain(int multiblockID, ForgeDirection from, int maxDrain, boolean doDrain) {
		int totalAmount = 0;
		IPMultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		for (int i = 0; i < tanks.length; i++) {
			if (tanks[i] != null && tanks[i].output) {
				FluidStack stack = tanks[i].drain(maxDrain, doDrain);
				totalAmount += stack.amount;
				maxDrain -= stack.amount;
			}
		}
		if (doDrain)
			onInventoryChanged();
		return new FluidStack(tanks[0].getFluid(), totalAmount);
	}

	@Override
	public boolean canFill(int multiblockID, ForgeDirection from, Fluid fluid) {
		IPMultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		for (int i = 0; i < tanks.length; i++) {
			if (tanks[i].input && isTankValidForFluid(tanks[i].slot, fluid.getID()))
				return true;
		}
		return false;
	}

	protected abstract boolean isTankValidForFluid(int slot, int fluidId);

	@Override
	public boolean canDrain(int multiblockID, ForgeDirection from, Fluid fluid) {
		IPMultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
		for (int i = 0; i < tanks.length; i++) {
			if (tanks[i].output)
				return true;
		}
		return false;
	}

	private IPMultiblockFluidTank[] getTanksOnSide(int multiblockID, ForgeDirection from) {
		from = ForgeDirection.getOrientation(transformSideToLayoutSide(from.ordinal()));
		ArrayList<IPMultiblockFluidTank> tanks = new ArrayList<IPMultiblockFluidTank>();
		for (int i = 0; i < fluidTanks.size(); i++) {
			IPMultiblockFluidTank fluidTank = fluidTanks.get(i);
			if (fluidTank.getMultiblockID() == multiblockID && fluidTank.isConnectedToSide(from)) {
				tanks.add(fluidTank);
			}
		}
		IPMultiblockFluidTank[] tank = new IPMultiblockFluidTank[tanks.size()];
		for (int i = 0; i < tank.length; i++) {
			tank[i] = tanks.get(i);
		}
		return tank;
	}

	@Override
	public FluidTankInfo[] getTankInfo(int multiblockID, ForgeDirection from) {
		IPMultiblockFluidTank[] tanks = getTanksOnSide(multiblockID, from);
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
}

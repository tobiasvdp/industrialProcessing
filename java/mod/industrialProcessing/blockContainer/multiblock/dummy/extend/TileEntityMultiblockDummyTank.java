package mod.industrialProcessing.blockContainer.multiblock.dummy.extend;

import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCoreTank;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.fluids.tank.IPfluidTank;
import mod.industrialProcessing.fluids.tank.ITank;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public class TileEntityMultiblockDummyTank extends TileEntityMultiblockDummy implements ITank{
	public TileEntityMultiblockDummyTank() {
		super();
	}

	@Override
	public TileEntityMultiblockCoreTank getCore() {
		if (loadedFromNBT) {
			core = (TileEntityMultiblockCore) worldObj.getTileEntity(coreDataFromNBT[0], coreDataFromNBT[1], coreDataFromNBT[2]);
			loadedFromNBT = false;
		}
		return (TileEntityMultiblockCoreTank) core;
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (this.getCore() != null)
			return this.getCore().fill(getGroup(), from, resource, doFill);
		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (this.getCore() != null)
			return this.getCore().drain(getGroup(), from, resource, doDrain);
		return null;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (this.getCore() != null)
			return this.getCore().drain(getGroup(), from, maxDrain, doDrain);
		return null;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		if (this.getCore() != null)
			return this.getCore().canFill(getGroup(), from, fluid);
		return false;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		if (this.getCore() != null)
			return this.getCore().canDrain(getGroup(), from, fluid);
		return false;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		if (this.getCore() != null)
			return this.getCore().getTankInfo(getGroup(), from);
		return null;
	}

	@Override
	public float getPressure(ForgeDirection from) {
		if (this.getCore() != null)
			return this.getCore().getPressure(getGroup(), from);
		return 0;
	}

	@Override
	public void addPressure(ForgeDirection from, float pressure) {
		if (this.getCore() != null)
			 this.getCore().addPressure(from, pressure);
	}

	@Override
	public FluidTankInfo[] getTanks() {
		if (this.getCore() != null)
			return this.getCore().getTanks();
		return null;
	}

	@Override
	public IPfluidTank getTank(int index) {
		if (this.getCore() != null)
			return this.getCore().getTank(index);
		return null;
	}

	@Override
	public FluidTankInfo getTankInfoForSlot(int slot) {
		if (this.getCore() != null)
			return this.getCore().getTankInfoForSlot(slot);
		return null;
	}

	@Override
	public boolean tankContains(int slot, Fluid fluid, int amount) {
		if (this.getCore() != null)
			return this.getCore().tankContains(getGroup(),slot,fluid,amount);
		return false;
	}

	@Override
	public boolean tankHasRoomFor(int slot, FluidStack stack) {
		if (this.getCore() != null)
			return this.getCore().tankHasRoomFor(getGroup(),slot,stack);
		return false;
	}

	@Override
	public boolean tankHasRoomFor(int slot, Fluid fluid, int amount) {
		if (this.getCore() != null)
			return this.getCore().tankHasRoomFor(getGroup(),slot,fluid,amount);
		return false;
	}

	@Override
	public boolean addToTank(int index, Fluid fluid, int amount) {
		if (this.getCore() != null)
			return this.getCore().addToTank(getGroup(),index,fluid,amount);
		return false;
	}

	@Override
	public boolean removeFromTank(int index, Fluid fluid, int amount) {
		if (this.getCore() != null)
			return this.getCore().removeFromTank(getGroup(),index,fluid,amount);
		return false;
	}


}

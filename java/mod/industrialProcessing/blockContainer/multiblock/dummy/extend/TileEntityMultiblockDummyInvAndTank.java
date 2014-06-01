package mod.industrialProcessing.blockContainer.multiblock.dummy.extend;

import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCoreTank;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityMultiblockDummyInvAndTank extends TileEntityMultiblockDummyInv implements IFluidHandler {
	public TileEntityMultiblockDummyInvAndTank() {
		super();
	}

	@Override
	public TileEntityMultiblockCoreTank getCore() {
		if (loadedFromNBT) {
			if (worldObj.getTileEntity(coreDataFromNBT[0], coreDataFromNBT[1], coreDataFromNBT[2]) instanceof TileEntityMultiblockCore)
				core = (TileEntityMultiblockCore) worldObj.getTileEntity(coreDataFromNBT[0], coreDataFromNBT[1], coreDataFromNBT[2]);
			else
				return null;
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

	public boolean tankHasRoomFor(int i, FluidStack fluid) {
		if (this.getCore() != null)
			return this.getCore().tankHasRoomFor(i, fluid);
		return false;
	}

}

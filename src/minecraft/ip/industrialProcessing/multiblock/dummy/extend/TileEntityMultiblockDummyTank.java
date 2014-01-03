package ip.industrialProcessing.multiblock.dummy.extend;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTank;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;

public class TileEntityMultiblockDummyTank extends TEmultiblockDummy implements IFluidHandler {

	public TileEntityMultiblockDummyTank() {
		super();
	}

	@Override
	public TileEntityMultiblockCoreTank getCore() {
		if (loadedFromNBT) {
			core = (TileEntityMultiblockCore) worldObj.getBlockTileEntity(coreDataFromNBT[0], coreDataFromNBT[1], coreDataFromNBT[2]);
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

}

package ip.industrialProcessing.multiblock.dummy.extend;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTank;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;

public class TileEntityMultiblockDummyTank extends TEmultiblockDummy implements IFluidHandler {
	
	public TileEntityMultiblockDummyTank(){
		super();
	}
	
	@Override
	public TEmultiblockCoreTank getCore() {
		if (loadedFromNBT) {
			core = (TEmultiblockCore) worldObj.getBlockTileEntity(coreDataFromNBT[0], coreDataFromNBT[1], coreDataFromNBT[2]);
			loadedFromNBT = false;
		}
		return (TEmultiblockCoreTank) core;
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return this.getCore().fill(getGroup(),from, resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		return this.getCore().drain(getGroup(), from, resource, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return this.getCore().drain(getGroup(), from, maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return this.getCore().canFill(getGroup(), from, fluid);
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return this.getCore().canDrain(getGroup(), from, fluid);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return this.getCore().getTankInfo(getGroup(), from);
	}

}

package ip.industrialProcessing.multiblock.extended.inventory.tank;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;

public abstract class TileEntityMultiblockBlockTank extends TileEntityMultiblockBlockInv implements IFluidHandler {
	protected int tankSlot;
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return false;
	}
	
	@Override
	public TileEntityMultiblockCoreTank getCore() {
		return (TileEntityMultiblockCoreTank) worldObj.getBlockTileEntity(xCore, yCore, zCore);
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return getCore().fill(tankSlot, resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		return getCore().drain(tankSlot, resource, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return getCore().drain(tankSlot, maxDrain, doDrain);
	}
	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return getCore().getTankInfo(from);
	}

}

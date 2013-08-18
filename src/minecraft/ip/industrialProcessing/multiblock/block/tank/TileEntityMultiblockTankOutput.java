package ip.industrialProcessing.multiblock.block.tank;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import ip.industrialProcessing.multiblock.extended.inventory.tank.TileEntityMultiblockBlockTank;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TileEntityMultiblockTankOutput extends TileEntityMultiblockBlockTank {

	public TileEntityMultiblockTankOutput() {
		super();
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return false;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		if (state == MultiblockState.COMPLETED)
			return getCore().isTankValidForFluid(inventoryID, fluid.getBlockID());
		return false;
	}

	@Override
	public int firstValidID() {
		return getCore().firstValidTankID(false);
	}
}

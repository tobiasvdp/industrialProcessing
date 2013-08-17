package ip.industrialProcessing.multiblock.block.tank;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import ip.industrialProcessing.multiblock.extended.inventory.tank.TileEntityMultiblockBlockTank;

public class TileEntityMultiblockTankInput extends TileEntityMultiblockBlockTank{

	public TileEntityMultiblockTankInput(){
		super();
	}
	
	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return false;
	}

}

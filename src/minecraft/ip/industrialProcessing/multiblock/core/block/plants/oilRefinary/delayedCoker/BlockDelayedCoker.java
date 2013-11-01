package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;

public class BlockDelayedCoker extends BLmultiblockCore{
	public BlockDelayedCoker(){
		super(ConfigMachineBlocks.getBlockDelayedCokerID(), "BlockDelayedCoker", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDelayedCoker();
	}
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererDelayedCoker();
	}
}

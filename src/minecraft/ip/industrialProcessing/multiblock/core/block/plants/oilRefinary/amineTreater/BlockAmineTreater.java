package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;

public class BlockAmineTreater extends BLmultiblockCore {
	public BlockAmineTreater() {
		super(ConfigMachineBlocks.getBlockAmineTreaterID(), "BlockAmineTreater", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAmineTreater();
	}
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererAmineTreater();
	}
}

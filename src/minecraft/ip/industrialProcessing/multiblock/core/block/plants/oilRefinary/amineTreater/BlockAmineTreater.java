package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BlockAmineTreater extends BlockMultiblockCore {
	public BlockAmineTreater() {
		super(ConfigMachineBlocks.getBlockAmineTreaterID(), "BlockAmineTreater", ISetupCreativeTabs.tabMultiblocks);
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

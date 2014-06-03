package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.amineTreater;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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

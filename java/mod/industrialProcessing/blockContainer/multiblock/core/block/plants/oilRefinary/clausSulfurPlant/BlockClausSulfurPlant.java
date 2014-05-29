package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.clausSulfurPlant;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockClausSulfurPlant extends BlockMultiblockCore{
	public BlockClausSulfurPlant(){
		super(ConfigMachineBlocks.getBlockClausSulfurPlantID(), "BlockClausSulfurPlant", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityClausSulfurPlant();
	}
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererClausSulfurPlant();
	}
}

package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMeroxTreater extends BlockMultiblockCore{
public BlockMeroxTreater(){
	super(ConfigMachineBlocks.getBlockMeroxTreaterID(), "BlockMeroxTreater", ISetupCreativeTabs.tabMultiblocks);
}

@Override
public TileEntity createNewTileEntity(World world) {
	return new TileEntityMeroxTreater();
}
@Override
public int getRenderType() {
	return ConfigRenderers.getRendererMeroxTreater();
}
}

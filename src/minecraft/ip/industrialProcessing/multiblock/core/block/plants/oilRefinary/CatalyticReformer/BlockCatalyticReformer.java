package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.CatalyticReformer;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BlockCatalyticReformer extends BlockMultiblockCore{
public BlockCatalyticReformer(){
	super(ConfigMachineBlocks.getBlockCatalyticReformerID(), "BlockCatalyticReformer", ISetupCreativeTabs.tabMultiblocks);
}

@Override
public TileEntity createNewTileEntity(World world) {
	return new TileEntityCatalyticReformer();
}
@Override
public int getRenderType() {
	return ConfigRenderers.getRendererCatalyticReformer();
}
}

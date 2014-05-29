package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroCracker;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHydroCracker extends BlockMultiblockCore{
public BlockHydroCracker(){
	super(ConfigMachineBlocks.getBlockHydroCrackerID(), "BlockHydroCracker", ISetupCreativeTabs.tabMultiblocks);
}

@Override
public TileEntity createNewTileEntity(World world) {
	return new TileEntityHydroCracker();
}
@Override
public int getRenderType() {
	return ConfigRenderers.getRendererHydroCracker();
}
}

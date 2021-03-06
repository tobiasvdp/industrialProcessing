package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BlockHydroTreater extends BlockMultiblockCore{
public BlockHydroTreater(){
	super(ConfigMachineBlocks.getBlockHydroTreaterID(), "BlockHydroTreater", ISetupCreativeTabs.tabMultiblocks);
}

@Override
public TileEntity createNewTileEntity(World world) {
	return new TileEntityHydroTreater();
}
@Override
public int getRenderType() {
	return ConfigRenderers.getRendererHydroTreater();
}
}

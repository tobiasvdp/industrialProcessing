package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BlockVacuumDestilationTower extends BlockMultiblockCore{
public BlockVacuumDestilationTower(){
	super(ConfigMachineBlocks.getBlockVacuumDestilationTowerID(), "BlockVacuumDestilationTower", IndustrialProcessing.tabMultiblocks);
}

@Override
public TileEntity createNewTileEntity(World world) {
	return new TileEntityVacuumDestilationTower();
}
@Override
public int getRenderType() {
	return ConfigRenderers.getRendererVacuumDestilationTower();
}
}

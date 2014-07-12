package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.vacuumDestilationTower;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockVacuumDestilationTower extends BlockMultiblockCore{
public BlockVacuumDestilationTower(){
	super(ConfigMachineBlocks.getBlockVacuumDestilationTowerID(), "BlockVacuumDestilationTower", ISetupCreativeTabs.tabMultiblocks);
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

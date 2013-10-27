package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;

public class BlockAtmosphericDestilationTower extends BLmultiblockCore{
	public BlockAtmosphericDestilationTower() {
		super(ConfigMachineBlocks.getBlockAtmosphericDestilationTowerID(), "BlockAtmosphericDestilationTower", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAtmosphericDestilationTower();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererAtmosphericDestilationTower();
	}
}

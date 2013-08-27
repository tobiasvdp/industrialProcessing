package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;

public class BLmultiblockWeldingStation extends BLmultiblockCore{

	public BLmultiblockWeldingStation() {
		super(ConfigMachineBlocks.getBLmultiblockWeldingStation(), "BLmultiblockWeldingStation", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockWeldingStation();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWeldingStation();
	}
}

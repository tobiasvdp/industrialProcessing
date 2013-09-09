package ip.industrialProcessing.multiblock.dummy.block.weldingTableExt;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;

public class BLmultiblockWeldingTableExt extends BLmultiblockDummy{

	public BLmultiblockWeldingTableExt() {
		super(ConfigMachineBlocks.getBLmultiblockWeldingStationExt(), "MultiblockScreenExt", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWeldingTableExt();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockWeldingTableExt();
	}

}

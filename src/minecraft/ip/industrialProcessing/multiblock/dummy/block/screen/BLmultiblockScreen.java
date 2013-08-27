package ip.industrialProcessing.multiblock.dummy.block.screen;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;

public class BLmultiblockScreen extends BLmultiblockDummy{

	public BLmultiblockScreen() {
		super(ConfigMachineBlocks.getBLmultiblockScreen(), "MultiblockScreen", IndustrialProcessing.tabPower);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockScreen();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockScreen();
	}
}

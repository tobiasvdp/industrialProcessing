package ip.industrialProcessing.multiblock.dummy.block.screen;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

public class BLmultiblockScreen extends BlockMultiblockDummy{

	public BLmultiblockScreen() {
		super(ConfigMachineBlocks.getBLmultiblockScreen(), "MultiblockScreen", IndustrialProcessing.tabMultiblocks);
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

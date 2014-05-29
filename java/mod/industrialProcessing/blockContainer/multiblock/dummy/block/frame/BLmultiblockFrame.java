package ip.industrialProcessing.multiblock.dummy.block.frame;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockFrame extends BlockMultiblockDummy{

	public BLmultiblockFrame() {
		super(ConfigMachineBlocks.getBLmultiblockFrame(), "Multiblockframe", ISetupCreativeTabs.tabMultiblocks);
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockFrame();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockFrame();
	}

}

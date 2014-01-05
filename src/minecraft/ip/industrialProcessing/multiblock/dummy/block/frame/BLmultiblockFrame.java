package ip.industrialProcessing.multiblock.dummy.block.frame;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

public class BLmultiblockFrame extends BlockMultiblockDummy{

	public BLmultiblockFrame() {
		super(ConfigMachineBlocks.getBLmultiblockFrame(), "Multiblockframe", IndustrialProcessing.tabMultiblocks);
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

package ip.industrialProcessing.multiblock.dummy.block.frame;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;

public class BLmultiblockFrame extends BLmultiblockDummy{

	public BLmultiblockFrame() {
		super(ConfigMachineBlocks.getBLmultiblockFrame(), "Multiblockframe", IndustrialProcessing.tabPower);
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

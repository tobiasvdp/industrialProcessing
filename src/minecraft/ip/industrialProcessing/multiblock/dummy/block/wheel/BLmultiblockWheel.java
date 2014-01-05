package ip.industrialProcessing.multiblock.dummy.block.wheel;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

public class BLmultiblockWheel extends BlockMultiblockDummy{

	public BLmultiblockWheel() {
		super(ConfigMachineBlocks.getBLmultiblockWheel(), "BLmultiblockWheel", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockWheel();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWheel();
	}

}

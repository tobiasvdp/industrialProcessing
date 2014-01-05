package ip.industrialProcessing.multiblock.dummy.block.wheelConnector;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

public class BLmultiblockWheelConnector extends BlockMultiblockDummy {

	public BLmultiblockWheelConnector() {
		super(ConfigMachineBlocks.getBLmultiblockWheelConnector(), "BLmultiblockWheelConnector", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockWheelConnector();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWheelConnector();
	}

}

package mod.industrialProcessing.plants.todo.dummy.wheelConnector;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockWheelConnector extends BlockMultiblockDummy {

	public BLmultiblockWheelConnector() {
		super(ConfigMachineBlocks.getBLmultiblockWheelConnector(), "BLmultiblockWheelConnector", ISetupCreativeTabs.tabMultiblocks);
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

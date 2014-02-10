package ip.industrialProcessing.multiblock.dummy.block.liftDoor;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockLiftDoor extends BlockMultiblockDummy{

	public BLmultiblockLiftDoor() {
		super(ConfigMachineBlocks.getBLmultiblockLiftDoor(), "MultiblockLiftDoor", ISetupCreativeTabs.tabMultiblocks);
		this.setBlockBounds(1.0f, 2.0f, 1.0f, 1.0f, 2.0f, 1.0f);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockLiftDoor();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockLiftDoor();
	}

}

package mod.industrialProcessing.plants.todo.dummy.wheel;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockWheel extends BlockMultiblockDummy{

	public BLmultiblockWheel() {
		super(ConfigMachineBlocks.getBLmultiblockWheel(), "BLmultiblockWheel", ISetupCreativeTabs.tabMultiblocks);
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

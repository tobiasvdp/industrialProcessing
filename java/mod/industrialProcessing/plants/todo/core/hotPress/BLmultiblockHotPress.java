package mod.industrialProcessing.plants.todo.core.hotPress;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockHotPress extends BlockMultiblockCore{

	public BLmultiblockHotPress() {
		super(ConfigMachineBlocks.getBLmultiblockHotPress(), "MultiblockHotPress", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockHotPress();
	}

}

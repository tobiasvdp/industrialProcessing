package mod.industrialProcessing.plants.todo.core.rollingPress;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockRollingPress extends BlockMultiblockCore{

	public BLmultiblockRollingPress() {
		super(ConfigMachineBlocks.getBLmultiblockRollingPress(), "MultiblockRollingPress", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockRollingPress();
	}
	
	@Override
	public int getRenderType() {
		return 0;
	}

}

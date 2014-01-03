package ip.industrialProcessing.multiblock.core.block.rollingPress;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BLmultiblockRollingPress extends BlockMultiblockCore{

	public BLmultiblockRollingPress() {
		super(ConfigMachineBlocks.getBLmultiblockRollingPress(), "MultiblockRollingPress", IndustrialProcessing.tabMultiblocks);
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

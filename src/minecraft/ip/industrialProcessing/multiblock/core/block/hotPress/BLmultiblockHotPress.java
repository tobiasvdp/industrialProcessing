package ip.industrialProcessing.multiblock.core.block.hotPress;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;

public class BLmultiblockHotPress extends BlockMultiblockCore{

	public BLmultiblockHotPress() {
		super(ConfigMachineBlocks.getBLmultiblockHotPress(), "MultiblockHotPress", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockHotPress();
	}

}

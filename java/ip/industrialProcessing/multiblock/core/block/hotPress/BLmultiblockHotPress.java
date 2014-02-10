package ip.industrialProcessing.multiblock.core.block.hotPress;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BLmultiblockHotPress extends BlockMultiblockCore{

	public BLmultiblockHotPress() {
		super(ConfigMachineBlocks.getBLmultiblockHotPress(), "MultiblockHotPress", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockHotPress();
	}

}

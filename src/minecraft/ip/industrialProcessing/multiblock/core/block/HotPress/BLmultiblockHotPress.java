package ip.industrialProcessing.multiblock.core.block.HotPress;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;

public class BLmultiblockHotPress extends BLmultiblockCore{

	public BLmultiblockHotPress() {
		super(ConfigMachineBlocks.getBLmultiblockHotPress(), "MultiblockHotPress", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockHotPress();
	}

}

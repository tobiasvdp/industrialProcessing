package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;

public class BLmultiblockBlastFurnace  extends BLmultiblockCore{
	public BLmultiblockBlastFurnace() {
		super(ConfigMachineBlocks.getBLmultiblockBlastFurnace(), "BLmultiblockBlastFurnace", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockBlastFurnace();
	}
	@Override
	public int getRenderType() {
		return ConfigRenderers.getrendererMultiblockBlastFurnaceID();
	}

}

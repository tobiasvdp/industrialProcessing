package ip.industrialProcessing.multiblock.dummy.block.blastFurnaceTower;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;

public class BLmultiblockBlastFurnaceTower  extends BLmultiblockDummy{
	public BLmultiblockBlastFurnaceTower() {
		super(ConfigMachineBlocks.getBLmultiblockBlastFurnaceTower(), "BLmultiblockBlastFurnaceTower", IndustrialProcessing.tabMultiblocks);
	}
	@Override
	public int getRenderType() {
		return ConfigRenderers.getrendererMultiblockBlastFurnaceTowerID();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockBlastFurnaceTower();
	}
}

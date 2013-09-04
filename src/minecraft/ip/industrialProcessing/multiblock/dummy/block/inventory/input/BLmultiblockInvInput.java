package ip.industrialProcessing.multiblock.dummy.block.inventory.input;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.screen.TEmultiblockScreen;

public class BLmultiblockInvInput extends BLmultiblockDummy{

	public BLmultiblockInvInput() {
		super(ConfigMachineBlocks.getBLmultiblockInvInput(), "MultiblockInvInput", IndustrialProcessing.tabPower);
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockInvInput();
	}
	@Override
	public int getRenderType() {
		return 0;
	}
}

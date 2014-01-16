package ip.industrialProcessing.multiblock.dummy.block.inventory.input;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

public class BLmultiblockInvInput extends BlockMultiblockDummy{

	public BLmultiblockInvInput() {
		super(ConfigMachineBlocks.getBLmultiblockInvInput(), "MultiblockInvInput", ISetupCreativeTabs.tabMultiblocks);
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

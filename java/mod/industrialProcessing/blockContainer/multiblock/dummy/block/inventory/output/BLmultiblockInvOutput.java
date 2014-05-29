package ip.industrialProcessing.multiblock.dummy.block.inventory.output;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockInvOutput extends BlockMultiblockDummy{

	public BLmultiblockInvOutput() {
		super(ConfigMachineBlocks.getBLmultiblockInvOutput(), "MultiblockInvOutput", ISetupCreativeTabs.tabMultiblocks);
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockInvOutput();
	}

	@Override
	public int getRenderType() {
		return 0;
	}
}

package ip.industrialProcessing.multiblock.dummy.block.inventory.output;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.screen.TEmultiblockScreen;

public class BLmultiblockInvOutput extends BlockMultiblockDummy{

	public BLmultiblockInvOutput() {
		super(ConfigMachineBlocks.getBLmultiblockInvOutput(), "MultiblockInvOutput", IndustrialProcessing.tabMultiblocks);
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

package ip.industrialProcessing.multiblock.core.block.elevator;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLmultiblockElevator extends BlockMultiblockCore{

	public BLmultiblockElevator() {
		super(ConfigMachineBlocks.getBLmultiblockElevator(),"MultiblockElevator",ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockElevator();
	}

}

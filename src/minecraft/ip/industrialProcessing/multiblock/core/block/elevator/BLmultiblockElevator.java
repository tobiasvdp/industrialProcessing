package ip.industrialProcessing.multiblock.core.block.elevator;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BLmultiblockElevator extends BlockMultiblockCore{

	public BLmultiblockElevator() {
		super(ConfigMachineBlocks.getBLmultiblockElevator(),"MultiblockElevator",IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockElevator();
	}

}

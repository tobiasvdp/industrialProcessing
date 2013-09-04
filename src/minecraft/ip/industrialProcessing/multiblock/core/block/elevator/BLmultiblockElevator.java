package ip.industrialProcessing.multiblock.core.block.elevator;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;

public class BLmultiblockElevator extends BLmultiblockCore{

	public BLmultiblockElevator() {
		super(ConfigMachineBlocks.getBLmultiblockElevator(),"MultiblockElevator",IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockElevator();
	}

}

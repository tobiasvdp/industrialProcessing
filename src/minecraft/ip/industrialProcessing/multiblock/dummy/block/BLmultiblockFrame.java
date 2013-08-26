package ip.industrialProcessing.multiblock.dummy.block;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;

public class BLmultiblockFrame extends BLmultiblockDummy{

	public BLmultiblockFrame() {
		super(ConfigMachineBlocks.getBLmultiblockFrame(), "Multiblockframe", IndustrialProcessing.tabPower);
	}

}

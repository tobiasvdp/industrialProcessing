package ip.industrialProcessing.machines.multiblock.machineFrame;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.machines.multiblock.BlockMultiMachineFrame;

public class BlockMachineFrame extends BlockMultiMachineFrame {

	public BlockMachineFrame() {
		super(IndustrialProcessingConfig.getMachineFrameBlockID(), IndustrialProcessing.tabMachines);
	}

}

package ip.industrialProcessing.machines.multiblock.buildingBlocks;

import ip.industrialProcessing.machines.multiblock.MachineFrameState;
import ip.industrialProcessing.machines.multiblock.TileEntityMultiMachineFrame;

public class TileEntityMultiMachineInput extends TileEntityMultiMachineFrame {

	public TileEntityMultiMachineInput() {
		this.state = MachineFrameState.DISCONNECTED;
	}

}

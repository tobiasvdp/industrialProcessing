package ip.industrialProcessing.multiblock.block.inventory;

import ip.industrialProcessing.multiblock.MachineFrameState;
import ip.industrialProcessing.multiblock.TileEntityMultiMachineFrame;

public class TileEntityMultiMachineInput extends TileEntityMultiMachineFrame {

	public TileEntityMultiMachineInput() {
		this.state = MachineFrameState.DISCONNECTED;
	}

}

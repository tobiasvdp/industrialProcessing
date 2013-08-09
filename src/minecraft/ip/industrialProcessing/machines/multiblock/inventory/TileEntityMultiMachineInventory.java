package ip.industrialProcessing.machines.multiblock.inventory;

import ip.industrialProcessing.machines.multiblock.MachineFrameState;
import ip.industrialProcessing.machines.multiblock.TileEntityMultiMachineFrame;

public class TileEntityMultiMachineInventory extends TileEntityMultiMachineFrame {

	public TileEntityMultiMachineInventory() {
		this.state = MachineFrameState.DISCONNECTED;
	}

}

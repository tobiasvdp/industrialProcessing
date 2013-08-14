package ip.industrialProcessing.multiblock.block.inventory;

import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TileEntityMultiMachineInput extends TileEntityMultiblockBlock {

	public TileEntityMultiMachineInput() {
		this.state = MultiblockState.DISCONNECTED;
	}

}

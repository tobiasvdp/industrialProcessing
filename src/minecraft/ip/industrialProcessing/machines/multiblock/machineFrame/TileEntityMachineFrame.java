package ip.industrialProcessing.machines.multiblock.machineFrame;

import ip.industrialProcessing.machines.multiblock.MachineFrameState;
import ip.industrialProcessing.machines.multiblock.TileEntityMultiMachineFrame;

public class TileEntityMachineFrame extends TileEntityMultiMachineFrame {

	@Override
	protected void updateState(MachineFrameState state) {
		
		int id = BlockMachineFrame.getID(state);
		this.worldObj.setBlock(xCoord, yCoord, zCoord, id);
	}

}

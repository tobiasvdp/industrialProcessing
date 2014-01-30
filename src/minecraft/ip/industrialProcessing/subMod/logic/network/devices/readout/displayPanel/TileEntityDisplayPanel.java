package ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.network.microblock.TileEntityLogicNode;

public class TileEntityDisplayPanel extends TileEntityLogicNode{

	@Override
	public boolean isValidID(int itemID) {
		if(itemID == IPLogic.blockDisplayPanel.blockID)
			return true;
		return false;
	}
	
	@Override
	public boolean isValidMicroBlockType(MicroBlockType other, MicroBlockType me) {
		if (other == MicroBlockType.wire)
			return true;
		return false;
	}

	@Override
	public boolean isValidPlacingSide(ForgeDirection dir) {
		if(dir == ForgeDirection.NORTH || dir ==ForgeDirection.SOUTH || dir ==ForgeDirection.WEST || dir == ForgeDirection.EAST)
			return true;
		return false;
	}

}

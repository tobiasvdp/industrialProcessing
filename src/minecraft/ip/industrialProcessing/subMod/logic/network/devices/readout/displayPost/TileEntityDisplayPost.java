package ip.industrialProcessing.subMod.logic.network.devices.readout.displayPost;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.subMod.logic.network.microblockwithCore.TileEntityLogicNodeCore;

public class TileEntityDisplayPost extends TileEntityLogicNodeCore{

	@Override
	public boolean isValidMicroBlockType(MicroBlockType other, MicroBlockType me) {
		return true;
	}

	@Override
	public boolean isValidPlacingSide(ForgeDirection dir) {
		if(dir == ForgeDirection.DOWN)
			return false;
		return true;
	}

	@Override
	public boolean isValidID(int itemID) {
		return true;
	}

}

package ip.industrialProcessing.subMod.logic.network.transport.wired.bus;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.network.microblock.TileEntityLogicTransport;

public class TileEntityDataBus extends TileEntityLogicTransport {

	@Override
	public boolean isValidID(int itemID) {
		if (itemID == IPLogic.blockDataBus.blockID)
			return true;
		return false;
	}

	@Override
	public boolean isValidMicroBlockType(MicroBlockType other, MicroBlockType me) {
		if (other == MicroBlockType.wire)
			return true;
		if (other == MicroBlockType.device)
			return true;

		return false;
	}

	@Override
	public boolean isValidPlacingSide(ForgeDirection dir, int itemID) {
		return true;
	}

}

package ip.industrialProcessing.subMod.logic.network;

import net.minecraft.tileentity.TileEntity;

public class TileEntityLogicTransport extends TileEntity implements ILogicTransport{
	@Override
	public boolean canUpdate() {
		return false;
	}
}

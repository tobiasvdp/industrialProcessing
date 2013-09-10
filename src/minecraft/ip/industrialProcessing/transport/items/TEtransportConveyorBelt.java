package ip.industrialProcessing.transport.items;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TEtransportConveyorBelt extends TileEntity implements IConnectedTile{

	public TEtransportConveyorBelt() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConnectionState getConnection(ForgeDirection direction) {
		return ConnectionState.CONNECTED;
	}

}

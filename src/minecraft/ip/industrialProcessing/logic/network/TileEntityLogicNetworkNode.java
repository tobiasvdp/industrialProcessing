package ip.industrialProcessing.logic.network;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;

public abstract class TileEntityLogicNetworkNode extends TElogicNode implements INetworkNode{

	@Override
	public void ExtendedReceive(UTpacket packet) {
		if (packet.getType() == UTpacketType.request) {

		}
	}

}

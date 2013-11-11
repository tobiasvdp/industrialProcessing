package ip.industrialProcessing.logic.network;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;

public abstract class TileEntityLogicNetworkNode extends TElogicNode implements INetworkNode{

	@Override
	public void ExtendedReceive(UTpacket packet) {
		if (packet.getType() == UTpacketType.deliver){
			
		}
		if (packet.getType() == UTpacketType.request) {

		}
	}
	
	@Override
	public void ExtendedSend(UTpacket packet){
		if (packet.getType() == UTpacketType.deliver) {
				ICommunicationNode com = (ICommunicationNode) packet.getData(0);
				com.Receive(packet);
		}
		if (packet.getType() == UTpacketType.request) {

		}
	}
	
	@Override
	public void createDataPacket(ForgeDirection dir,ICommunicationNode node, UTVariable... data) {
		packets.add(new UTpacket(UTpacketType.deliver, node, data));
		this.scheduleSend();
		for (UTVariable item : data) {
			buffer[SIDEDTRANSFORMER.InternalToExternalDirection(this, dir).ordinal()].put(item);
		}
	}

}

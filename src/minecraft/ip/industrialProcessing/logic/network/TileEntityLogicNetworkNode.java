package ip.industrialProcessing.logic.network;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;

public abstract class TileEntityLogicNetworkNode extends TElogicNode implements INetworkNode {

    @Override
    public void ExtendedReceive(UTpacket packet) {
	super.ExtendedReceive(packet);
	if (packet.getType() == UTpacketType.deliver) {
	    UTVariable[] data = new UTVariable[packet.lenght() - 1];
	    for (int i = 1; i < packet.lenght(); i++) {
		data[i - 1] = (UTVariable) packet.getData(i);
	    }
	    setData(data);
	}
	if (packet.getType() == UTpacketType.request) {
	    UTVariableType type = ((UTVariable) packet.getData(1)).ID;
	    UTVariable[] data = getData(type);
	    if (data != null) {
		createDeliverPacket((ICommunicationNode) packet.getData(0), data);
	    }
	}
    }

    public abstract void setData(UTVariable[] data);
    public abstract UTVariable[] getData(UTVariableType type);

    @Override
    public void ExtendedSend(UTpacket packet) {
	super.ExtendedSend(packet);
	if (packet.getType() == UTpacketType.deliver) {
	    ICommunicationNode com = (ICommunicationNode) packet.getData(0);
	    com.Receive(packet);
	}
	if (packet.getType() == UTpacketType.request) {
	    ICommunicationNode com = (ICommunicationNode) packet.getData(0);
	    com.Receive(packet);
	}
    }

    @Override
    public void createDeliverPacket(ICommunicationNode node, UTVariable... data) {
	packets.add(new UTpacket(UTpacketType.deliver, node, data));
	this.scheduleSend();
    }

    @Override
    public void createRequestPacket(ICommunicationNode node, UTVariable... data) {
	packets.add(new UTpacket(UTpacketType.request, node, data));
	this.scheduleSend();
    }

}

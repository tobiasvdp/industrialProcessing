package ip.industrialProcessing.subMod.logic.old.network;

import ip.industrialProcessing.subMod.logic.old.transport.ICommunicationNode;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariable;

public interface INetworkNode extends ICommunicationNode {
	public void createDeliverPacket(ICommunicationNode dest, ICommunicationNode origin, UTVariable... data);

	public void createRequestPacket(ICommunicationNode dest, ICommunicationNode origin, UTVariable... data);
}

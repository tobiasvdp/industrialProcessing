package ip.industrialProcessing.logic.network;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.utils.UTVariable;

public interface INetworkNode extends ICommunicationNode{
	public void createDeliverPacket(ICommunicationNode dest,ICommunicationNode origin,  UTVariable... data);
	public void createRequestPacket(ICommunicationNode dest,ICommunicationNode origin,  UTVariable... data);
}

package ip.industrialProcessing.logic.network;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.utils.UTVariable;

public interface INetworkNode extends ICommunicationNode{
	public void createDataPacket(ForgeDirection dir,ICommunicationNode node,  UTVariable... data);
}

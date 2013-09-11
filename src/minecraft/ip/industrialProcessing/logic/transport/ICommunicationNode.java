package ip.industrialProcessing.logic.transport;

import java.util.ArrayList;

import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import net.minecraftforge.common.ForgeDirection;

public interface ICommunicationNode extends ICommunication{
	public void sendDiscoveryPacket(ForgeDirection sendingSide);
	public void sendDiscoveryPacket();
	public void sendDestructionPacket();
	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side);
	public void registerNode(ForgeDirection side, ICommunicationNode node);
	public void removeNode(ICommunicationNode node);
}

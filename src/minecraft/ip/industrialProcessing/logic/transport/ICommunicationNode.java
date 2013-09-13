package ip.industrialProcessing.logic.transport;

import java.util.ArrayList;

import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import net.minecraftforge.common.ForgeDirection;

public interface ICommunicationNode extends ICommunication{
	public void sendDiscoveryPacket(ForgeDirection sendingSide);
	public void sendDiscoveryPacket();
	public void sendDestructionPacket();
	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side);
	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide);
	public void removeNode(ICommunicationNode node);
	public String getName();
	public void createRandomName();
	public UTBusType getBusType(ForgeDirection side);
	public UTBuffer getBuffer(ForgeDirection dir);
	public boolean send(ForgeDirection side,boolean value);
	public boolean send(ForgeDirection side,boolean value, int index);
	public boolean receive(ICommunicationNode origin,ForgeDirection side, boolean value);
	public boolean receive(ICommunicationNode origin,ForgeDirection side, boolean value, int index);
	public boolean isConnectableOnSide(ForgeDirection side);
	public ForgeDirection[] setConnectableSides();
}

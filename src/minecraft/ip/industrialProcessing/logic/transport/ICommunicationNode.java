package ip.industrialProcessing.logic.transport;

import java.util.ArrayList;

import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBufferType;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import net.minecraftforge.common.ForgeDirection;

public interface ICommunicationNode extends ICommunication{
	
	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side);
	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide);
	public void removeNode(ICommunicationNode node);
	public void removeNode(ICommunicationNode node, ForgeDirection dir);

	public UTBuffer getBuffer(ForgeDirection dir);
	
	public ForgeDirection[] setConnectableInputSides();
	public ForgeDirection[] setConnectableOutputSides();
	public ForgeDirection[] getConnectableInputSides();
	public ForgeDirection[] getConnectableOutputSides();
	
	public void createDiscoveryPacket();
	public void createDiscoveryPacket(ForgeDirection dir);
	public void createDestructionPacket();
	public void createDataPacket();
	public void createDataPacket(ForgeDirection dir,  UTVariable... data);
	
	public void transition();
}

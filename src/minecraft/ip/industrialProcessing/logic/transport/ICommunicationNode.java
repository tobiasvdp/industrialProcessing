package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBuffer;
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
	public boolean isValidInput(ForgeDirection dir);
	public boolean isValidOutput(ForgeDirection dir);
	
	public void createDiscoveryPacket();
	public void createDiscoveryPacket(ForgeDirection dir);
	public void createDestructionPacket();
	public void createDataPacket( UTVariable... data);
	public void createDataPacket(ForgeDirection dir,  UTVariable... data);
	
	public void transition();
	
	public String getName();
}

package ip.industrialProcessing.subMod.logic.old.transport;

import ip.industrialProcessing.subMod.logic.old.utils.UTBuffer;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariable;
import ip.industrialProcessing.subMod.logic.old.utils.UTlogicNodeContainer;
import net.minecraftforge.common.ForgeDirection;

public interface ICommunicationNode extends ICommunication {

	public void createDataPacket(ForgeDirection dir, UTVariable... data);

	public void createDataPacket(UTVariable... data);

	public void createDestructionPacket();

	public void createDiscoveryPacket();

	public void createDiscoveryPacket(ForgeDirection dir);

	public UTBuffer getBuffer(ForgeDirection dir);

	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side);

	public String getName();

	public boolean isValidInput(ForgeDirection dir);

	public boolean isValidOutput(ForgeDirection dir);

	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide);

	public void removeNode(ICommunicationNode node);

	public void removeNode(ICommunicationNode node, ForgeDirection dir);

	public ForgeDirection[] setConnectableInputSides();

	public ForgeDirection[] setConnectableOutputSides();

	public void transition();
}

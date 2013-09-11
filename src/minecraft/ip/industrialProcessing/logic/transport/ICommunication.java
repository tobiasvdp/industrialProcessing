package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;

import java.lang.reflect.Array;
import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public interface ICommunication {
	
public void ReceiveDiscoveryPacket(ForgeDirection receivedSide,ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side);
public UTBusType getBusType();
}

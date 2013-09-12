package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;

import java.lang.reflect.Array;
import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public interface ICommunication {
	
public void ReceiveDiscoveryPacket(ForgeDirection receivedSide,ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side);
public UTBusType getBusType();
public boolean isSideConnected(ForgeDirection side);
public boolean isSideValid(ForgeDirection side);
public boolean hasSideActivity(ForgeDirection side);
public boolean getPlacedSide(int i);
public int getPlacedSidesSize();
public void addToConnectedSides(int side);
public boolean[] getPlacedSides();
}

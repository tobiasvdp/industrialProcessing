package ip.industrialProcessing.logic.transport;

import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public interface ICommunicationTransport extends ICommunication{
	public boolean isEnabled();
	public void isEnabled(boolean enabled);
	public void sendDiscoveryPacket(ForgeDirection sendingSide,ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side);
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path);
	public void requestRecheck();
}

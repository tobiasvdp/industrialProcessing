package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTsendDiscoveryPacket;

import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public interface ICommunicationTransport extends ICommunication{
	public boolean isEnabled();
	public void isEnabled(boolean enabled);
	public void ScheduleSendDiscoveryPacket(ForgeDirection receivingSide,ForgeDirection sendingSide,ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side);
	public void sendDiscoveryPackets();
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path);
	public void requestRecheck();
	public void setMultipleSides(boolean b);
	public boolean getMultipleSides();
}

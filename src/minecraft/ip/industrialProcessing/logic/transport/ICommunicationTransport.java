package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTpacket;

import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public interface ICommunicationTransport extends ICommunication{
	public boolean isEnabled();
	public void isEnabled(boolean enabled);
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path);
	
	public void createRecheckPacket();
	
	public void addToBlockside(int par5);
	public void removeFromBlockside(int par5);
	public boolean hasBlockSide(int side);
	public boolean hasMultipleBlockSides();
	public int getBlockSidesCount();
}

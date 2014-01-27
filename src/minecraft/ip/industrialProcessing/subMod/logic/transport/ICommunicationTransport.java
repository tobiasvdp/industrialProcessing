package ip.industrialProcessing.subMod.logic.transport;

import java.util.ArrayList;

public interface ICommunicationTransport extends ICommunication {
	public void addToBlockside(int par5);

	public boolean ContainsThis(ArrayList<ICommunicationTransport> path);

	public void createRecheckPacket();

	public int getBlockSidesCount();

	public boolean hasBlockSide(int side);

	public boolean hasMultipleBlockSides();

	public boolean isEnabled();

	public void isEnabled(boolean enabled);

	public void removeFromBlockside(int par5);
}

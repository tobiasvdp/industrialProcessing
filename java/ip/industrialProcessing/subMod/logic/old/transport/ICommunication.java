package ip.industrialProcessing.subMod.logic.old.transport;

import ip.industrialProcessing.subMod.logic.old.utils.UTBusType;
import ip.industrialProcessing.subMod.logic.old.utils.UTLogicType;
import ip.industrialProcessing.subMod.logic.old.utils.UTpacket;
import net.minecraftforge.common.util.ForgeDirection;

public interface ICommunication {

	public void ExtendedReceive(UTpacket packet);

	public void ExtendedSend(UTpacket packet);

	public UTBusType getBusType();

	public UTBusType getBusType(ForgeDirection dir);

	public UTLogicType getLogicType();

	public void Receive(UTpacket packet);

	public void scheduleSend();

	public void Send();
}

package ip.industrialProcessing.subMod.logic.transport;

import ip.industrialProcessing.subMod.logic.utils.UTBusType;
import ip.industrialProcessing.subMod.logic.utils.UTLogicType;
import ip.industrialProcessing.subMod.logic.utils.UTpacket;
import net.minecraftforge.common.ForgeDirection;

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

package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.logic.utils.UTpacket;

import java.lang.reflect.Array;
import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public interface ICommunication {
	
public void Receive(UTpacket packet);
public void ExtendedReceive(UTpacket packet);

public void scheduleSend();
public void Send();

public UTBusType getBusType();
public UTBusType getBusType(ForgeDirection dir);
}

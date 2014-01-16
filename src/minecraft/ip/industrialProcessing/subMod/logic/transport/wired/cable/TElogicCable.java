package ip.industrialProcessing.subMod.logic.transport.wired.cable;

import ip.industrialProcessing.subMod.logic.transport.TElogicTransport;
import ip.industrialProcessing.subMod.logic.utils.UTBusType;
import ip.industrialProcessing.subMod.logic.utils.UTpacket;

public class TElogicCable extends TElogicTransport {

	@Override
	public UTBusType getBusType() {
		return UTBusType.cable;
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub
		
	}
}

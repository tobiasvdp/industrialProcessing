package ip.industrialProcessing.subMod.logic.old.transport.wired.cable;

import ip.industrialProcessing.subMod.logic.old.transport.TElogicTransport;
import ip.industrialProcessing.subMod.logic.old.utils.UTBusType;
import ip.industrialProcessing.subMod.logic.old.utils.UTpacket;

public class TElogicCable extends TElogicTransport {

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub

	}

	@Override
	public UTBusType getBusType() {
		return UTBusType.cable;
	}
}

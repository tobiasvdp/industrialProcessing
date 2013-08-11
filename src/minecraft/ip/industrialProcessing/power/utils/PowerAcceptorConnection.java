package ip.industrialProcessing.power.utils;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.power.IPowerAcceptor;

public class PowerAcceptorConnection {
    public PowerAcceptorConnection(IPowerAcceptor acceptor, ForgeDirection direction) {
	this.acceptor = acceptor;
	this.connectedFrom = direction;
    }

    public IPowerAcceptor acceptor;
    public ForgeDirection connectedFrom;
}

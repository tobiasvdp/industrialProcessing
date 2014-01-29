package ip.industrialProcessing.microBlock.connectionCorners;

import ip.industrialProcessing.microBlock.connections.IMicroBlockConnection;

public interface IMicroBlockConnectionCorner extends IMicroBlockConnection{
	boolean[] getExternalConnectionCorners(int i);
}

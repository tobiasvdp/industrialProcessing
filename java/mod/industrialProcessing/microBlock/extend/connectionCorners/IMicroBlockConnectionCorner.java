package ip.industrialProcessing.microBlock.extend.connectionCorners;

import ip.industrialProcessing.microBlock.extend.connections.IMicroBlockConnection;

public interface IMicroBlockConnectionCorner extends IMicroBlockConnection{
	boolean[] getExternalConnectionCorners(int i);
}

package mod.industrialProcessing.microBlock.extend.connectionCorners;

import mod.industrialProcessing.microBlock.extend.connections.IMicroBlockConnection;

public interface IMicroBlockConnectionCorner extends IMicroBlockConnection{
	boolean[] getExternalConnectionCorners(int i);
}

package mod.industrialProcessing.blockContainer.microblock.extend.connectionCorners;

import mod.industrialProcessing.blockContainer.microblock.extend.connections.IMicroBlockConnection;

public interface IMicroBlockConnectionCorner extends IMicroBlockConnection{
	boolean[] getExternalConnectionCorners(int i);
}

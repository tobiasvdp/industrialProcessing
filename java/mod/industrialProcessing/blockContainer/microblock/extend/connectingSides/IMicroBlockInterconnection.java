package mod.industrialProcessing.blockContainer.microblock.extend.connectingSides;

import mod.industrialProcessing.blockContainer.microblock.IMicroBlock;

public interface IMicroBlockInterconnection extends IMicroBlock{
	boolean[] getInterConnections(int side);
	public int getRotated(int i, int j);
}

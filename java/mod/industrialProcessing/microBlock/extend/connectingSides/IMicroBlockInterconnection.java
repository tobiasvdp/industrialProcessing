package mod.industrialProcessing.microBlock.extend.connectingSides;

import mod.industrialProcessing.microBlock.IMicroBlock;

public interface IMicroBlockInterconnection extends IMicroBlock{
	boolean[] getInterConnections(int side);
	public int getRotated(int i, int j);
}

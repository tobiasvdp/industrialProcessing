package ip.industrialProcessing.microBlock.connectingSides;

import ip.industrialProcessing.microBlock.IMicroBlock;

public interface IMicroBlockInterconnection extends IMicroBlock{
	boolean[] getInterConnections(int side);
	public int getRotated(int i, int j);
}

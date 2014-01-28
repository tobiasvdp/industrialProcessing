package ip.industrialProcessing.microBlock.connectingSides;

import ip.industrialProcessing.microBlock.IMicroBlock;

public interface IMicroBlockInterconnection extends IMicroBlock{
	boolean[] getInterConnections(int side);
}

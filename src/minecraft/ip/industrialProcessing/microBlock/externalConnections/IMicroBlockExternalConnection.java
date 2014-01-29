package ip.industrialProcessing.microBlock.externalConnections;

import ip.industrialProcessing.microBlock.IMicroBlock;

public interface IMicroBlockExternalConnection  extends IMicroBlock{
	boolean[] getExternalConnections(int side);
	void updateConnections(int i);
}

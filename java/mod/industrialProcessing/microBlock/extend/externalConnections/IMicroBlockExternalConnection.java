package ip.industrialProcessing.microBlock.extend.externalConnections;

import ip.industrialProcessing.microBlock.IMicroBlock;

public interface IMicroBlockExternalConnection  extends IMicroBlock{
	boolean[] getExternalConnections(int side);
	void updateConnections(int i);
	void updateConnections(int x,int y,int z);
}

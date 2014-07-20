package mod.industrialProcessing.microBlock.extend.externalConnections;

import mod.industrialProcessing.microBlock.IMicroBlock;

public interface IMicroBlockExternalConnection  extends IMicroBlock{
	boolean[] getExternalConnections(int side);
	void updateConnections(int i);
	void updateConnections(int x,int y,int z);
}

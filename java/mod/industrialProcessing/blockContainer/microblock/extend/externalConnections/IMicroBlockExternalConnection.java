package mod.industrialProcessing.blockContainer.microblock.extend.externalConnections;

import mod.industrialProcessing.blockContainer.microblock.IMicroBlock;

public interface IMicroBlockExternalConnection  extends IMicroBlock{
	boolean[] getExternalConnections(int side);
	void updateConnections(int i);
	void updateConnections(int x,int y,int z);
}

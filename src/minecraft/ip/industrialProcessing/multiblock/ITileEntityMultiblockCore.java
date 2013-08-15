package ip.industrialProcessing.multiblock;

import ip.industrialProcessing.multiblock.utils.MultiblockState;

public interface ITileEntityMultiblockCore {

	boolean isMultiblock();
	boolean checkStructure();
	void breakEntireStructure();
	boolean isPartOfStructure(int x, int y, int z, int blockId);

	int getCoreX();
	int getCoreY();
	int getCoreZ();
	MultiblockState getState();
	void breakMultiblock();
}

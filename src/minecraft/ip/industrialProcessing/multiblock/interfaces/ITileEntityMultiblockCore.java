package ip.industrialProcessing.multiblock.interfaces;

import cpw.mods.fml.common.network.Player;
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
	int checkModelID(int xCoord, int yCoord, int zCoord);
}

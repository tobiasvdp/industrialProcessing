package mod.industrialProcessing.blockContainer.multiblock.coreAndDummy;

import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;

public interface ITileEntityMultiblockSwitcher {
	boolean isCore();
	public MultiblockState getState();
	int getModelConnection();
}

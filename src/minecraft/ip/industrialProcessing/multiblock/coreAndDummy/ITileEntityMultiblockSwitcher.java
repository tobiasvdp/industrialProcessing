package ip.industrialProcessing.multiblock.coreAndDummy;

import ip.industrialProcessing.multiblock.utils.MultiblockState;

public interface ITileEntityMultiblockSwitcher {
	boolean isCore();
	public MultiblockState getState();
}

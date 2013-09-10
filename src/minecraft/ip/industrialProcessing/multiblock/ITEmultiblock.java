package ip.industrialProcessing.multiblock;

import ip.industrialProcessing.multiblock.utils.MultiblockState;

public interface ITEmultiblock {
	public MultiblockState getState();
	public int getX();
	public int getY();
	public int getZ();
}

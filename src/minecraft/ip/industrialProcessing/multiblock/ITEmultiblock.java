package ip.industrialProcessing.multiblock;

import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public interface ITEmultiblock {
	public MultiblockState getState();
	public Tiers getTier();
	public int getX();
	public int getY();
	public int getZ();
}

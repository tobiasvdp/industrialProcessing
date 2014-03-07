package mod.industrialProcessing.blockContainer.multiblock;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;


public interface IMultiblock {
	public MultiblockState getState();

	public Tiers getTier();

	public int getX();

	public int getY();

	public int getZ();
}

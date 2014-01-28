package ip.industrialProcessing.multiblock;

import net.minecraftforge.common.ForgeDirection;

public interface IMicroBlock {
	boolean isSideFree(ForgeDirection dir);
	void setSide(ForgeDirection dir, int itemID);
}

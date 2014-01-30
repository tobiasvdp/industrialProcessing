package ip.industrialProcessing.microBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.ForgeDirection;

public interface IMicroBlock {
	boolean isSideFree(ForgeDirection dir);
	boolean isSideFree(int dir);
	void setSide(ForgeDirection dir, int itemID);
	void unsetSide(ForgeDirection dir, EntityPlayer player);
	void refresh();
	int[] getSides();
}

package ip.industrialProcessing.microBlock;

import ip.industrialProcessing.items.ItemMicroBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.ForgeDirection;

public interface IMicroBlock {
	boolean isSideFree(ForgeDirection dir);
	boolean isSideFree(int dir);
	public int countSetSides();
	void setSide(ForgeDirection dir, ItemMicroBlock itemMicroBlock, EntityPlayer player);
	void unsetSide(ForgeDirection dir, EntityPlayer player);
	void refresh();
	int[] getSides();
}

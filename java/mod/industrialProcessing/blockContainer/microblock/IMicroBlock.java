package mod.industrialProcessing.blockContainer.microblock;

import mod.industrialProcessing.items.ItemMicroBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;

public interface IMicroBlock {
	boolean isSideFree(ForgeDirection dir);
	boolean isSideFree(int dir);
	public int countSetSides();
	void setSide(ForgeDirection dir, ItemMicroBlock itemMicroBlock, EntityPlayer player);
	boolean unsetSide(ForgeDirection dir, EntityPlayer player);
	void refresh();
	int[] getSides();
	MicroBlockType getType();
	ItemMicroBlock getItemOnSide(ForgeDirection dir);
}

package ip.industrialProcessing.utils.containers;

import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public interface IContainerTransfer {
	boolean containerMergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4);
	Slot containerGetSlot(int slot);
}

package ip.industrialProcessing.utils.inventories;

import net.minecraft.item.ItemStack;

public interface IItemStacksInventory {
	void setStacks(ItemStack[] stacks);
	ItemStack[] getStacks();
	int getStackCount();
}

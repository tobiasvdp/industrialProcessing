package mod.industrialProcessing.utils.inventory;

import net.minecraft.item.ItemStack;

public interface IItemStacksInventory {
	void setStacks(ItemStack[] stacks);
	ItemStack[] getStacks();
	int getStackCount();
}

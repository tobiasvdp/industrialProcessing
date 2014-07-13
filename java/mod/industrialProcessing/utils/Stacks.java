package mod.industrialProcessing.utils;

import net.minecraft.item.ItemStack;

public class Stacks {

	public static boolean areStacksMergeable(ItemStack stackA, ItemStack stackB) {
		if (stackA == null || stackB == null)
			return false;

		if (!stackA.isItemEqual(stackB))
			return false;

		if (stackA.stackSize + stackB.stackSize > stackA.getMaxStackSize())
			return false;
		
		if(stackA.isItemStackDamageable() != stackB.isItemStackDamageable()) return false;
		
		if(stackA.isItemStackDamageable() && stackA.getItemDamage() != stackB.getItemDamage()) return false;
		
		return true;		
	}
}

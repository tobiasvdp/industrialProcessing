package mod.industrialProcessing.work.recipe.Inputs;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public abstract class InputItem {
	public abstract boolean isValid(ItemStack stack);
	public abstract ArrayList<ItemStack> getValidItemStacks();
	public abstract ItemStack getDisplayStack();
}

package mod.industrialProcessing.work.recipe.Inputs;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class InputItemStack extends InputItem {

	private ItemStack stack;

	public InputItemStack(ItemStack stack) {
		this.stack = stack;
	}

	@Override
	public boolean isValid(ItemStack stack) {

		return ItemStack.areItemStacksEqual(stack, stack);
	}

	@Override
	public ArrayList<ItemStack> getValidItemStacks() {

		ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();
		stacks.add(stack.copy());
		return stacks;
	}

	@Override
	public ItemStack getDisplayStack() {
		return stack.copy();
	}

}

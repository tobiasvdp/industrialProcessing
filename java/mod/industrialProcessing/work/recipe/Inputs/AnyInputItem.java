package mod.industrialProcessing.work.recipe.Inputs;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class AnyInputItem extends InputItem {

	
	private InputItem[] inputItems;

	public AnyInputItem(InputItem ...inputItems)
	{
		this.inputItems = inputItems;
	}
	
	@Override
	public boolean isValid(ItemStack stack) {

		for (int i = 0; i < this.inputItems.length; i++) {
			InputItem item = this.inputItems[i];
			if(item != null && item.isValid(stack)) return true;
		}
		return false;
	}

	@Override
	public ArrayList<ItemStack>  getValidItemStacks() {

		ArrayList<ItemStack> allItems = new ArrayList<ItemStack>();
		
		for (int i = 0; i < this.inputItems.length; i++) {
			InputItem item = this.inputItems[i];

			allItems.addAll(item.getValidItemStacks());
		}
		
		return allItems;
	}

	@Override
	public ItemStack getDisplayStack() {
		
		for (int i = 0; i < this.inputItems.length; i++) {
			InputItem item = this.inputItems[i];

			ItemStack stack = item.getDisplayStack();
			if(stack != null)
				return stack;
		}
		return null;
	}

}

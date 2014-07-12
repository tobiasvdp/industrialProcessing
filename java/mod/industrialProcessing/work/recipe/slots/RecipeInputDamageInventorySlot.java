package mod.industrialProcessing.work.recipe.slots;

import net.minecraft.item.Item;
import mod.industrialProcessing.work.recipe.IRecipeWorkHandler;

public class RecipeInputDamageInventorySlot extends RecipeInputInventorySlot {

	public RecipeInputDamageInventorySlot(int index, Item item)
	{
		super(index, item, 1);
	}
	
	@Override
	public void removeFrom(IRecipeWorkHandler handler) {
		if (!handler.damageItem(this.index))
			System.err.println("Failed to damage recipe input?!");
	}
}

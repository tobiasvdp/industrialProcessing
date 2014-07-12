package mod.industrialProcessing.work.recipe.slots;

import mod.industrialProcessing.utils.inventory.IInventorySlots;
import net.minecraft.item.Item;

public class RecipeInputDamageInventorySlot extends RecipeInputInventorySlot {

	public RecipeInputDamageInventorySlot(int index, Item item) {
		super(index, item, 1);
	}

	@Override
	public void removeFrom(IInventorySlots handler) {
		if (!handler.damageItem(this.index))
			System.err.println("Failed to damage recipe input?!");
	}
}

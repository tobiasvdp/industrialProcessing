package mod.industrialProcessing.work.recipe.slots;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public abstract class RecipeInputSlot extends RecipeSlot {

	public RecipeInputSlot(int index, int amount, RecipeSlotType type) {
		super(index, type);
		this.amount = amount;
	}

	private int amount;

	@Override
	public int getMinAmount() {
		return amount;
	}

	@Override
	public int getMaxAmount() {
		return amount;
	}


}

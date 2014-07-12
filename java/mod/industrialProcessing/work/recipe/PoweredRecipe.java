package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;

public class PoweredRecipe extends Recipe implements IPowerRecipe {
	public float powerRequired;

	public PoweredRecipe(RecipeInputInventorySlot[] input, RecipeOutputInventorySlot[] output, int work, float power) {
		super(input, output, work);
		this.powerRequired = power;
		if (power <= 0)
			System.out.println("PoweredRecipe.PoweredRecipe(): if you need no power, why make a Powered Recipe?");
	}

	public PoweredRecipe() {
	}

	@Override
	public float getPowerRequired() {
		return this.powerRequired;
	}
}

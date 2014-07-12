package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;

public class PoweredRecipeMultiblock extends RecipeMultiblock implements IPowerRecipe {
	public PoweredRecipeMultiblock(RecipeInputInventorySlot[] input, RecipeOutputInventorySlot[] output, int work, int power, Tiers tier) {
		super(input, output, work, tier);
		this.powerRequired = power;
	}

	public PoweredRecipeMultiblock() {
		super();
	}

	public int powerRequired;

	@Override
	public int getPowerRequired() {
		return this.powerRequired;
	}

}

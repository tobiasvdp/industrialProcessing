package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;

public class PoweredRecipeMultiblock extends RecipeMultiblock implements IPowerRecipe {
	public PoweredRecipeMultiblock(RecipeInputSlot[] input, RecipeOutputSlot[] output, int work, int power, Tiers tier) {
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

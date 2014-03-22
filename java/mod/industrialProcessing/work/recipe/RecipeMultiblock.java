package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;

public class RecipeMultiblock extends Recipe implements ITierRecipe {
    public RecipeMultiblock() {
	super();
    }

    public RecipeMultiblock(RecipeInputSlot[] input, RecipeOutputSlot[] output, int work, Tiers tier) {
	super(input, output, work);
    }

    public Tiers tier;

    @Override
    public Tiers getTier() {
	return tier;
    }

}

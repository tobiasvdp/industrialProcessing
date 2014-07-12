package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;

public class RecipeMultiblock extends Recipe implements ITierRecipe {
    public RecipeMultiblock() {
	super();
    }

    public RecipeMultiblock(RecipeInputInventorySlot[] input, RecipeOutputInventorySlot[] output, int work, Tiers tier) {
	super(input, output, work);
    }

    public Tiers tier;

    @Override
    public Tiers getTier() {
	return tier;
    }

}

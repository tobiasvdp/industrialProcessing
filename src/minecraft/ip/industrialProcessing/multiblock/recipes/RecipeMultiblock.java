package ip.industrialProcessing.multiblock.recipes;

import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;

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

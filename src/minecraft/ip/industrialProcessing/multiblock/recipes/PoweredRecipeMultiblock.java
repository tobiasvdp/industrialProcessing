package ip.industrialProcessing.multiblock.recipes;

import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.IPowerRecipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;

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

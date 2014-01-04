package ip.industrialProcessing.multiblock.recipes;

import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;

public class RecipeMultiblock extends Recipe {
public RecipeMultiblock() {
	super();
}
public RecipeMultiblock(RecipeInputSlot[] input, RecipeOutputSlot[] output,int work, int power,Tiers tier) {
	super(input, output, work, power);
}
public Tiers tier;
}

package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;

public class PoweredRecipe extends Recipe implements IPowerRecipe {
    public int powerRequired;

    public PoweredRecipe(RecipeInputInventorySlot[] input, RecipeOutputInventorySlot[] output, int work, int power) {
	super(input, output, work);
	this.powerRequired = power;
	if (power <= 0)
	    System.out.println("PoweredRecipe.PoweredRecipe(): if you need no power, why make a Powered Recipe?");
    }

    public PoweredRecipe() {
    }

    @Override
    public int getPowerRequired() {
	return this.powerRequired;
    }
}

package mod.industrialProcessing.work.recipe;

public class PoweredRecipe extends Recipe implements IPowerRecipe {
    public int powerRequired;

    public PoweredRecipe(RecipeInputSlot[] input, RecipeOutputSlot[] output, int work, int power) {
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

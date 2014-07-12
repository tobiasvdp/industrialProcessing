package mod.industrialProcessing.work.recipe;


public class RecipeWorker extends RecipeGenericFluidWorker<IMachineRecipe, IRecipeFluidWorkHandler<IMachineRecipe>> {

	public RecipeWorker(IRecipeFluidWorkHandler<IMachineRecipe> handler) {
		super(handler); 
	}

}

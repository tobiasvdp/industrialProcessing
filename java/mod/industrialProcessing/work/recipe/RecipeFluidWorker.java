package mod.industrialProcessing.work.recipe;


public class RecipeFluidWorker extends RecipeGenericFluidWorker<IMachineRecipe, IRecipeFluidWorkHandler<IMachineRecipe>> {

	public RecipeFluidWorker(IRecipeFluidWorkHandler<IMachineRecipe> handler) {
		super(handler); 
	}

}

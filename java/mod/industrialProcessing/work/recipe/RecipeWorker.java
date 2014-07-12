package mod.industrialProcessing.work.recipe;


public class RecipeWorker extends RecipeGenericWorker<IMachineRecipe, IRecipeWorkHandler<IMachineRecipe>> {

	public RecipeWorker(IRecipeWorkHandler<IMachineRecipe> handler) {
		super(handler); 
	}

}

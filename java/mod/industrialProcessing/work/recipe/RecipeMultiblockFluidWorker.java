package mod.industrialProcessing.work.recipe;


public class RecipeMultiblockFluidWorker extends RecipeGenericFluidWorker<RecipeMultiblock, IRecipeMultiblockFluidWorkHandler> {

	public RecipeMultiblockFluidWorker(IRecipeMultiblockFluidWorkHandler handler) {
		super(handler);
	}

	@Override
	protected boolean recipeValid(RecipeMultiblock iterator) {
		return iterator.getTier() == this.handler.getTier();
	}
}

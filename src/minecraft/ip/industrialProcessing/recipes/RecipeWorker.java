package ip.industrialProcessing.recipes;

import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.Worker;

public class RecipeWorker extends Worker {

	private IRecipeWorkHandler handler;
	private Recipe recipe;

	public RecipeWorker(IRecipeWorkHandler handler) {
		super(handler, 100);
		this.handler = handler;
	}

	@Override
	protected void onEndWork() {
		super.onEndWork();
		this.recipe = null;
	}

	@Override
	protected void onBeginWork() {
		this.recipe = this.getCurrentRecipe();
		if (recipe != null)
			this.totalWork = this.recipe.workRequired;
		else
			this.totalWork = 0;
		super.onBeginWork();
	}

	public Recipe getCurrentRecipe() {
		return null;
	}
}

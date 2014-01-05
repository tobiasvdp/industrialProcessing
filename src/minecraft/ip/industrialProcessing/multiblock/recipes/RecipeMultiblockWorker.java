package ip.industrialProcessing.multiblock.recipes;

import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeWorker;

public class RecipeMultiblockWorker extends RecipeWorker {

	public RecipeMultiblockWorker(IRecipeWorkHandler handler) {
		super(handler);
	}
	@Override
	protected boolean matchesInput(Recipe currentRecipe) {
	        if (currentRecipe == null)
	            return false;
	        if (currentRecipe instanceof RecipeMultiblock){
	        if (currentRecipe.inputs == null)
	            return false;
	        for (int i = 0; i < currentRecipe.inputs.length; i++) {
	            RecipeInputSlot slot = currentRecipe.inputs[i];
	            if (!hasInputIngredients(slot))
	                return false;
	        }
	        return true;
	        }
	        return false;
	    }

}

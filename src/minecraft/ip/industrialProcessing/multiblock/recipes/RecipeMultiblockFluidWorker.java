package ip.industrialProcessing.multiblock.recipes;

import ip.industrialProcessing.recipes.IRecipeFluidWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeFluidWorker;
import ip.industrialProcessing.recipes.RecipeInputSlot;

public class RecipeMultiblockFluidWorker extends RecipeFluidWorker {

	public RecipeMultiblockFluidWorker(IRecipeFluidWorkHandler handler) {
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

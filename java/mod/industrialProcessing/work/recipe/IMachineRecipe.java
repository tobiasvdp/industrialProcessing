package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;

public interface IMachineRecipe { 
	RecipeInputInventorySlot[] getInventoryInputs();
	RecipeInputFluidSlot[] getFluidInputs();
    RecipeOutputInventorySlot[] getInventoryOutputs();
    RecipeOutputFluidSlot[] getFluidOutputs();
    int getWorkRequired(); 
}

package mod.industrialProcessing.work.recipe;

public interface IMachineRecipe { 
    RecipeInputSlot[] getInputs();
    RecipeOutputSlot[] getOutputs();
    int getWorkRequired(); 
}

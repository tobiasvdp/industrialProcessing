package mod.industrialProcessing.recipe;

public interface IMachineRecipe { 
    RecipeInputSlot[] getInputs();
    RecipeOutputSlot[] getOutputs();
    int getWorkRequired(); 
}

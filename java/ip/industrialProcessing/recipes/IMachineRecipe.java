package ip.industrialProcessing.recipes;

public interface IMachineRecipe { 
    RecipeInputSlot[] getInputs();
    RecipeOutputSlot[] getOutputs();
    int getWorkRequired(); 
}

package ip.industrialProcessing.recipes;

public class Recipe implements IMachineRecipe {
    public RecipeInputSlot[] inputs;
    public RecipeOutputSlot[] outputs;
    public int workRequired;

    public Recipe(RecipeInputSlot[] input, RecipeOutputSlot[] output, int work) {
	this.inputs = input;
	this.outputs = output;
	this.workRequired = work;
    }

    public Recipe() {
    }

    @Override
    public RecipeInputSlot[] getInputs() {
	return inputs;
    }

    @Override
    public RecipeOutputSlot[] getOutputs() {
	return outputs;
    }

    @Override
    public int getWorkRequired() {
	return workRequired;
    }

}

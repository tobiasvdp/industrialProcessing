package ip.industrialProcessing.recipes;

public class Recipe {
	public Recipe(RecipeInputSlot[] input, RecipeOutputSlot[] output,int work, int power) {
		this.inputs = input;
		this.outputs = output;
		this.powerRequired = power;
		this.workRequired = work;
	}
	public Recipe(){
	}
	
	public RecipeInputSlot[] inputs;
	public RecipeOutputSlot[] outputs;
	public int workRequired; 
	public int powerRequired;
}

package ip.industrialProcessing.machines.magneticSeparator;

import net.minecraft.block.Block;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMagneticSeparator extends RecipesMachine {
	public RecipesMagneticSeparator()
	{
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
	//dirt
	RecipeInputSlot sandInput = new RecipeInputSlot();
	sandInput.amount = 3;
	sandInput.index = 0;
	sandInput.itemId=Block.sand.blockID;
	sandInput.type = RecipeSlotType.INVENTORY;
	
	RecipeOutputSlot dirtOutput = new RecipeOutputSlot();
	dirtOutput.minAmount = 2;
	dirtOutput.maxAmount = 4;
	dirtOutput.distributionCenter = 2;
	dirtOutput.index = 1;
	dirtOutput.itemId = Block.dirt.blockID;
	dirtOutput.type = RecipeSlotType.INVENTORY;
	
	RecipeOutputSlot sandOutput = new RecipeOutputSlot();
	sandOutput.minAmount = 3;
	sandOutput.maxAmount = 3;
	sandOutput.distributionCenter = 3;
	sandOutput.index = 2;
	sandOutput.itemId = Block.sand.blockID;
	sandOutput.type = RecipeSlotType.INVENTORY;
	
	Recipe dirtRecipe = new Recipe();
	dirtRecipe.workRequired = 40;
	dirtRecipe.inputs = new RecipeInputSlot[]{sandInput};
	dirtRecipe.outputs = new RecipeOutputSlot[]{dirtOutput,sandOutput};		
	
	addRecipe(dirtRecipe);
	}
}

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
	dirtOutput.minAmount = 1;
	dirtOutput.maxAmount = 5;
	dirtOutput.distributionCenter = 0.5;
	dirtOutput.index = 1;
	dirtOutput.itemId = Block.dirt.blockID;
	dirtOutput.type = RecipeSlotType.INVENTORY;
	
	RecipeOutputSlot sandOutput = new RecipeOutputSlot();
	sandOutput.minAmount = 0;
	sandOutput.maxAmount = 3;
	sandOutput.distributionCenter = 0;
	sandOutput.index = 2;
	sandOutput.itemId = Block.sand.blockID;
	sandOutput.type = RecipeSlotType.INVENTORY;

	RecipeOutputSlot grassOutput = new RecipeOutputSlot();
	grassOutput.minAmount = 0;
	grassOutput.maxAmount = 3;
	grassOutput.distributionCenter = 0;
	grassOutput.index = 3;
	grassOutput.itemId = Block.grass.blockID;
	grassOutput.type = RecipeSlotType.INVENTORY;

	RecipeOutputSlot cobbleOutput = new RecipeOutputSlot();
	cobbleOutput.minAmount = 0;
	cobbleOutput.maxAmount = 1;
	cobbleOutput.distributionCenter = 0;
	cobbleOutput.index = 4;
	cobbleOutput.itemId = Block.cobblestone.blockID;
	cobbleOutput.type = RecipeSlotType.INVENTORY;
	
	Recipe dirtRecipe = new Recipe();
	dirtRecipe.workRequired = 40;
	dirtRecipe.inputs = new RecipeInputSlot[]{sandInput};
	dirtRecipe.outputs = new RecipeOutputSlot[]{dirtOutput,sandOutput,grassOutput,cobbleOutput};		
	
	addRecipe(dirtRecipe);
	}
}

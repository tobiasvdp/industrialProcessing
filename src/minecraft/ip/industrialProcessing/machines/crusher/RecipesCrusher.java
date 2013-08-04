package ip.industrialProcessing.machines.crusher;

import net.minecraft.block.Block;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesCrusher extends RecipesMachine {
	public RecipesCrusher()
	{
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		//cobble
		RecipeInputSlot cobbleInput = new RecipeInputSlot();
		cobbleInput.amount = 1;
		cobbleInput.index = 0;
		cobbleInput.itemId = Block.cobblestone.blockID;
		cobbleInput.type = RecipeSlotType.INVENTORY;
		RecipeOutputSlot sandOutput = new RecipeOutputSlot();
		sandOutput.minAmount = 1;
		sandOutput.maxAmount = 3;
		sandOutput.distributionCenter = 0;
		sandOutput.index = 1;
		sandOutput.itemId = Block.sand.blockID;
		sandOutput.type = RecipeSlotType.INVENTORY;
		
		Recipe sandRecipe = new Recipe();
		sandRecipe.inputs = new RecipeInputSlot[]{cobbleInput};
		sandRecipe.outputs = new RecipeOutputSlot[]{sandOutput};		
		
		addRecipe(sandRecipe);
		
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
		
		Recipe dirtRecipe = new Recipe();
		dirtRecipe.inputs = new RecipeInputSlot[]{sandInput};
		dirtRecipe.outputs = new RecipeOutputSlot[]{dirtOutput};		
		
		addRecipe(dirtRecipe);
		
	}
}

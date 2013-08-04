package ip.industrialProcessing.machines.filter;

import java.util.Iterator;

import net.minecraft.block.Block;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesFilter extends RecipesMachine {
	public RecipesFilter() {
		
		RecipeInputSlot dirtInput = new RecipeInputSlot();
		dirtInput.itemId = Block.dirt.blockID;
		dirtInput.index = 0;
		dirtInput.type = RecipeSlotType.INVENTORY;
		dirtInput.amount = 4;
		
		RecipeOutputSlot sandOutput = new RecipeOutputSlot();
		sandOutput.itemId = Block.sand.blockID;
		sandOutput.index = 1;
		sandOutput.type = RecipeSlotType.INVENTORY;
		sandOutput.minAmount = 0;
		sandOutput.maxAmount = 3;
		
		RecipeOutputSlot gravelOutput = new RecipeOutputSlot();
		gravelOutput.itemId = Block.gravel.blockID;
		gravelOutput.index = 2;
		gravelOutput.type = RecipeSlotType.INVENTORY;
		sandOutput.minAmount = 0;
		gravelOutput.maxAmount = 3;
		
		Recipe filterDirt = new Recipe();
		filterDirt.powerRequired = 0;
		filterDirt.workRequired = 100;
		filterDirt.inputs = new RecipeInputSlot[] { dirtInput };
		filterDirt.outputs = new RecipeOutputSlot[] { sandOutput, gravelOutput };
		
		addRecipe(filterDirt);
	}

}

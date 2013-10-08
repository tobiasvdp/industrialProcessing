package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesWeldingStation extends RecipesMachine {
	public RecipesWeldingStation() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(something(3000,0));
	}
	private Recipe something(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, Item.coal.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemCoalDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
}

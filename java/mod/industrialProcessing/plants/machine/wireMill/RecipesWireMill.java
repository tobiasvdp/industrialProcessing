package ip.industrialProcessing.machines.wireMill;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesWireMill extends RecipesMachine {
	public RecipesWireMill() {
		addRecipe(copperToWire(3000, 0));
	}

	private Recipe copperToWire(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperBar.itemID, RecipeSlotType.INVENTORY, 4) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperWire.itemID, RecipeSlotType.INVENTORY, 4, 6, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		return recipe;
	}
}
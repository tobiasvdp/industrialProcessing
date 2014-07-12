package ip.industrialProcessing.machines.pelletExtruder;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesPelletExtruder extends RecipesMachine {

    public RecipesPelletExtruder() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(cokeToPellet(3000, 1));
    }

    private Recipe cokeToPellet(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCokes.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCokePellet.itemID, RecipeSlotType.INVENTORY, 2, 3, 0.5f) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }
}

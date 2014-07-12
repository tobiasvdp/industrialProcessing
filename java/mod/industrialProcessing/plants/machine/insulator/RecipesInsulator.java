package ip.industrialProcessing.machines.insulator;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesInsulator extends RecipesMachine {
    public RecipesInsulator() {
	addRecipe(insulate(3000, 0));
    }

    private Recipe insulate(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCopperWire.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCopperWireInsulated.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }
}

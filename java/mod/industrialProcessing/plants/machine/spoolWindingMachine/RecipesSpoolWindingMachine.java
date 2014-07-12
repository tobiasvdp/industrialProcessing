package ip.industrialProcessing.machines.spoolWindingMachine;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesSpoolWindingMachine extends RecipesMachine {
    public RecipesSpoolWindingMachine() {
	addRecipe(coalToDust(3000, 0));
    }

    private Recipe coalToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCopperWireInsulated.itemID, RecipeSlotType.INVENTORY, 3) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(2, ISetupItems.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }
}

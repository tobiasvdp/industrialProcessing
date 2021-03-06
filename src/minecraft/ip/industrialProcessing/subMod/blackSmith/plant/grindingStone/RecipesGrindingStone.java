package ip.industrialProcessing.subMod.blackSmith.plant.grindingStone;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesGrindingStone extends RecipesMachine {
    public RecipesGrindingStone() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(ironBlade(400, 1));
    }

    private Recipe ironBlade(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronBlade.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }
}

package ip.industrialProcessing.machines.sinter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesSinter extends RecipesMachine {
    public RecipesSinter() {
        addDefaultRecipes();
    }

	private void addDefaultRecipes() {
		addRecipe(ironDustToSinter(3000,1));
	}
    private Recipe ironDustToSinter(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, IndustrialProcessing.itemLimestoneDust.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, IndustrialProcessing.itemIronSinter.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }
}

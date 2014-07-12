package ip.industrialProcessing.machines.kiln;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.item.Item;

public class RecipesKiln extends RecipesMachine {
    public RecipesKiln() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(coalToCoke(3000, 1));
    }

    private Recipe coalToCoke(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.coal.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCokes.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }
}

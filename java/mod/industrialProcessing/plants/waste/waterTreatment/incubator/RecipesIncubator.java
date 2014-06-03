package ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.item.Item;

public class RecipesIncubator extends RecipesMachine {
    public RecipesIncubator() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(rottenFleshToCulture(12000, 0));
	addRecipe(meatToRottenFlesh(12000, 0));
	addRecipe(porkToRottenFlesh(12000, 0));
    }

    private Recipe rottenFleshToCulture(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.rottenFlesh.itemID, RecipeSlotType.INVENTORY, 3) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGrownCulture.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe meatToRottenFlesh(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.beefRaw.itemID, RecipeSlotType.INVENTORY, 3) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.rottenFlesh.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe porkToRottenFlesh(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.porkRaw.itemID, RecipeSlotType.INVENTORY, 3) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.rottenFlesh.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }
}

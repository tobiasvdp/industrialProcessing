package ip.industrialProcessing.machines.spoolWindingMachine;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesSpoolWindingMachine extends RecipesMachine {
public RecipesSpoolWindingMachine(){
	addRecipe(coalToDust(3000,0));
}
private Recipe coalToDust(int workTime, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperWireInsulated.itemID, RecipeSlotType.INVENTORY, 3) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, ISetupItems.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
}
}

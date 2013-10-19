package ip.industrialProcessing.machines.spoolWindingMachine;

import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
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
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.coal.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, IndustrialProcessing.itemCoalDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
}
}

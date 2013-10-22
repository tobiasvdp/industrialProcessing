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
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperWireInsulated.itemID, RecipeSlotType.INVENTORY, 3) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
}
}

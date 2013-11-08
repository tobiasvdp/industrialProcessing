package ip.industrialProcessing.machines.insulator;

import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesInsulator extends RecipesMachine {
	public RecipesInsulator() {
		addRecipe(insulate(3000, 0));
	}

	private Recipe insulate(int workTime, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperWire.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperWireInsulated.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption;
		return recipe;
	}
}

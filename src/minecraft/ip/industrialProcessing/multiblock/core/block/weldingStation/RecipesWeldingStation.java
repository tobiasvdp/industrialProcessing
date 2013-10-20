package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesWeldingStation extends RecipesMachine {
	public RecipesWeldingStation() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(motorStator(3000,0));
	}
	private Recipe motorStator(int workTime, int power) {
		Recipe recipe = new Recipe();
		
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(4, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(5, IndustrialProcessing.itemCopperCoil.itemID, RecipeSlotType.INVENTORY, 1) };
		
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(13, IndustrialProcessing.itemMotorStator.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		
		recipe.workRequired = workTime;
		recipe.powerRequired = power;
		return recipe;
	}
}

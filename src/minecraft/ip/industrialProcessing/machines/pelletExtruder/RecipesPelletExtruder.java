package ip.industrialProcessing.machines.pelletExtruder;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesPelletExtruder  extends RecipesMachine{

	public RecipesPelletExtruder() {
		addDefaultRecipes();
	}
	private void addDefaultRecipes() {
	    addRecipe(cokeToPellet(3000, 1));
	}
	    private Recipe cokeToPellet(int workTime, int powerConsumption) {
	        Recipe recipe = new Recipe();
	        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCokes.itemID, RecipeSlotType.INVENTORY, 1) };

	        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCokePellet.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	        recipe.workRequired = workTime;
	        recipe.powerRequired = powerConsumption;
	        return recipe;
	    }
}

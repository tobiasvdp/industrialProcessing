package ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesIncubator extends RecipesMachine{
	public RecipesIncubator(){
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(rottenFleshToCulture(9000));
	}
	
	private Recipe rottenFleshToCulture(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.rottenFlesh.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGrownCulture.itemID, RecipeSlotType.INVENTORY, 5, 20, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}
}

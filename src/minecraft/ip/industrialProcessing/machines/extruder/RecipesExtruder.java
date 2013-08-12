package ip.industrialProcessing.machines.extruder;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesExtruder extends RecipesMachine {

	public RecipesExtruder() {
		addDefaultRecipes();
	}
	private void addDefaultRecipes() {

		Recipe slag = new Recipe();
		slag.workRequired = 30;
		slag.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(0,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidHotSlag.getName()),RecipeSlotType.TANK, 1000)};
		slag.outputs = new RecipeOutputSlot[] {
				new RecipeOutputSlot(2,IndustrialProcessing.itemSlag.itemID,RecipeSlotType.INVENTORY, 1, 2, 0)  };
		addRecipe(slag);
	}
}

package ip.industrialProcessing.machines.thickener;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesThickener extends RecipesMachine {
	public RecipesThickener() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		
	}

	private Recipe mixedIronSludgeToThickSludge(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeIron.getName()), RecipeSlotType.TANK, 1000)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickIronSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}
}

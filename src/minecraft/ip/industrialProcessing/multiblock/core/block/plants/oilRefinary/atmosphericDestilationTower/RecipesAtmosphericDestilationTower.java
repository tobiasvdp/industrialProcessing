package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesAtmosphericDestilationTower extends RecipesMachine {
	public RecipesAtmosphericDestilationTower() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(filtyToDirty(3000, 0));
	}

	private Recipe filtyToDirty(int i, int power) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5)};
		return recipe;
	}
}

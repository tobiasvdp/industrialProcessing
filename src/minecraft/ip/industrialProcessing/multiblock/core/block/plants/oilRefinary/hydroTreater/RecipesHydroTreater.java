package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesHydroTreater extends RecipesMachine {
	public RecipesHydroTreater() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(diesel(2000, 0));
	}
	
	private Recipe diesel(int i, int power) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidUntreatedDieselOil.getName()), RecipeSlotType.TANK, 100),new RecipeInputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidH2.getName()), RecipeSlotType.TANK, 100) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDieselOil.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(3, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidGasMix.getName()), RecipeSlotType.TANK, 100, 100, 0.5)};
		return recipe;
	}
}

package ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesGasProcessor extends RecipesMachine {
	public RecipesGasProcessor() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(something(3000, 0));
	}

	private Recipe something(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidGasMix.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidFuelGas.getName()), RecipeSlotType.TANK, 300, 400, 0.5), new RecipeOutputSlot(3, FluidRegistry.getFluidID(ISetupFluids.itemFluidUnsweetenedLPG.getName()), RecipeSlotType.TANK, 50, 70, 0.5), new RecipeOutputSlot(4, FluidRegistry.getFluidID(ISetupFluids.itemFluidUnsweetenedButane.getName()), RecipeSlotType.TANK, 200, 300, 0.5) };
		return recipe;
	}
}

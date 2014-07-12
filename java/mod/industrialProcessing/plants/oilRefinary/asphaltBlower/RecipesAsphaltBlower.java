package ip.industrialProcessing.machines.plants.oilRefinary.asphaltBlower;

import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesAsphaltBlower  extends RecipesMachine{
	public RecipesAsphaltBlower() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(asphalt(3000,0));
	}
    private Recipe asphalt(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidAsphaltSludge.getName()), RecipeSlotType.TANK, 100), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidAir.getName()), RecipeSlotType.TANK, 100) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(2, ISetupBlocks.blockAsphalt.blockID, RecipeSlotType.INVENTORY, 1, 1, 0.5)};
	return recipe;
    }
}

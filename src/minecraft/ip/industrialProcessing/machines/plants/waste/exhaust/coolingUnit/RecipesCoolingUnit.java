package ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesCoolingUnit extends RecipesMachine {
    public RecipesCoolingUnit() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(cooling(1000, 0));
    }

    private Recipe cooling(int work, int power) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = work;
	recipe.powerRequired = power;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidExhaustGas.getName()), RecipeSlotType.TANK, 200), new RecipeInputSlot(1, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 100) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidSteam.getName()), RecipeSlotType.TANK, 200, 200, 0) };
	return recipe;
    }
}

package ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesSourWaterStripper extends RecipesMachine {
    public RecipesSourWaterStripper() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(split(3000, 0));
    }

    private Recipe split(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidSourWater.getName()), RecipeSlotType.TANK, 100), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidSteam.getName()), RecipeSlotType.TANK, 100) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(3, FluidRegistry.getFluidID(ISetupFluids.itemFluidH2S.getName()), RecipeSlotType.TANK, 40, 70, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 80, 100, 0.5) };
	return recipe;
    }
}

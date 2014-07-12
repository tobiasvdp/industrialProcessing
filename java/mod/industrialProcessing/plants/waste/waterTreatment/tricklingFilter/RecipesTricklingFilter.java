package ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesTricklingFilter extends RecipesMachine {
    public RecipesTricklingFilter() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(uncleanToWater(3000, 1));
    }

    private Recipe uncleanToWater(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidUncleanWater.getName()), RecipeSlotType.TANK, 1000), new RecipeInputInventorySlot(0, ISetupItems.itemGrownCulture.itemID, RecipeSlotType.DAMAGEDITEM, 1) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidMicrobialWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }
}

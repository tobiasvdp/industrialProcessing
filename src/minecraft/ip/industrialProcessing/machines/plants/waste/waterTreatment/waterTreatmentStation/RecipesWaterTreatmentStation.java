package ip.industrialProcessing.machines.plants.waste.waterTreatment.waterTreatmentStation;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesWaterTreatmentStation extends RecipesMachine {
    public RecipesWaterTreatmentStation() {
        addDefaultRecipes();
    }

    private void addDefaultRecipes() {
        addRecipe(uncleanToWater(3000, 1));
    }

    private Recipe uncleanToWater(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMicrobialWater.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemActiveCoal.itemID, RecipeSlotType.DAMAGEDITEM, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(FluidRegistry.WATER.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
        return recipe;
    }
}

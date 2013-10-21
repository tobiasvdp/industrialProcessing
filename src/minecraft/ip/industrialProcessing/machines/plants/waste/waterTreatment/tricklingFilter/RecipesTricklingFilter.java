package ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesTricklingFilter extends RecipesMachine {
    public RecipesTricklingFilter() {
        addDefaultRecipes();
    }

    private void addDefaultRecipes() {
        addRecipe(uncleanToWater(3000, 1));
    }

    private Recipe uncleanToWater(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidUncleanWater.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemGrownCulture.itemID, RecipeSlotType.DAMAGEDITEM, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMicrobialWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
        return recipe;
    }
}

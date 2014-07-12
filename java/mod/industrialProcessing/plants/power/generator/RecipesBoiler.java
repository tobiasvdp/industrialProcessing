package mod.industrialProcessing.plants.power.generator;

import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.HeatRecipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesBoiler extends RecipesMachine {

    public RecipesBoiler() {
	HeatRecipe steam = new HeatRecipe();
	steam.workRequired = 3000;
	steam.heatRequired = 100;
	steam.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000) };

	int steamID = FluidRegistry.getFluid("steam").getID();
	steam.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, steamID, RecipeSlotType.TANK, 1000, 1000, 0.5) };
	addRecipe(steam);
    }
}

package ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesCoolingUnit extends RecipesMachine {
	public RecipesCoolingUnit() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(cooling(1000, 0));
	}

	private Recipe cooling(int work, int power) {
		Recipe recipe = new Recipe();
		recipe.workRequired = work;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidExhaustGas.getName()), RecipeSlotType.TANK, 200), new RecipeInputSlot(1, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 100) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidSteam.getName()), RecipeSlotType.TANK, 200, 200, 0) };
		return recipe;
	}
}

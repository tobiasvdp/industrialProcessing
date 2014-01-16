package ip.industrialProcessing.machines.plants.metalProcessing.extruder;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesExtruder extends RecipesMachine {

	public RecipesExtruder() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(hotSlagToSlag(3000, 1));
		addRecipe(CastIronIngot(3000, 0));
	}

	private Recipe hotSlagToSlag(int work, int power) {
		Recipe slag = new Recipe();
		slag.workRequired = work;
		slag.powerRequired = power;
		slag.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidHotSlag.getName()), RecipeSlotType.TANK, 1000) };
		slag.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemSlag.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		return slag;
	}

	private Recipe CastIronIngot(int work, int power) {
		Recipe recipe = new Recipe();
		recipe.workRequired = work;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPigIron.getName()), RecipeSlotType.TANK, 200)};
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		return recipe;
	}
}

package ip.industrialProcessing.machines.plants.metalProcessing.extruder;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesExtruder extends RecipesMachine {

    public RecipesExtruder() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(hotSlagToSlag(3000, 1));
	addRecipe(CastIronIngot(3000, 0));
    }

    private Recipe hotSlagToSlag(int work, int power) {
	PoweredRecipe slag = new PoweredRecipe();
	slag.workRequired = work;
	slag.powerRequired = power;
	slag.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidHotSlag.getName()), RecipeSlotType.TANK, 1000) };
	slag.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemSlag.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	return slag;
    }

    private Recipe CastIronIngot(int work, int power) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = work;
	recipe.powerRequired = power;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPigIron.getName()), RecipeSlotType.TANK, 200) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemIronBar.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	return recipe;
    }
}

package ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesVacuumCaster extends RecipesMachine {
	public RecipesVacuumCaster() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(CastIronIngot(3000, 0));
	}

	private Recipe CastIronIngot(int work, int power) {
		Recipe recipe = new Recipe();
		recipe.workRequired = work;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPigIron.getName()), RecipeSlotType.TANK, 800), new RecipeInputSlot(0, Item.bone.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		return recipe;
	}
}

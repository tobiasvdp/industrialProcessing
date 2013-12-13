package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMeroxTreater extends RecipesMachine {
	public RecipesMeroxTreater() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(kerosene(2000, 0));
	}
	
	private Recipe kerosene(int i, int power) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidUntreatedKerosene.getName()), RecipeSlotType.TANK, 100) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidKerosene.getName()), RecipeSlotType.TANK, 100, 100, 0.5)};
		return recipe;
	}
}
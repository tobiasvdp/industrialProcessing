package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMultiblockWeldingStation extends RecipesMachine {
	public RecipesMultiblockWeldingStation() {
		addDefaultRecipes();
	}
	private void addDefaultRecipes() {
		Recipe ironSludge= new Recipe();
		ironSludge.workRequired = 2000;
		ironSludge.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(0,FluidRegistry.getFluidID("fuel"),RecipeSlotType.TANK, 50)};
		ironSludge.outputs = new RecipeOutputSlot[] {};
		addRecipe(ironSludge);
	}
}

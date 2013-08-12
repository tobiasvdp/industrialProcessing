package ip.industrialProcessing.machines.oxygenFurnace;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesOxygenFurnace extends RecipesMachine {

	public RecipesOxygenFurnace() {
		addDefaultRecipes();
	}
	private void addDefaultRecipes() {

		Recipe steel= new Recipe();
		steel.workRequired = 30;
		steel.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(0,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPigIron.getName()),RecipeSlotType.TANK, 3000)};
		steel.outputs = new RecipeOutputSlot[] {
				new RecipeOutputSlot(1,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidHotSteel.getName()),RecipeSlotType.TANK, 2400, 3000, 0.5)  };
		addRecipe(steel);
	}
}

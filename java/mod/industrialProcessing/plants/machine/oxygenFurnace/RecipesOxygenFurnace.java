package ip.industrialProcessing.machines.oxygenFurnace;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesOxygenFurnace extends RecipesMachine {

	public RecipesOxygenFurnace() {
		addDefaultRecipes();
	}
	private void addDefaultRecipes() {

		Recipe steel= new Recipe();
		steel.workRequired = 30;
		steel.inputs = new RecipeInputInventorySlot[] { 
				new RecipeInputInventorySlot(0,FluidRegistry.getFluidID(ISetupFluids.itemFluidPigIron.getName()),RecipeSlotType.TANK, 3000)};
		steel.outputs = new RecipeOutputInventorySlot[] {
				new RecipeOutputInventorySlot(1,FluidRegistry.getFluidID(ISetupFluids.itemFluidHotSteel.getName()),RecipeSlotType.TANK, 2400, 3000, 0.5)  };
		addRecipe(steel);
	}
}

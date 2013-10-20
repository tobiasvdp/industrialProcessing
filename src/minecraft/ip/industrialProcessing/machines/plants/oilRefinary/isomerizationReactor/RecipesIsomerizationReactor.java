package ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesIsomerizationReactor  extends RecipesMachine{
	public RecipesIsomerizationReactor() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(something(3000,0));
	}
    private Recipe something(int i, int powerConsumption) {
    	Recipe recipe = new Recipe();
    	recipe.workRequired = i;
    	recipe.powerRequired = powerConsumption;
    	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidParaffinicNaphtha.getName()), RecipeSlotType.TANK, 200), new RecipeInputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidH2.getName()), RecipeSlotType.TANK, 1000) };
    	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidIsomerate.getName()), RecipeSlotType.TANK, 200, 250, 0.5),new RecipeOutputSlot(3, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidGasMix.getName()), RecipeSlotType.TANK, 80, 120, 0.5) };
    	return recipe;
    }
}

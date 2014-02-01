package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RecipesTurbine extends RecipesMachine {
    public RecipesTurbine() {
	Recipe recipe = new Recipe();
	recipe.workRequired = 1000;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, new FluidStack(IndustrialProcessing.itemFluidSteam, 100)) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, new FluidStack(FluidRegistry.WATER, 100)) };
	this.addRecipe(recipe);
    }
}

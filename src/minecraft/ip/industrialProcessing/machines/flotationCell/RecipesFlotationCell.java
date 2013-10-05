package ip.industrialProcessing.machines.flotationCell;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesFlotationCell extends RecipesMachine {
	public RecipesFlotationCell(){
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(dirtyToUnclean(3000));
	}
    private Recipe dirtyToUnclean(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidUncleanWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidResidu.getName()), RecipeSlotType.TANK, 100, 200, 0.5) };
		return recipe;
	}
	
}

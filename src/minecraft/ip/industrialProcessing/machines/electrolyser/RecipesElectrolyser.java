package ip.industrialProcessing.machines.electrolyser;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesElectrolyser extends RecipesMachine{
	public RecipesElectrolyser() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(electrolyse(3000,0));
	}
    private Recipe electrolyse(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidSteam.getName()), RecipeSlotType.TANK, 100), new RecipeInputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidAir.getName()), RecipeSlotType.TANK, 100) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(3, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCO2.getName()), RecipeSlotType.TANK, 80, 100, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidH2.getName()), RecipeSlotType.TANK, 350, 400, 0.5) };
	return recipe;
    }

}

package ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesSourWaterStripper extends RecipesMachine{
	public RecipesSourWaterStripper() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(split(3000,0));
	}
    private Recipe split(int i, int powerConsumption) {
    	Recipe recipe = new Recipe();
    	recipe.workRequired = i;
    	recipe.powerRequired = powerConsumption;
    	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidSourWater.getName()), RecipeSlotType.TANK, 100), new RecipeInputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidSteam.getName()), RecipeSlotType.TANK, 100) };
    	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(3, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidH2S.getName()), RecipeSlotType.TANK, 40, 70, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 80, 100, 0.5) };
    	return recipe;
    }
}

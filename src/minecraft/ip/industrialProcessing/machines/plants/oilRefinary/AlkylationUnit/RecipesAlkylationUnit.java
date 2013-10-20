package ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesAlkylationUnit extends RecipesMachine{
	public RecipesAlkylationUnit() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(butane(3000,0));
		addRecipe(isoButane(3000,0));
	}
    private Recipe butane(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidButane.getName()), RecipeSlotType.TANK, 100)};
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidAlkylate.getName()), RecipeSlotType.TANK, 40, 70, 0.5),new RecipeOutputSlot(3, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidGasMix.getName()), RecipeSlotType.TANK, 150, 200, 0.5) };
	return recipe;
    }
    private Recipe isoButane(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidIsoButane.getName()), RecipeSlotType.TANK, 100)};
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidAlkylate.getName()), RecipeSlotType.TANK, 40, 70, 0.5),new RecipeOutputSlot(3, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidGasMix.getName()), RecipeSlotType.TANK, 150, 200, 0.5) };
	return recipe;
    }
}

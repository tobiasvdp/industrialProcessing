package ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesAlkylationUnit extends RecipesMachine {
    public RecipesAlkylationUnit() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(butane(3000, 0));
	addRecipe(isoButane(3000, 0));
    }

    private Recipe butane(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidButane.getName()), RecipeSlotType.TANK, 100) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidAlkylate.getName()), RecipeSlotType.TANK, 40, 70, 0.5), new RecipeOutputSlot(3, FluidRegistry.getFluidID(ISetupFluids.itemFluidGasMix.getName()), RecipeSlotType.TANK, 150, 200, 0.5) };
	return recipe;
    }

    private Recipe isoButane(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidIsoButane.getName()), RecipeSlotType.TANK, 100) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidAlkylate.getName()), RecipeSlotType.TANK, 40, 70, 0.5), new RecipeOutputSlot(3, FluidRegistry.getFluidID(ISetupFluids.itemFluidGasMix.getName()), RecipeSlotType.TANK, 150, 200, 0.5) };
	return recipe;
    }
}

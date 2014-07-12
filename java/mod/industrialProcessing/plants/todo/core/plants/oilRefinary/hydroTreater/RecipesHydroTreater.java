package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.hydroTreater;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.multiblock.recipes.PoweredRecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesHydroTreater extends RecipesMultiblock {
    public RecipesHydroTreater() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(diesel(2000, 0, Tiers.Tier0));
    }

    private RecipeMultiblock diesel(int i, int power, Tiers tier) {
	PoweredRecipeMultiblock recipe = new PoweredRecipeMultiblock();
	recipe.workRequired = i;
	recipe.powerRequired = power;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidUntreatedDieselOil.getName()), RecipeSlotType.TANK, 100), new RecipeInputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidH2.getName()), RecipeSlotType.TANK, 100) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDieselOil.getName()), RecipeSlotType.TANK, 100, 100, 0.5), new RecipeOutputInventorySlot(3, FluidRegistry.getFluidID(ISetupFluids.itemFluidGasMix.getName()), RecipeSlotType.TANK, 100, 100, 0.5) };
	recipe.tier = tier;
	return recipe;
    }
}

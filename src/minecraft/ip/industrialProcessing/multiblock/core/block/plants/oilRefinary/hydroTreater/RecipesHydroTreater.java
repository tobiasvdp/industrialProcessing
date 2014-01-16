package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesHydroTreater extends RecipesMultiblock {
	public RecipesHydroTreater() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(diesel(2000, 0,Tiers.Tier0));
	}
	
	private RecipeMultiblock diesel(int i, int power,Tiers tier) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidUntreatedDieselOil.getName()), RecipeSlotType.TANK, 100),new RecipeInputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidH2.getName()), RecipeSlotType.TANK, 100) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDieselOil.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(3, FluidRegistry.getFluidID(ISetupFluids.itemFluidGasMix.getName()), RecipeSlotType.TANK, 100, 100, 0.5)};
		recipe.tier = tier;
		return recipe;
	}
}

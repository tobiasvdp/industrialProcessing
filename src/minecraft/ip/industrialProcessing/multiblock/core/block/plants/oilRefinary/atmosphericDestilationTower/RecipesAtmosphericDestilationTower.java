package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesAtmosphericDestilationTower extends RecipesMultiblock {
	public RecipesAtmosphericDestilationTower() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(filtyToDirty(12000, 0,Tiers.Tier0));
	}

	private RecipeMultiblock filtyToDirty(int i, int power,Tiers tier) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 100) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidAtmosphericBottoms.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidGasOil.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(3, FluidRegistry.getFluidID(ISetupFluids.itemFluidUntreatedDieselOil.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(4, FluidRegistry.getFluidID(ISetupFluids.itemFluidUntreatedKerosene.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(5, FluidRegistry.getFluidID(ISetupFluids.itemFluidHeavyNaphtha.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(6, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightNaphtha.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(7, FluidRegistry.getFluidID(ISetupFluids.itemFluidGasMix.getName()), RecipeSlotType.TANK, 100, 100, 0.5)};
		recipe.tier = tier;
		return recipe;
	}
}

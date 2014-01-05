package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.Recipe;
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
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 100) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidAtmosphericBottoms.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidGasOil.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(3, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidUntreatedDieselOil.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(4, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidUntreatedKerosene.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(5, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidHeavyNaphtha.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(6, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidLightNaphtha.getName()), RecipeSlotType.TANK, 100, 100, 0.5),new RecipeOutputSlot(7, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidGasMix.getName()), RecipeSlotType.TANK, 100, 100, 0.5)};
		recipe.tier = tier;
		return recipe;
	}
}

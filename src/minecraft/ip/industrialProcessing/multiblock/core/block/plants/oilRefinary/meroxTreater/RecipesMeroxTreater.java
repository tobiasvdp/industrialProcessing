package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMeroxTreater extends RecipesMultiblock {
	public RecipesMeroxTreater() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(kerosene(2000, 0,Tiers.Tier0));
	}
	
	private RecipeMultiblock kerosene(int i, int power,Tiers tier) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidUntreatedKerosene.getName()), RecipeSlotType.TANK, 100) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidKerosene.getName()), RecipeSlotType.TANK, 100, 100, 0.5)};
		recipe.tier = tier;
		return recipe;
	}
}

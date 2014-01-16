package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMultiblockBlastFurnace extends RecipesMultiblock {
    public RecipesMultiblockBlastFurnace() {
	addDefaultRecipes();
    }

	private void addDefaultRecipes() {
		addRecipe(meltIron(12000, 0, Tiers.Tier0));
	}

	private RecipeMultiblock meltIron(int i, int power, Tiers tier) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidAir.getName()), RecipeSlotType.TANK, 1000),new RecipeInputSlot(0, ISetupItems.itemIronSinter.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, ISetupItems.itemCokePellet.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] {new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidPigIron.getName()), RecipeSlotType.TANK, 800, 1200, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidHotSlag.getName()), RecipeSlotType.TANK, 300, 500, 0.5), new RecipeOutputSlot(3, FluidRegistry.getFluidID(ISetupFluids.itemFluidExhaustGas.getName()), RecipeSlotType.TANK, 100, 100, 0.5)};
		recipe.tier = tier;
		return recipe;
	}
}

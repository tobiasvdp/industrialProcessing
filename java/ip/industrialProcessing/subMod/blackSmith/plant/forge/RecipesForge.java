package ip.industrialProcessing.subMod.blackSmith.plant.forge;

import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import net.minecraft.item.ItemStack;

public class RecipesForge extends RecipesMultiblock {
	public RecipesForge() {
		addTier0Recipes();
	}

	private void addTier0Recipes() {
		addRecipe(heatIron(3000));
	}

	private RecipeMultiblock heatIron(int work) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = work;
		recipe.inputs =  new RecipeInputSlot[]{new RecipeInputSlot(0, new ItemStack(ISetupBlackSmith.itemWroughtIron))};
		recipe.outputs =  new RecipeOutputSlot[]{new RecipeOutputSlot(1, new ItemStack(ISetupBlackSmith.itemPliersBloomIron))};
		return recipe;
	}
}

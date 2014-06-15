package mod.industrialProcessing.plants.blackSmith.forge;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.item.ItemStack;

public class RecipesForge extends RecipesMultiblock {
	public RecipesForge() {
		addTier0Recipes();
	}

	private void addTier0Recipes() {
		addRecipe(heatIron(6000));
		addRecipe(heatCopper(6000));
	}

	private RecipeMultiblock heatIron(int work) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = work;
		recipe.inputs =  new RecipeInputSlot[]{new RecipeInputSlot(0, new ItemStack(IndustrialProcessing.itemWroughtIron))};
		recipe.outputs =  new RecipeOutputSlot[]{new RecipeOutputSlot(1, new ItemStack(IndustrialProcessing.itemPliersBloomIron))};
		return recipe;
	}
	private RecipeMultiblock heatCopper(int work) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = work;
		recipe.inputs =  new RecipeInputSlot[]{new RecipeInputSlot(0, new ItemStack(IndustrialProcessing.itemHeatedCopper))};
		recipe.outputs =  new RecipeOutputSlot[]{new RecipeOutputSlot(1, new ItemStack(IndustrialProcessing.itemPliersHeatedCopper))};
		return recipe;
	}
}

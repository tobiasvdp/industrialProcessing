package mod.industrialProcessing.plants.blackSmith.forge;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import net.minecraft.item.ItemStack;

public class RecipesForge extends RecipesMultiblock {
	public RecipesForge() {
		addTier0Recipes();
	}

	private void addTier0Recipes() {
		addRecipe(heatIron(6000));
		addRecipe(heatCopper(6000));
		addRecipe(heatIronCrushed(6000));
		addRecipe(heatCopperCrushed(6000));
	}

	private RecipeMultiblock heatIron(int work) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = work;
		recipe.inputs =  new RecipeInputInventorySlot[]{new RecipeInputInventorySlot(0, new ItemStack(IndustrialProcessing.itemWroughtIron))};
		recipe.outputs =  new RecipeOutputInventorySlot[]{new RecipeOutputInventorySlot(1, new ItemStack(IndustrialProcessing.itemPliersBloomIron))};
		return recipe;
	}
	private RecipeMultiblock heatCopper(int work) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = work;
		recipe.inputs =  new RecipeInputInventorySlot[]{new RecipeInputInventorySlot(0, new ItemStack(IndustrialProcessing.itemHeatedCopper))};
		recipe.outputs =  new RecipeOutputInventorySlot[]{new RecipeOutputInventorySlot(1, new ItemStack(IndustrialProcessing.itemPliersHeatedCopper))};
		return recipe;
	}
	private RecipeMultiblock heatIronCrushed(int work) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = work;
		recipe.inputs =  new RecipeInputInventorySlot[]{new RecipeInputInventorySlot(0, new ItemStack(IndustrialProcessing.itemIronCrushedChunks))};
		recipe.outputs =  new RecipeOutputInventorySlot[]{new RecipeOutputInventorySlot(1, new ItemStack(IndustrialProcessing.itemPliersBloomIron))};
		return recipe;
	}
	private RecipeMultiblock heatCopperCrushed(int work) {
		RecipeMultiblock recipe = new RecipeMultiblock();
		recipe.tier = Tiers.Tier0;
		recipe.workRequired = work;
		recipe.inputs =  new RecipeInputInventorySlot[]{new RecipeInputInventorySlot(0, new ItemStack(IndustrialProcessing.itemCopperCrushedChunks))};
		recipe.outputs =  new RecipeOutputInventorySlot[]{new RecipeOutputInventorySlot(1, new ItemStack(IndustrialProcessing.itemPliersHeatedCopper))};
		return recipe;
	}
}

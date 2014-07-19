package mod.industrialProcessing.plants.power.generator.generator;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.PoweredRecipeMultiblock;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class RecipesUpgradeGenerator extends RecipesMachine {
	public RecipesUpgradeGenerator() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		this.addRecipe(crank());

	}
	
	private Recipe crank(){
		Recipe recipe = new Recipe();

		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemCrankWheel, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockGenerator, 1)};

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockManualGenerator, 1, 1, 0) };

		return recipe;
	}

	
}

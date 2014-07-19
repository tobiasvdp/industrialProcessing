package mod.industrialProcessing.plants.power.motor.electroMotor;

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

public class RecipesUpgradeElectroMotor extends RecipesMachine {
	public RecipesUpgradeElectroMotor() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(generator());

	}

	private Recipe generator() {
		Recipe recipe = new Recipe();

		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(3, ISetupItems.itemMotorPoleAxis, 1), new RecipeInputInventorySlot(4, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(5, IndustrialProcessing.blockElectroMotor, 1), new RecipeInputInventorySlot(0, ISetupItems.itemIronPlate, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronPlate, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockGenerator, 1, 1, 0) };

		return recipe;
	}


}

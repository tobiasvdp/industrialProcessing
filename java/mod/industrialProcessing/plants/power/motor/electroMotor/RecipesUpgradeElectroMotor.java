package mod.industrialProcessing.plants.power.motor.electroMotor;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.PoweredRecipeMultiblock;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMachine;
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

		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, ISetupItems.itemMotorPoleAxis, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, IndustrialProcessing.blockElectroMotor, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronPlate, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockGenerator, RecipeSlotType.INVENTORY, 1, 1, 0) };

		return recipe;
	}


}

package mod.industrialProcessing.plants.construction.machineBlock;

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

public class RecipesUpgradeMachineBlock extends RecipesMachine {
	public RecipesUpgradeMachineBlock() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(crusher());
		addRecipe(electroMotor());
		addRecipe(mixer());
		addRecipe(filter());
		addRecipe(dryer());
	}

	private Recipe crusher() {
		Recipe recipe = new Recipe();

		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemSmallEngine, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemStripBoardWired, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemCrusingPlate, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemCrusingPlate, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockCrusher, RecipeSlotType.INVENTORY, 1, 1, 0) };

		return recipe;
	}
	private Recipe electroMotor() {
		Recipe recipe = new Recipe();

		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(3, ISetupItems.itemMotorStator, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemMotorRotor, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockElectroMotor, RecipeSlotType.INVENTORY, 1, 1, 0) };
		return recipe;
	}
	
    private Recipe mixer() {
    Recipe recipe = new Recipe();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(7, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(1, ISetupItems.itemSmallEngine, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(3, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(5, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(2, ISetupItems.itemIronBar, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemMixingHook, RecipeSlotType.INVENTORY, 1),
		new RecipeInputSlot(8, ISetupItems.itemStripBoardWired, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockMixer, RecipeSlotType.INVENTORY, 1, 1, 0) };

	return recipe;
    }
    
    private Recipe filter() {
    Recipe recipe = new Recipe();

	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemFilterTray, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, ISetupItems.itemFilterTray, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemSmallEngine, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemStripBoardWired, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockFilter, RecipeSlotType.INVENTORY, 1, 1, 0) };

	return recipe;
    }
    
    private Recipe dryer() {
    	Recipe recipe = new Recipe();

    	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(1, ISetupItems.itemStripBoardWired, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(6, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(7, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(8, ISetupItems.itemHeatingElement, RecipeSlotType.INVENTORY, 1) };

    	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(9, IndustrialProcessing.blockDryer, RecipeSlotType.INVENTORY, 1, 1, 0) };

    	return recipe;
    }

	
}

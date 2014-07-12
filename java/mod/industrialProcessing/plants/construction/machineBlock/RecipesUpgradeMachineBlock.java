package mod.industrialProcessing.plants.construction.machineBlock;

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
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;
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

		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemSmallEngine, 1), new RecipeInputInventorySlot(7, ISetupItems.itemStripBoardWired, 1), new RecipeInputInventorySlot(3, ISetupItems.itemCrusingPlate, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, ISetupItems.itemCrusingPlate, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockCrusher, 1, 1, 0) };

		return recipe;
	}
	private Recipe electroMotor() {
		Recipe recipe = new Recipe();

		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(3, ISetupItems.itemMotorStator, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(5, ISetupItems.itemMotorRotor, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockElectroMotor, 1, 1, 0) };
		return recipe;
	}
	
    private Recipe mixer() {
    Recipe recipe = new Recipe();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(7, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(1, ISetupItems.itemSmallEngine, 1), new RecipeInputInventorySlot(3, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(5, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(6, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(0, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(2, ISetupItems.itemIronBar, 1), new RecipeInputInventorySlot(4, ISetupItems.itemMixingHook, 1),
		new RecipeInputInventorySlot(8, ISetupItems.itemStripBoardWired, 1) };

	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockMixer, 1, 1, 0) };

	return recipe;
    }
    
    private Recipe filter() {
    Recipe recipe = new Recipe();

	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemFilterTray, 1), new RecipeInputInventorySlot(4, ISetupItems.itemFilterTray, 1), new RecipeInputInventorySlot(6, ISetupItems.itemSmallEngine, 1), new RecipeInputInventorySlot(7, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(8, ISetupItems.itemStripBoardWired, 1) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockFilter, 1, 1, 0) };

	return recipe;
    }
    
    private Recipe dryer() {
    	Recipe recipe = new Recipe();

    	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(1, ISetupItems.itemStripBoardWired, 1), new RecipeInputInventorySlot(4, IndustrialProcessing.blockMachineBlock, RecipeSlotType.INVENTORY, 1), new RecipeInputInventorySlot(6, ISetupItems.itemHeatingElement, 1), new RecipeInputInventorySlot(7, ISetupItems.itemHeatingElement, 1), new RecipeInputInventorySlot(8, ISetupItems.itemHeatingElement, 1) };

    	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(9, IndustrialProcessing.blockDryer, 1, 1, 0) };

    	return recipe;
    }

	
}

package ip.industrialProcessing.machines.crusher;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.NEIIPConfig;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesCrusher extends RecipesMachine {
	public RecipesCrusher() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(copperOreToCrushedChunks());
		addRecipe(tinOreToCrushedChunks());
		addRecipe(ironOreToCrushedChunks());
		addRecipe(goldOreToCrushedChunks());
		addRecipe(galenaOreToCrushedChunks());

		addRecipe(ironLargeToCrushedChunks());
		addRecipe(tinLargeToCrushedChunks());
		addRecipe(copperLargeToCrushedChunks());

		addRecipe(ironWashedToFineChunks());
		addRecipe(tinWashedToFineChunks());
		addRecipe(copperWashedToFineChunks());
	}

	private Recipe tinOreToCrushedChunks() {
		Recipe TinCrushing = new Recipe();
		TinCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1) };

		TinCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		TinCrushing.workRequired = 3000;
		return TinCrushing;
	}

	private Recipe tinLargeToCrushedChunks() {
		Recipe TinCrushing2 = new Recipe();
		TinCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		TinCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		TinCrushing2.workRequired = 3000;
		return TinCrushing2;
	}

	private Recipe tinWashedToFineChunks() {
		Recipe tinCrushing3 = new Recipe();
		tinCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		tinCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		tinCrushing3.workRequired = 3000;
		return tinCrushing3;
	}

	private Recipe galenaOreToCrushedChunks() {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockGalenaOre.blockID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = 3000;
		return recipe;
	}

	private Recipe goldOreToCrushedChunks() {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreGold.blockID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = 3000;
		return recipe;
	}

	private Recipe ironOreToCrushedChunks() {
		Recipe IronCrushing = new Recipe();
		IronCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

		IronCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		IronCrushing.workRequired = 3000;
		return IronCrushing;
	}

	private Recipe ironLargeToCrushedChunks() {
		// Large Iron to Crushed Iron chunks
		Recipe IronCrushing2 = new Recipe();
		IronCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		IronCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		IronCrushing2.workRequired = 3000;
		return IronCrushing2;
	}

	private Recipe ironWashedToFineChunks() {
		// Washed iron to fine ores chunks
		Recipe ironCrushing3 = new Recipe();
		ironCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		ironCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		ironCrushing3.workRequired = 3000;
		return ironCrushing3;
	}

	private Recipe copperOreToCrushedChunks() {
		Recipe copperCrushing = new Recipe();
		copperCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1) };
		copperCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		copperCrushing.workRequired = 3000;
		return copperCrushing;
	}

	private Recipe copperLargeToCrushedChunks() {
		Recipe copperCrushing2 = new Recipe();
		copperCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		copperCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		copperCrushing2.workRequired = 3000;
		return copperCrushing2;
	}

	private Recipe copperWashedToFineChunks() {
		Recipe copperCrushing3 = new Recipe();
		copperCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		copperCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		copperCrushing3.workRequired = 3000;
		return copperCrushing3;
	}

	private Recipe coalToUnknown() {
		return null;
	}
}

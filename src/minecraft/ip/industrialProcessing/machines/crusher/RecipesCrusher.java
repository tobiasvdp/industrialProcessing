package ip.industrialProcessing.machines.crusher;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
	    	//pass 1
		addRecipe(copperOreToCrushedChunks(3000));
		addRecipe(tinOreToCrushedChunks(3000));
		addRecipe(ironOreToCrushedChunks(3000));
		addRecipe(goldOreToCrushedChunks(3000));
		addRecipe(galenaOreToCrushedChunks(3000));
		addRecipe(chromiteOreToCrushedChunks(3000));
		addRecipe(taliaOreToCrushedChunks(3000));
		addRecipe(cinnebarCrystalToLarge(3000));
		addRecipe(RutileCrystalToLarge(3000));
		
		//pass 2
		addRecipe(ironLargeToCrushedChunks(3000));
		addRecipe(tinLargeToCrushedChunks(3000));
		addRecipe(copperLargeToCrushedChunks(3000));
		addRecipe(goldLargeToCrushedChunks(3000));
		addRecipe(galenaLargeToCrushedChunks(3000));
		addRecipe(chromiteLargeToCrushedChunks(3000));
		addRecipe(taliaLargeToCrushedChunks(3000));

		//pass 3
		addRecipe(ironWashedToFineChunks(3000));
		addRecipe(tinWashedToFineChunks(3000));
		addRecipe(copperWashedToFineChunks(3000));
		addRecipe(goldWashedToFineChunks(3000));
		addRecipe(galenaWashedToFineChunks(3000));
		addRecipe(chromiteWashedToFineChunks(3000));
		addRecipe(taliaWashedToFineChunks(3000));
		addRecipe(cinnebarLargeToSmall(3000));
		addRecipe(RutileLargeToSmall(3000));
		
		addRecipe(cinnebarSmallToFine(3000));
		addRecipe(RutileSmallToFine(3000));
		
		addRecipe(cinnebarFineToDust(3000));
		addRecipe(RutileFineToDust(3000));
		
		addRecipe(coalToDust(3000));
		
	}

	private Recipe coalToDust(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.coal.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCoalDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}
	
	private Recipe RutileFineToDust(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemRutileFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemRutileDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe cinnebarFineToDust(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCinnebarFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCinnebarDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe RutileSmallToFine(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemRutileSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemRutileFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe cinnebarSmallToFine(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCinnebarSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCinnebarFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe RutileLargeToSmall(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemRutileLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemRutileSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe cinnebarLargeToSmall(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCinnebarLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCinnebarSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe taliaWashedToFineChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTaliaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTaliaFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe chromiteWashedToFineChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemChromiteWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemChromiteFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe galenaWashedToFineChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGalenaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGalenaFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe goldWashedToFineChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGoldWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe taliaLargeToCrushedChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTaliaLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTaliaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe chromiteLargeToCrushedChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemChromiteLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemChromiteCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe galenaLargeToCrushedChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGalenaLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe goldLargeToCrushedChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGoldLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe RutileCrystalToLarge(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockRutile.blockID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemRutileLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe cinnebarCrystalToLarge(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCinnebar.blockID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCinnebarLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe taliaOreToCrushedChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockTaliaOre.blockID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTaliaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe chromiteOreToCrushedChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockChromiteOre.blockID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemChromiteCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe tinOreToCrushedChunks(int workTime) {
		Recipe TinCrushing = new Recipe();
		TinCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1) };

		TinCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		TinCrushing.workRequired = workTime;
		return TinCrushing;
	}

	private Recipe tinLargeToCrushedChunks(int workTime) {
		Recipe TinCrushing2 = new Recipe();
		TinCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		TinCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		TinCrushing2.workRequired = workTime;
		return TinCrushing2;
	}

	private Recipe tinWashedToFineChunks(int workTime) {
		Recipe tinCrushing3 = new Recipe();
		tinCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

		tinCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		tinCrushing3.workRequired = workTime;
		return tinCrushing3;
	}

	private Recipe galenaOreToCrushedChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockGalenaOre.blockID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe goldOreToCrushedChunks(int workTime) {
		Recipe recipe = new Recipe();
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreGold.blockID, RecipeSlotType.INVENTORY, 1) };

		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		recipe.workRequired = workTime;
		return recipe;
	}

	private Recipe ironOreToCrushedChunks(int workTime) {
		Recipe IronCrushing = new Recipe();
		IronCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

		IronCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		IronCrushing.workRequired = workTime;
		return IronCrushing;
	}

	private Recipe ironLargeToCrushedChunks(int workTime) {
		Recipe IronCrushing2 = new Recipe();
		IronCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		IronCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		IronCrushing2.workRequired = workTime;
		return IronCrushing2;
	}

	private Recipe ironWashedToFineChunks(int workTime) {
		// Washed iron to fine ores chunks
		Recipe ironCrushing3 = new Recipe();
		ironCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		ironCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		ironCrushing3.workRequired = workTime;
		return ironCrushing3;
	}

	private Recipe copperOreToCrushedChunks(int workTime) {
		Recipe copperCrushing = new Recipe();
		copperCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1) };
		copperCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
		copperCrushing.workRequired = workTime;
		return copperCrushing;
	}

	private Recipe copperLargeToCrushedChunks(int workTime) {
		Recipe copperCrushing2 = new Recipe();
		copperCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		copperCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		copperCrushing2.workRequired = workTime;
		return copperCrushing2;
	}

	private Recipe copperWashedToFineChunks(int workTime) {
		Recipe copperCrushing3 = new Recipe();
		copperCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		copperCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
		copperCrushing3.workRequired = workTime;
		return copperCrushing3;
	}

	private Recipe coalToUnknown() {
		return null;
	}
}

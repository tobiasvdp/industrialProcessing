package mod.industrialProcessing.plants.grinding.crusher;

import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class RecipesCrusher extends RecipesMachine {
	private static final int POWER_FACTOR = 5;

	public RecipesCrusher() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {

		addRecipe(limestoneToDust(3000, 1));

		// pass 1
		addRecipe(copperOreToCrushedChunks(3000, 1));
		addRecipe(tinOreToCrushedChunks(3000, 1));
		addRecipe(ironOreToCrushedChunks(3000, 1));
		addRecipe(goldOreToCrushedChunks(3000, 1));
		addRecipe(galenaOreToCrushedChunks(3000, 1));
		addRecipe(chromiteOreToCrushedChunks(3000, 1));
		addRecipe(taliaOreToCrushedChunks(3000, 1));
		addRecipe(cinnebarCrystalToLarge(3000, 1));
		addRecipe(RutileCrystalToLarge(3000, 1));

		// pass 2
		addRecipe(ironLargeToCrushedChunks(3000, 1));
		addRecipe(tinLargeToCrushedChunks(3000, 1));
		addRecipe(copperLargeToCrushedChunks(3000, 1));
		addRecipe(goldLargeToCrushedChunks(3000, 1));
		addRecipe(galenaLargeToCrushedChunks(3000, 1));
		addRecipe(chromiteLargeToCrushedChunks(3000, 1));
		addRecipe(taliaLargeToCrushedChunks(3000, 1));

		// pass 3
		addRecipe(ironWashedToFineChunks(2000, 1));
		addRecipe(tinWashedToFineChunks(3000, 1));
		addRecipe(copperWashedToFineChunks(3000, 1));
		addRecipe(goldWashedToFineChunks(3000, 1));
		addRecipe(galenaWashedToFineChunks(3000, 1));
		addRecipe(chromiteWashedToFineChunks(3000, 1));
		addRecipe(taliaWashedToFineChunks(3000, 1));
		addRecipe(cinnebarLargeToSmall(3000, 1));
		addRecipe(RutileLargeToSmall(3000, 1));

		addRecipe(cinnebarSmallToFine(3000, 1));
		addRecipe(RutileSmallToFine(3000, 1));

		addRecipe(cinnebarFineToDust(3000, 1));
		addRecipe(RutileFineToDust(3000, 1));

		addRecipe(coalToDust(3000, 1));
		addRecipe(limestoneToDust(3000, 1));

		addRecipe(bonemeal(3000, 1));

	}

	private PoweredRecipe bonemeal(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Items.bone, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, Items.dye, 16, 3, 6, 0.25) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe coalToDust(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Items.coal, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCoalDust, 1, 3, 0.5) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe limestoneToDust(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(ISetupBlocks.blockCobbleLimestone), 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemLimestoneDust, 1, 2, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe RutileFineToDust(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemRutileFineCrushedCrystals, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemRutileDust, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe cinnebarFineToDust(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCinnebarFineCrushedCrystals, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCinnebarDust, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe RutileSmallToFine(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemRutileSmallCrushedCrystals, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemRutileFineCrushedCrystals, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe cinnebarSmallToFine(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCinnebarSmallCrushedCrystals, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCinnebarFineCrushedCrystals, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe RutileLargeToSmall(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemRutileLargeCrushedCrystals, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemRutileSmallCrushedCrystals, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe cinnebarLargeToSmall(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCinnebarLargeCrushedCrystals, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCinnebarSmallCrushedCrystals, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe taliaWashedToFineChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTaliaWashedChunks, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTaliaFineChunks, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe chromiteWashedToFineChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemChromiteWashedChunks, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemChromiteFineChunks, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe galenaWashedToFineChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGalenaWashedChunks, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGalenaFineChunks, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private PoweredRecipe goldWashedToFineChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGoldWashedChunks, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGoldFineChunks, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe taliaLargeToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTaliaLargeChunks, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTaliaCrushedChunks, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe chromiteLargeToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemChromiteLargeChunks, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemChromiteCrushedChunks, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe galenaLargeToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGalenaLargeChunks, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGalenaCrushedChunks, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe goldLargeToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGoldLargeChunks, 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGoldCrushedChunks, 1, 3, 0) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe RutileCrystalToLarge(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(ISetupBlocks.blockRutile), 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemRutileLargeCrushedCrystals, 1, 2, 0.2) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe cinnebarCrystalToLarge(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(ISetupBlocks.blockCinnebar), 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCinnebarLargeCrushedCrystals, 1, 3, 0.2) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe taliaOreToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(ISetupBlocks.blockTaliaOre), 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTaliaCrushedChunks, 1, 2, 0.2) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe chromiteOreToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(ISetupBlocks.blockChromiteOre), 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemChromiteCrushedChunks, 1, 2, 0.2) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe tinOreToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe TinCrushing = new PoweredRecipe();
		TinCrushing.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(ISetupBlocks.blockTinOre), 1) };

		TinCrushing.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTinCrushedChunks, 1, 2, 0.2) };
		TinCrushing.workRequired = workTime;
		TinCrushing.powerRequired = powerConsumption * POWER_FACTOR;
		return TinCrushing;
	}

	private Recipe tinLargeToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe TinCrushing2 = new PoweredRecipe();
		TinCrushing2.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTinLargeChunks, 1) };

		TinCrushing2.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTinCrushedChunks, 1, 1, 0) };
		TinCrushing2.workRequired = workTime;
		TinCrushing2.powerRequired = powerConsumption * POWER_FACTOR;
		return TinCrushing2;
	}

	private Recipe tinWashedToFineChunks(int workTime, int powerConsumption) {
		PoweredRecipe tinCrushing3 = new PoweredRecipe();
		tinCrushing3.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTinWashedChunks, 1) };

		tinCrushing3.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTinFineChunks, 1, 1, 0) };
		tinCrushing3.workRequired = workTime;
		tinCrushing3.powerRequired = powerConsumption * POWER_FACTOR;
		return tinCrushing3;
	}

	private Recipe galenaOreToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(ISetupBlocks.blockGalenaOre), 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGalenaCrushedChunks, 1, 2, 0.2) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe goldOreToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(Blocks.gold_ore), 1) };

		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGoldCrushedChunks, 1, 2, 0.2) };
		recipe.workRequired = workTime;
		recipe.powerRequired = powerConsumption * POWER_FACTOR;
		return recipe;
	}

	private Recipe ironOreToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe IronCrushing = new PoweredRecipe();
		IronCrushing.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(Blocks.iron_ore), 1) };

		IronCrushing.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemIronCrushedChunks, 1, 2, 0.2) };
		IronCrushing.workRequired = workTime;
		IronCrushing.powerRequired = powerConsumption * POWER_FACTOR;
		return IronCrushing;
	}

	private Recipe ironLargeToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe IronCrushing2 = new PoweredRecipe();
		IronCrushing2.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronLargeChunks, 1) };
		IronCrushing2.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemIronCrushedChunks, 1, 1, 0) };
		IronCrushing2.workRequired = workTime;
		IronCrushing2.powerRequired = powerConsumption * POWER_FACTOR;
		return IronCrushing2;
	}

	private Recipe ironWashedToFineChunks(int workTime, int powerConsumption) {
		// Washed iron to fine ores chunks
		PoweredRecipe ironCrushing3 = new PoweredRecipe();
		ironCrushing3.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronWashedChunks, 1) };
		ironCrushing3.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemIronFineChunks, 1, 2, 0.3) };
		ironCrushing3.workRequired = workTime;
		ironCrushing3.powerRequired = powerConsumption * POWER_FACTOR;
		return ironCrushing3;
	}

	private Recipe copperOreToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe copperCrushing = new PoweredRecipe();
		copperCrushing.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, Item.getItemFromBlock(ISetupBlocks.blockCopperOre), 1) };
		copperCrushing.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCopperCrushedChunks, 1, 2, 0.2) };
		copperCrushing.workRequired = workTime;
		copperCrushing.powerRequired = powerConsumption * POWER_FACTOR;
		return copperCrushing;
	}

	private Recipe copperLargeToCrushedChunks(int workTime, int powerConsumption) {
		PoweredRecipe copperCrushing2 = new PoweredRecipe();
		copperCrushing2.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCopperLargeChunks, 1) };
		copperCrushing2.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCopperCrushedChunks, 1, 1, 0) };
		copperCrushing2.workRequired = workTime;
		copperCrushing2.powerRequired = powerConsumption * POWER_FACTOR;
		return copperCrushing2;
	}

	private Recipe copperWashedToFineChunks(int workTime, int powerConsumption) {
		PoweredRecipe copperCrushing3 = new PoweredRecipe();
		copperCrushing3.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCopperWashedChunks, 1) };
		copperCrushing3.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCopperFineChunks, 1, 1, 0) };
		copperCrushing3.workRequired = workTime;
		copperCrushing3.powerRequired = powerConsumption * POWER_FACTOR;
		return copperCrushing3;
	}

	private Recipe coalToUnknown() {
		return null;
	}
}

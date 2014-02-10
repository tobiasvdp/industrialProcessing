package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RecipesCrusher extends RecipesMachine {
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

    private Recipe bonemeal(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.bone.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.dyePowder.itemID, 16, RecipeSlotType.INVENTORY, 3, 6, 0.25) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe coalToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.coal.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCoalDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe limestoneToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupBlocks.blockCobbleLimestone.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemLimestoneDust.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe RutileFineToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemRutileFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemRutileDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe cinnebarFineToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCinnebarFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCinnebarDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe RutileSmallToFine(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemRutileSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemRutileFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe cinnebarSmallToFine(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCinnebarSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCinnebarFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe RutileLargeToSmall(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemRutileLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemRutileSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe cinnebarLargeToSmall(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCinnebarLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCinnebarSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe taliaWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTaliaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe chromiteWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemChromiteWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe galenaWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGalenaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGalenaFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe goldWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGoldWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe taliaLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTaliaLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe chromiteLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemChromiteLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe galenaLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGalenaLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe goldLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGoldLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe RutileCrystalToLarge(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupBlocks.blockRutile.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemRutileLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe cinnebarCrystalToLarge(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupBlocks.blockCinnebar.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCinnebarLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe taliaOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupBlocks.blockTaliaOre.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe chromiteOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupBlocks.blockChromiteOre.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe tinOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe TinCrushing = new PoweredRecipe();
	TinCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupBlocks.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1) };

	TinCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
	TinCrushing.workRequired = workTime;
	TinCrushing.powerRequired = powerConsumption;
	return TinCrushing;
    }

    private Recipe tinLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe TinCrushing2 = new PoweredRecipe();
	TinCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTinLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	TinCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	TinCrushing2.workRequired = workTime;
	TinCrushing2.powerRequired = powerConsumption;
	return TinCrushing2;
    }

    private Recipe tinWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe tinCrushing3 = new PoweredRecipe();
	tinCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTinWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

	tinCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	tinCrushing3.workRequired = workTime;
	tinCrushing3.powerRequired = powerConsumption;
	return tinCrushing3;
    }

    private Recipe galenaOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupBlocks.blockGalenaOre.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe goldOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreGold.blockID, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe ironOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe IronCrushing = new PoweredRecipe();
	IronCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

	IronCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.2) };
	IronCrushing.workRequired = workTime;
	IronCrushing.powerRequired = powerConsumption;
	return IronCrushing;
    }

    private Recipe ironLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe IronCrushing2 = new PoweredRecipe();
	IronCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	IronCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	IronCrushing2.workRequired = workTime;
	IronCrushing2.powerRequired = powerConsumption;
	return IronCrushing2;
    }

    private Recipe ironWashedToFineChunks(int workTime, int powerConsumption) {
	// Washed iron to fine ores chunks
	PoweredRecipe ironCrushing3 = new PoweredRecipe();
	ironCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	ironCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.3) };
	ironCrushing3.workRequired = workTime;
	ironCrushing3.powerRequired = powerConsumption;
	return ironCrushing3;
    }

    private Recipe copperOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe copperCrushing = new PoweredRecipe();
	copperCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupBlocks.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1) };
	copperCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
	copperCrushing.workRequired = workTime;
	copperCrushing.powerRequired = powerConsumption;
	return copperCrushing;
    }

    private Recipe copperLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe copperCrushing2 = new PoweredRecipe();
	copperCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	copperCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	copperCrushing2.workRequired = workTime;
	copperCrushing2.powerRequired = powerConsumption;
	return copperCrushing2;
    }

    private Recipe copperWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe copperCrushing3 = new PoweredRecipe();
	copperCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	copperCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	copperCrushing3.workRequired = workTime;
	copperCrushing3.powerRequired = powerConsumption;
	return copperCrushing3;
    }

    private Recipe coalToUnknown() {
	return null;
    }
}

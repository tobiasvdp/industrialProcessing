package mod.industrialProcessing.plants.machine.crusher;

import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Items.bone, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Items.dye, 16, RecipeSlotType.INVENTORY, 3, 6, 0.25) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe coalToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Items.coal, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCoalDust, RecipeSlotType.INVENTORY, 1, 3, 0.5) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe limestoneToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(ISetupBlocks.blockCobbleLimestone), RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemLimestoneDust, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe RutileFineToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemRutileFineCrushedCrystals, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemRutileDust, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe cinnebarFineToDust(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCinnebarFineCrushedCrystals, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCinnebarDust, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe RutileSmallToFine(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemRutileSmallCrushedCrystals, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemRutileFineCrushedCrystals, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe cinnebarSmallToFine(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCinnebarSmallCrushedCrystals, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCinnebarFineCrushedCrystals, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe RutileLargeToSmall(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemRutileLargeCrushedCrystals, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemRutileSmallCrushedCrystals, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe cinnebarLargeToSmall(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCinnebarLargeCrushedCrystals, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCinnebarSmallCrushedCrystals, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe taliaWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTaliaWashedChunks, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaFineChunks, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe chromiteWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemChromiteWashedChunks, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteFineChunks, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe galenaWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGalenaWashedChunks, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGalenaFineChunks, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe goldWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGoldWashedChunks, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldFineChunks, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe taliaLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTaliaLargeChunks, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaCrushedChunks, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe chromiteLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemChromiteLargeChunks, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteCrushedChunks, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe galenaLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGalenaLargeChunks, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGalenaCrushedChunks, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe goldLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGoldLargeChunks, RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldCrushedChunks, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe RutileCrystalToLarge(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(ISetupBlocks.blockRutile), RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemRutileLargeCrushedCrystals, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe cinnebarCrystalToLarge(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(ISetupBlocks.blockCinnebar), RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCinnebarLargeCrushedCrystals, RecipeSlotType.INVENTORY, 1, 3, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe taliaOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(ISetupBlocks.blockTaliaOre), RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaCrushedChunks, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe chromiteOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(ISetupBlocks.blockChromiteOre), RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteCrushedChunks, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe tinOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe TinCrushing = new PoweredRecipe();
	TinCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(ISetupBlocks.blockTinOre), RecipeSlotType.INVENTORY, 1) };

	TinCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinCrushedChunks, RecipeSlotType.INVENTORY, 1, 2, 0) };
	TinCrushing.workRequired = workTime;
	TinCrushing.powerRequired = powerConsumption;
	return TinCrushing;
    }

    private Recipe tinLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe TinCrushing2 = new PoweredRecipe();
	TinCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTinLargeChunks, RecipeSlotType.INVENTORY, 1) };

	TinCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinCrushedChunks, RecipeSlotType.INVENTORY, 1, 1, 0) };
	TinCrushing2.workRequired = workTime;
	TinCrushing2.powerRequired = powerConsumption;
	return TinCrushing2;
    }

    private Recipe tinWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe tinCrushing3 = new PoweredRecipe();
	tinCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTinWashedChunks, RecipeSlotType.INVENTORY, 1) };

	tinCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinFineChunks, RecipeSlotType.INVENTORY, 1, 1, 0) };
	tinCrushing3.workRequired = workTime;
	tinCrushing3.powerRequired = powerConsumption;
	return tinCrushing3;
    }

    private Recipe galenaOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(ISetupBlocks.blockGalenaOre), RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGalenaCrushedChunks, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe goldOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(Blocks.gold_ore), RecipeSlotType.INVENTORY, 1) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldCrushedChunks, RecipeSlotType.INVENTORY, 1, 2, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }

    private Recipe ironOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe IronCrushing = new PoweredRecipe();
	IronCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(Blocks.iron_ore), RecipeSlotType.INVENTORY, 1) };

	IronCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronCrushedChunks, RecipeSlotType.INVENTORY, 1, 2, 0.2) };
	IronCrushing.workRequired = workTime;
	IronCrushing.powerRequired = powerConsumption;
	return IronCrushing;
    }

    private Recipe ironLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe IronCrushing2 = new PoweredRecipe();
	IronCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronLargeChunks, RecipeSlotType.INVENTORY, 1) };
	IronCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronCrushedChunks, RecipeSlotType.INVENTORY, 1, 1, 0) };
	IronCrushing2.workRequired = workTime;
	IronCrushing2.powerRequired = powerConsumption;
	return IronCrushing2;
    }

    private Recipe ironWashedToFineChunks(int workTime, int powerConsumption) {
	// Washed iron to fine ores chunks
	PoweredRecipe ironCrushing3 = new PoweredRecipe();
	ironCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronWashedChunks, RecipeSlotType.INVENTORY, 1) };
	ironCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronFineChunks, RecipeSlotType.INVENTORY, 1, 2, 0.3) };
	ironCrushing3.workRequired = workTime;
	ironCrushing3.powerRequired = powerConsumption;
	return ironCrushing3;
    }

    private Recipe copperOreToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe copperCrushing = new PoweredRecipe();
	copperCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.getItemFromBlock(ISetupBlocks.blockCopperOre), RecipeSlotType.INVENTORY, 1) };
	copperCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperCrushedChunks, RecipeSlotType.INVENTORY, 1, 2, 0) };
	copperCrushing.workRequired = workTime;
	copperCrushing.powerRequired = powerConsumption;
	return copperCrushing;
    }

    private Recipe copperLargeToCrushedChunks(int workTime, int powerConsumption) {
	PoweredRecipe copperCrushing2 = new PoweredRecipe();
	copperCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperLargeChunks, RecipeSlotType.INVENTORY, 1) };
	copperCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperCrushedChunks, RecipeSlotType.INVENTORY, 1, 1, 0) };
	copperCrushing2.workRequired = workTime;
	copperCrushing2.powerRequired = powerConsumption;
	return copperCrushing2;
    }

    private Recipe copperWashedToFineChunks(int workTime, int powerConsumption) {
	PoweredRecipe copperCrushing3 = new PoweredRecipe();
	copperCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperWashedChunks, RecipeSlotType.INVENTORY, 1) };
	copperCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperFineChunks, RecipeSlotType.INVENTORY, 1, 1, 0) };
	copperCrushing3.workRequired = workTime;
	copperCrushing3.powerRequired = powerConsumption;
	return copperCrushing3;
    }

    private Recipe coalToUnknown() {
	return null;
    }
}

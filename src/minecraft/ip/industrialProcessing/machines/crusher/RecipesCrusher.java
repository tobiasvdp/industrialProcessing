package ip.industrialProcessing.machines.crusher;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
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
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.bone.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.dyePowder.itemID, 16, RecipeSlotType.INVENTORY, 3, 6, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }
    
    private Recipe coalToDust(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.coal.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCoalDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }
    private Recipe limestoneToDust(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCobbleLimestone.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemLimestoneDust.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe RutileFineToDust(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemRutileFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemRutileDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe cinnebarFineToDust(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCinnebarFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCinnebarDust.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe RutileSmallToFine(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemRutileSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemRutileFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe cinnebarSmallToFine(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCinnebarSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCinnebarFineCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe RutileLargeToSmall(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemRutileLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemRutileSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe cinnebarLargeToSmall(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCinnebarLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCinnebarSmallCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe taliaWashedToFineChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTaliaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTaliaFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe chromiteWashedToFineChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemChromiteWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemChromiteFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe galenaWashedToFineChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGalenaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGalenaFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe goldWashedToFineChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGoldWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe taliaLargeToCrushedChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTaliaLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTaliaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe chromiteLargeToCrushedChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemChromiteLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemChromiteCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe galenaLargeToCrushedChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGalenaLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe goldLargeToCrushedChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGoldLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe RutileCrystalToLarge(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockRutile.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemRutileLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe cinnebarCrystalToLarge(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCinnebar.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCinnebarLargeCrushedCrystals.itemID, RecipeSlotType.INVENTORY, 1, 3, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe taliaOreToCrushedChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockTaliaOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTaliaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe chromiteOreToCrushedChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockChromiteOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemChromiteCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe tinOreToCrushedChunks(int workTime, int powerConsumption) {
        Recipe TinCrushing = new Recipe();
        TinCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1) };

        TinCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
        TinCrushing.workRequired = workTime;
        TinCrushing.powerRequired = powerConsumption;
        return TinCrushing;
    }

    private Recipe tinLargeToCrushedChunks(int workTime, int powerConsumption) {
        Recipe TinCrushing2 = new Recipe();
        TinCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        TinCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
        TinCrushing2.workRequired = workTime;
        TinCrushing2.powerRequired = powerConsumption;
        return TinCrushing2;
    }

    private Recipe tinWashedToFineChunks(int workTime, int powerConsumption) {
        Recipe tinCrushing3 = new Recipe();
        tinCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };

        tinCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
        tinCrushing3.workRequired = workTime;
        tinCrushing3.powerRequired = powerConsumption;
        return tinCrushing3;
    }

    private Recipe galenaOreToCrushedChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockGalenaOre.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe goldOreToCrushedChunks(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreGold.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

    private Recipe ironOreToCrushedChunks(int workTime, int powerConsumption) {
        Recipe IronCrushing = new Recipe();
        IronCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

        IronCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.2) };
        IronCrushing.workRequired = workTime;
        IronCrushing.powerRequired = powerConsumption;
        return IronCrushing;
    }

    private Recipe ironLargeToCrushedChunks(int workTime, int powerConsumption) {
        Recipe IronCrushing2 = new Recipe();
        IronCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        IronCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
        IronCrushing2.workRequired = workTime;
        IronCrushing2.powerRequired = powerConsumption;
        return IronCrushing2;
    }

    private Recipe ironWashedToFineChunks(int workTime, int powerConsumption) {
        // Washed iron to fine ores chunks
        Recipe ironCrushing3 = new Recipe();
        ironCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        ironCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.3) };
        ironCrushing3.workRequired = workTime;
        ironCrushing3.powerRequired = powerConsumption;
        return ironCrushing3;
    }

    private Recipe copperOreToCrushedChunks(int workTime, int powerConsumption) {
        Recipe copperCrushing = new Recipe();
        copperCrushing.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1) };
        copperCrushing.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
        copperCrushing.workRequired = workTime;
        copperCrushing.powerRequired = powerConsumption;
        return copperCrushing;
    }

    private Recipe copperLargeToCrushedChunks(int workTime, int powerConsumption) {
        Recipe copperCrushing2 = new Recipe();
        copperCrushing2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        copperCrushing2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
        copperCrushing2.workRequired = workTime;
        copperCrushing2.powerRequired = powerConsumption;
        return copperCrushing2;
    }

    private Recipe copperWashedToFineChunks(int workTime, int powerConsumption) {
        Recipe copperCrushing3 = new Recipe();
        copperCrushing3.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperWashedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        copperCrushing3.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperFineChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
        copperCrushing3.workRequired = workTime;
        copperCrushing3.powerRequired = powerConsumption;
        return copperCrushing3;
    }

    private Recipe coalToUnknown() {
        return null;
    }
}

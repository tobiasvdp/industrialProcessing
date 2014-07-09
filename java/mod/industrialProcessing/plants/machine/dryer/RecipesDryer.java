package mod.industrialProcessing.plants.machine.dryer;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.init.Blocks;

public class RecipesDryer extends RecipesMachine {

    public RecipesDryer() {
	addRecipe(ironSludgeToCleanChunks(3000, 1));
	addRecipe(copperSludgeToCleanChunks(3000, 1));
	addRecipe(tinSludgeToCleanChunks(3000, 1));
	addRecipe(goldSludgeToCleanChunks(3000, 1));
	addRecipe(galenaSludgeToCleanChunks(3000, 1));
	addRecipe(taliaSludgeToCleanChunks(3000, 1));
	addRecipe(chromiteSludgeToCleanChunks(3000, 1));
	addRecipe(gritSludgeToGrit(3000, 1));
	addRecipe(residuToSand(3000, 1));
	addRecipe(ironPasteToDust(3000, 1));
	addRecipe(TinPasteToDust(3000, 1));
	addRecipe(CopperPasteToDust(3000, 1));
	addRecipe(GoldPasteToDust(3000, 1));
	addRecipe(GalenaPasteToDust(3000, 1));
	addRecipe(ChromitePasteToDust(3000, 1));
	addRecipe(TaliaPasteToDust(3000, 1));
    }

    private Recipe gritSludgeToGrit(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidGritSludge.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupBlocks.blockGrit, RecipeSlotType.INVENTORY, 1, 1, 0) };
	return recipe;
    }

    private Recipe residuToSand(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidResidu.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, Blocks.sand, RecipeSlotType.INVENTORY, 1, 1, 0) };
	return recipe;
    }

    private Recipe chromiteSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidOreSludgeChromite.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemChromiteWashedChunks, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidFiltyWater.getItem(), 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe taliaSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidOreSludgeTalia.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTaliaWashedChunks, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidFiltyWater.getItem(), 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe galenaSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidOreSludgeGalena.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemGalenaWashedChunks, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidFiltyWater.getItem(), 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe goldSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidOreSludgeGold.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemGoldWashedChunks, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidFiltyWater.getItem(), 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe tinSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidOreSludgeTin.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTinWashedChunks, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidFiltyWater.getItem(), 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe copperSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidOreSludgeCopper.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemCopperWashedChunks, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidFiltyWater.getItem(), 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe ironSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidOreSludgeIron.getItem(), 120) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemIronWashedChunks, RecipeSlotType.INVENTORY, 1, 2, 0.2), new RecipeOutputSlot(1, IndustrialProcessing.fluidFiltyWater.getItem(), 90, 110, 0.5) };
	return recipe;
    }

    private Recipe ironPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidPasteIronSediment.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemIronOxideDust, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidDirtyWater.getItem(), 0, 200, 0.5) };
	return recipe;
    }

    private Recipe TinPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidPasteTinSediment.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTinOxideDust, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidDirtyWater.getItem(), 0, 200, 0.5) };
	return recipe;
    }

    private Recipe CopperPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidPasteCopperSediment.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemCopperMineral, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidDirtyWater.getItem(), 0, 200, 0.5) };
	return recipe;
    }

    private Recipe TaliaPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidPasteTaliaSediment.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTaliaDust, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidDirtyWater.getItem(), 0, 200, 0.5) };
	return recipe;
    }

    private Recipe ChromitePasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidPasteChromiteSediment.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemChromiteDust, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidDirtyWater.getItem(), 0, 200, 0.5) };
	return recipe;
    }

    private Recipe GoldPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidPasteGoldSediment.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemGoldDust, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidDirtyWater.getItem(), 0, 200, 0.5) };
	return recipe;
    }

    private Recipe GalenaPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.fluidPasteGalenaSediment.getItem(), 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemSilverDust, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, IndustrialProcessing.fluidDirtyWater.getItem(), 0, 200, 0.5) };
	return recipe;
    }

}

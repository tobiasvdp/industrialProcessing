package mod.industrialProcessing.plants.machine.dryer;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
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
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidGritSludge.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupBlocks.blockGrit, 1, 1, 0) };
		return recipe;
	}

	private Recipe residuToSand(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidResidu.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, Blocks.sand, 1, 1, 0) };
		return recipe;
	}

	private Recipe chromiteSludgeToCleanChunks(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidOreSludgeChromite.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemChromiteWashedChunks, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 100, IndustrialProcessing.fluidFiltyWater) };
		return recipe;
	}

	private Recipe taliaSludgeToCleanChunks(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidOreSludgeTalia.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemTaliaWashedChunks, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 100, IndustrialProcessing.fluidFiltyWater) };
		return recipe;
	}

	private Recipe galenaSludgeToCleanChunks(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidOreSludgeGalena.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemGalenaWashedChunks, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 100, IndustrialProcessing.fluidFiltyWater) };
		return recipe;
	}

	private Recipe goldSludgeToCleanChunks(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidOreSludgeGold.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemGoldWashedChunks, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 100, IndustrialProcessing.fluidFiltyWater) };
		return recipe;
	}

	private Recipe tinSludgeToCleanChunks(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidOreSludgeTin.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemTinWashedChunks, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 100, IndustrialProcessing.fluidFiltyWater) };
		return recipe;
	}

	private Recipe copperSludgeToCleanChunks(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidOreSludgeCopper.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemCopperWashedChunks, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 100, IndustrialProcessing.fluidFiltyWater) };
		return recipe;
	}

	private Recipe ironSludgeToCleanChunks(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidOreSludgeIron.getItem(), 120) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemIronWashedChunks, 1, 2, 0.2) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 100, IndustrialProcessing.fluidFiltyWater) };
		return recipe;
	}

	private Recipe ironPasteToDust(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidPasteIronSediment.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemIronOxideDust, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 100, IndustrialProcessing.fluidDirtyWater) };
		return recipe;
	}

	private Recipe TinPasteToDust(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidPasteTinSediment.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemTinOxideDust, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 200, IndustrialProcessing.fluidDirtyWater) };
		return recipe;
	}

	private Recipe CopperPasteToDust(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidPasteCopperSediment.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemCopperMineral, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 200, IndustrialProcessing.fluidDirtyWater) };
		return recipe;
	}

	private Recipe TaliaPasteToDust(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidPasteTaliaSediment.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemTaliaDust, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 200, IndustrialProcessing.fluidDirtyWater) };
		return recipe;
	}

	private Recipe ChromitePasteToDust(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidPasteChromiteSediment.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemChromiteDust, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 200, IndustrialProcessing.fluidDirtyWater) };
		return recipe;
	}

	private Recipe GoldPasteToDust(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidPasteGoldSediment.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemGoldDust, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 200, IndustrialProcessing.fluidDirtyWater) };
		return recipe;
	}

	private Recipe GalenaPasteToDust(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, IndustrialProcessing.fluidPasteGalenaSediment.getItem(), 1000) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemSilverSulfideDust, 1, 2, 0) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 0, 200, IndustrialProcessing.fluidDirtyWater) };
		return recipe;
	}

}

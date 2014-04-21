package ip.industrialProcessing.machines.dryer;

import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.FluidRegistry;

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
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidGritSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupBlocks.blockGrit.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	return recipe;
    }

    private Recipe residuToSand(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidResidu.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, Block.sand.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	return recipe;
    }

    private Recipe chromiteSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeChromite.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemChromiteWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe taliaSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeTalia.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTaliaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe galenaSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeGalena.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemGalenaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe goldSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeGold.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemGoldWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe tinSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeTin.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTinWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe copperSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeCopper.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemCopperWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
	return recipe;
    }

    private Recipe ironSludgeToCleanChunks(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeIron.getName()), RecipeSlotType.TANK, 100) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemIronWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.35), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 90, 110, 0.5) };
	return recipe;
    }

    private Recipe ironPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteIronSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 200, 0.5) };
	return recipe;
    }

    private Recipe TinPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteTinSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTinOxideDust.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 200, 0.5) };
	return recipe;
    }

    private Recipe CopperPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteCopperSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemCopperMineral.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 200, 0.5) };
	return recipe;
    }

    private Recipe TaliaPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteTaliaSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTaliaDust.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 200, 0.5) };
	return recipe;
    }

    private Recipe ChromitePasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteChromiteSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemChromiteDust.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 200, 0.5) };
	return recipe;
    }

    private Recipe GoldPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteGoldSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemGoldDust.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 200, 0.5) };
	return recipe;
    }

    private Recipe GalenaPasteToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteGalenaSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemSilverDust.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 200, 0.5) };
	return recipe;
    }

}

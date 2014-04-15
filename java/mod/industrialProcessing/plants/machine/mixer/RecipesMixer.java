package ip.industrialProcessing.machines.mixer;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesMixer extends RecipesMachine {

    public RecipesMixer() {
	addRecipe(ironSmallToSludge(2000, 1));
	addRecipe(copperSmallToSludge(2000, 1));
	addRecipe(tinSmallToSludge(2000, 1));
	addRecipe(goldSmallToSludge(2000, 1));
	addRecipe(galenaSmallToSludge(2000, 1));
	addRecipe(chromiteSmallToSludge(2000, 1));
	addRecipe(taliaSmallToSludge(2000, 1));
    }

    private Recipe taliaSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemTaliaSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeTalia.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe chromiteSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemChromiteSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeChromite.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe galenaSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemGalenaSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeGalena.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe goldSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemGoldSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeGold.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe tinSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemTinSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeTin.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe copperSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemCopperSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeCopper.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe ironSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 100), new RecipeInputSlot(0, ISetupItems.itemIronSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidOreSludgeIron.getName()), RecipeSlotType.TANK, 100, 120, 0.5) };
	return recipe;
    }
}

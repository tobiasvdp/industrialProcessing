package mod.industrialProcessing.plants.machine.mixer;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMachine;
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
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemTaliaSmallChunks, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidOreSludgeTalia.getItem(), 1000, 1000) };
	return recipe;
    }

    private Recipe chromiteSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemChromiteSmallChunks, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidOreSludgeChromite.getItem(), 1000, 1000) };
	return recipe;
    }

    private Recipe galenaSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemGalenaSmallChunks, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidOreSludgeGalena.getItem(), 1000, 1000) };
	return recipe;
    }

    private Recipe goldSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemGoldSmallChunks, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidOreSludgeGold.getItem(), 1000, 1000) };
	return recipe;
    }

    private Recipe tinSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemTinSmallChunks, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidOreSludgeTin.getItem(), 1000, 1000) };
	return recipe;
    }

    private Recipe copperSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER,1000), new RecipeInputSlot(0, ISetupItems.itemCopperSmallChunks, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidOreSludgeCopper.getItem(), 1000, 1000) };
	return recipe;
    }

    private Recipe ironSmallToSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 100), new RecipeInputSlot(0, ISetupItems.itemIronSmallChunks, RecipeSlotType.INVENTORY, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupFluids.fluidOreSludgeIron.getItem(), 100, 120) };
	return recipe;
    }
}

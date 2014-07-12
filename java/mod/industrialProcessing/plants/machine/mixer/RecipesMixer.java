package mod.industrialProcessing.plants.machine.mixer;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
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
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTaliaSmallChunks, 1) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidOreSludgeTalia) };
		return recipe;
	}

	private Recipe chromiteSmallToSludge(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemChromiteSmallChunks, 1) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidOreSludgeChromite) };
		return recipe;
	}

	private Recipe galenaSmallToSludge(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGalenaSmallChunks, 1) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidOreSludgeGalena) };
		return recipe;
	}

	private Recipe goldSmallToSludge(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGoldSmallChunks, 1) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidOreSludgeGold) };
		return recipe;
	}

	private Recipe tinSmallToSludge(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTinSmallChunks, 1) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidOreSludgeTin) };
		return recipe;
	}

	private Recipe copperSmallToSludge(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCopperSmallChunks, 1) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidOreSludgeCopper) };
		return recipe;
	}

	private Recipe ironSmallToSludge(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronSmallChunks, 1) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 120, 130, ISetupFluids.fluidOreSludgeIron) };
		return recipe;
	}
}

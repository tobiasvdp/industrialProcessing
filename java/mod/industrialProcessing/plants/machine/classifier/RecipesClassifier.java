package mod.industrialProcessing.plants.machine.classifier;

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

public class RecipesClassifier extends RecipesMachine {
	public RecipesClassifier() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(mixedFragmentsToSludgeIron(3000, 1));
		addRecipe(mixedFragmentsToSludgeTin(3000, 1));
		addRecipe(mixedFragmentsToSludgeCopper(3000, 1));
		addRecipe(mixedFragmentsToSludgeTalia(3000, 1));
		addRecipe(mixedFragmentsToSludgeGold(3000, 1));
		addRecipe(mixedFragmentsToSludgeGalena(3000, 1));
		addRecipe(mixedFragmentsToSludgeChromite(3000, 1));
	}

	private Recipe mixedFragmentsToSludgeIron(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronMixedFragments, 1) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCoalDust, 0, 1, 0.2) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidMixedSludgeIron) };
		return recipe;
	}

	private Recipe mixedFragmentsToSludgeTin(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTinMixedFragments, 1) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTinOxideDust, 0, 1, 0.2) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidMixedSludgeTin) };
		return recipe;
	}

	private Recipe mixedFragmentsToSludgeCopper(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCopperMixedFragments, 1) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGoldDust, 0, 1, 0.2) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidMixedSludgeCopper) };
		return recipe;
	}

	private Recipe mixedFragmentsToSludgeTalia(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTaliaMixedFragments, 1) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemSulfur, 0, 1, 0.2) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidMixedSludgeTalia) };
		return recipe;
	}

	private Recipe mixedFragmentsToSludgeGold(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGoldMixedFragments, 1) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemSilverDust, 0, 1, 0.2) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidMixedSludgeGold) };
		return recipe;
	}

	private Recipe mixedFragmentsToSludgeGalena(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGalenaMixedFragments, 1) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemSulfur, 0, 1, 0.2) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidMixedSludgeGalena) };
		return recipe;
	}

	private Recipe mixedFragmentsToSludgeChromite(int i, int powerConsumption) {
		PoweredRecipe recipe = new PoweredRecipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputFluids = new RecipeInputFluidSlot[] { new RecipeInputFluidSlot(0, FluidRegistry.WATER, 1000) };
		recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemChromiteMixedFragments, 1) };
		recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemIronOxideDust, 0, 1, 0.2) };
		recipe.outputFluids = new RecipeOutputFluidSlot[] { new RecipeOutputFluidSlot(1, 1000, 1000, ISetupFluids.fluidMixedSludgeChromite) };
		return recipe;
	}
}

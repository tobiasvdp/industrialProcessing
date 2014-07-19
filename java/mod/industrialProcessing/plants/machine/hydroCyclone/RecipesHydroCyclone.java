package mod.industrialProcessing.plants.machine.hydroCyclone;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.builder.RecipeBuilder;

public class RecipesHydroCyclone extends RecipesMachine {
	public RecipesHydroCyclone() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(filtyToDirty(3000, 1));
		addRecipe(MixedChromiteSludgeToCycloneSedement(3000, 1));
		addRecipe(MixedIronSludgeToCycloneSedement(3000, 1));
		addRecipe(MixedGoldSludgeToCycloneSedement(3000, 1));
		addRecipe(MixedTaliaSludgeToCycloneSedement(3000, 1));
		addRecipe(MixedTinSludgeToCycloneSedement(3000, 1));
		addRecipe(MixedCopperSludgeToCycloneSedement(3000, 1));
		addRecipe(MixedGalenaSludgeToCycloneSedement(3000, 1));
	}

	private IMachineRecipe filtyToDirty(int i, float powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidFiltyWater, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidDirtyWater, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidGritSludge, 100, 200);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe MixedIronSludgeToCycloneSedement(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeIron, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidCycloneIronSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 300);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe MixedGoldSludgeToCycloneSedement(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeGold, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidCycloneGoldSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 300);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe MixedTinSludgeToCycloneSedement(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeTin, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidCycloneTinSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 300);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe MixedCopperSludgeToCycloneSedement(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeCopper, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidCycloneCopperSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 300);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe MixedChromiteSludgeToCycloneSedement(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeChromite, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidCycloneChromiteSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 300);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe MixedTaliaSludgeToCycloneSedement(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeTalia, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidCycloneTaliaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 300);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe MixedGalenaSludgeToCycloneSedement(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeIron, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidCycloneIronSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 300);
		return builder.getMachineRecipe();
	}
}

package mod.industrialProcessing.plants.machine.thickener;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.builder.RecipeBuilder;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesThickener extends RecipesMachine {
	public RecipesThickener() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(mixedIronSludgeToThickSludge(3000, 1));
		addRecipe(mixedCopperSludgeToThickSludge(3000, 1));
		addRecipe(mixedTinSludgeToThickSludge(3000, 1));
		addRecipe(mixedGoldSludgeToThickSludge(3000, 1));
		addRecipe(mixedTaliaSludgeToThickSludge(3000, 1));
		addRecipe(mixedGalenaSludgeToThickSludge(3000, 1));
		addRecipe(mixedChromiteSludgeToThickSludge(3000, 1));

		addRecipe(ConcentratedSludgeToThickSedementChromite(3000, 1));
		addRecipe(ConcentratedSludgeToThickSedementIron(3000, 1));
		addRecipe(ConcentratedSludgeToThickSedementCopper(3000, 1));
		addRecipe(ConcentratedSludgeToThickSedementGold(3000, 1));
		addRecipe(ConcentratedSludgeToThickSedementTalia(3000, 1));
		addRecipe(ConcentratedSludgeToThickSedementGalena(3000, 1));
		addRecipe(ConcentratedSludgeToThickSedementTin(3000, 1));

		addRecipe(CycloneSedimentToLightSedimentChromite(3000, 1));
		addRecipe(CycloneSedimentToLightSedimentIron(3000, 1));
		addRecipe(CycloneSedimentToLightSedimentCopper(3000, 1));
		addRecipe(CycloneSedimentToLightSedimentGold(3000, 1));
		addRecipe(CycloneSedimentToLightSedimentTalia(3000, 1));
		addRecipe(CycloneSedimentToLightSedimentGalena(3000, 1));
		addRecipe(CycloneSedimentToLightSedimentTin(3000, 1));

		addRecipe(FlotationSedimentToPasteSedimentChromite(3000, 1));
		addRecipe(FlotationSedimentToPasteSedimentIron(3000, 1));
		addRecipe(FlotationSedimentToPasteSedimentCopper(3000, 1));
		addRecipe(FlotationSedimentToPasteSedimentGold(3000, 1));
		addRecipe(FlotationSedimentToPasteSedimentTalia(3000, 1));
		addRecipe(FlotationSedimentToPasteSedimentGalena(3000, 1));
		addRecipe(FlotationSedimentToPasteSedimentTin(3000, 1));
	}

	private IMachineRecipe mixedIronSludgeToThickSludge(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeIron, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickIronSludge, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe mixedTinSludgeToThickSludge(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeTin, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickTinSludge, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe mixedCopperSludgeToThickSludge(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeCopper, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickCopperSludge, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe mixedGoldSludgeToThickSludge(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeGold, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickGoldSludge, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe mixedTaliaSludgeToThickSludge(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeTalia, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickTaliaSludge, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe mixedChromiteSludgeToThickSludge(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeChromite, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickChromiteSludge, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe mixedGalenaSludgeToThickSludge(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidMixedSludgeGalena, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickGalenaSludge, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ConcentratedSludgeToThickSedementIron(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidConcentratedIronSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickIronSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ConcentratedSludgeToThickSedementTin(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidConcentratedTinSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickTinSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();

	}

	private IMachineRecipe ConcentratedSludgeToThickSedementCopper(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidConcentratedCopperSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickCopperSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ConcentratedSludgeToThickSedementGold(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidConcentratedGoldSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickGoldSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ConcentratedSludgeToThickSedementGalena(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidConcentratedGalenaSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickGalenaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ConcentratedSludgeToThickSedementChromite(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidConcentratedChromiteSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickChromiteSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ConcentratedSludgeToThickSedementTalia(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidConcentratedTaliaSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidThickTaliaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe CycloneSedimentToLightSedimentIron(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidCycloneIronSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidLightIronSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe CycloneSedimentToLightSedimentTin(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidCycloneTinSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidLightTinSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe CycloneSedimentToLightSedimentCopper(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidCycloneCopperSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidLightCopperSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe CycloneSedimentToLightSedimentGold(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidCycloneGoldSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidLightGoldSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe CycloneSedimentToLightSedimentGalena(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidCycloneGalenaSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidLightGalenaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe CycloneSedimentToLightSedimentChromite(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidCycloneChromiteSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidLightChromiteSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe CycloneSedimentToLightSedimentTalia(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidCycloneTaliaSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidLightTaliaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe FlotationSedimentToPasteSedimentIron(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidFlotationIronSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidPasteIronSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe FlotationSedimentToPasteSedimentTin(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidFlotationTinSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidPasteTinSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe FlotationSedimentToPasteSedimentCopper(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidFlotationCopperSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidPasteCopperSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe FlotationSedimentToPasteSedimentGold(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidFlotationGoldSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidPasteGoldSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe FlotationSedimentToPasteSedimentGalena(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidFlotationGalenaSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidPasteGalenaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe FlotationSedimentToPasteSedimentChromite(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidFlotationChromiteSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidPasteChromiteSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe FlotationSedimentToPasteSedimentTalia(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidFlotationTaliaSediment, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidPasteTaliaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 500);
		return builder.getMachineRecipe();
	}

}

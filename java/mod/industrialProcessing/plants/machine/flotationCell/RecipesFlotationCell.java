package mod.industrialProcessing.plants.machine.flotationCell;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.builder.RecipeBuilder;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesFlotationCell extends RecipesMachine {
	public RecipesFlotationCell() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(dirtyToUnclean(300, 0));
		addRecipe(ThickSludgeToFlotationSedimentIron(300, 0));
		addRecipe(ThickSludgeToFlotationSedimentTin(300, 0));
		addRecipe(ThickSludgeToFlotationSedimentCopper(300, 0));
		addRecipe(ThickSludgeToFlotationSedimentGold(300, 0));
		addRecipe(ThickSludgeToFlotationSedimentTalia(300, 0));
		addRecipe(ThickSludgeToFlotationSedimentGalena(300, 0));
		addRecipe(ThickSludgeToFlotationSedimentChromite(300, 0));
	}

	private IMachineRecipe dirtyToUnclean(int i, int power) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(power);
		builder.withFluidInput(0, ISetupFluids.fluidDirtyWater, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidUncleanWater, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidResidu, 100, 200);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ThickSludgeToFlotationSedimentIron(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickIronSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidFlotationIronSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidConcentratedIronSludge, 1000);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ThickSludgeToFlotationSedimentTin(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickTinSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidFlotationTinSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidConcentratedTinSludge, 1000);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ThickSludgeToFlotationSedimentCopper(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickCopperSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidFlotationCopperSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidConcentratedCopperSludge, 1000);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ThickSludgeToFlotationSedimentGold(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickGoldSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidFlotationGoldSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidConcentratedGoldSludge, 1000);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ThickSludgeToFlotationSedimentGalena(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickGalenaSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidFlotationGalenaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidConcentratedGalenaSludge, 1000);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ThickSludgeToFlotationSedimentChromite(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickChromiteSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidFlotationChromiteSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidConcentratedChromiteSludge, 1000);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ThickSludgeToFlotationSedimentTalia(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickTaliaSludge, 1000);
		builder.withFluidOutput(1, ISetupFluids.fluidFlotationTaliaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidConcentratedTaliaSludge, 1000);
		return builder.getMachineRecipe();
	}

}

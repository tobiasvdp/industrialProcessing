package mod.industrialProcessing.plants.machine.diskFilter;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.builder.RecipeBuilder;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesDiskFilter extends RecipesMachine {

	public RecipesDiskFilter() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(IronSedimentToDust(3000, 1));
		addRecipe(TinSedimentToDust(3000, 1));
		addRecipe(CopperSedimentToDust(3000, 1));
		addRecipe(GoldSedimentToDust(3000, 1));
		addRecipe(TaliaSedimentToDust(3000, 1));
		addRecipe(GalenaSedimentToDust(3000, 1));
		addRecipe(ChromiteSedimentToDust(3000, 1));
	}

	private IMachineRecipe IronSedimentToDust(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickIronSediment, 1000);
		builder.withFluidInput(1, ISetupFluids.fluidLightIronSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 200);
		builder.withInventoryOutput(0, ISetupItems.itemIronOxideDust, 1);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe GoldSedimentToDust(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickGoldSediment, 1000);
		builder.withFluidInput(1, ISetupFluids.fluidLightGoldSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 200);
		builder.withInventoryOutput(0, ISetupItems.itemGoldDust, 1);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe TinSedimentToDust(int i, int powerConsumption) {

		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickTinSediment, 1000);
		builder.withFluidInput(1, ISetupFluids.fluidLightTinSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 200);
		builder.withInventoryOutput(0, ISetupItems.itemTinOxideDust, 1);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe CopperSedimentToDust(int i, int powerConsumption) {
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickCopperSediment, 1000);
		builder.withFluidInput(1, ISetupFluids.fluidLightCopperSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 200);
		builder.withInventoryOutput(0, ISetupItems.itemCopperMineral, 1);
		return builder.getMachineRecipe();
	}

	private IMachineRecipe ChromiteSedimentToDust(int i, int powerConsumption) {
 
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickChromiteSediment, 1000);
		builder.withFluidInput(1, ISetupFluids.fluidLightChromiteSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 200);
		builder.withInventoryOutput(0, ISetupItems.itemChromiteDust, 1);
		return builder.getMachineRecipe(); 
	}

	private IMachineRecipe GalenaSedimentToDust(int i, int powerConsumption) { 
		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickGalenaSediment, 1000);
		builder.withFluidInput(1, ISetupFluids.fluidLightGalenaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 200);
		builder.withInventoryOutput(0, ISetupItems.itemLeadSulfideDust, 1);
		return builder.getMachineRecipe(); 
	}

	private IMachineRecipe TaliaSedimentToDust(int i, int powerConsumption) {


		RecipeBuilder builder = new RecipeBuilder();
		builder.withWork(i);
		builder.withPower(powerConsumption);
		builder.withFluidInput(0, ISetupFluids.fluidThickTaliaSediment, 1000);
		builder.withFluidInput(1, ISetupFluids.fluidLightTaliaSediment, 1000);
		builder.withFluidOutput(2, ISetupFluids.fluidDirtyWater, 200);
		builder.withInventoryOutput(0, ISetupItems.itemTaliaDust, 1);
		return builder.getMachineRecipe(); 
	}
}

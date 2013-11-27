package ip.industrialProcessing.machines.thickener;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

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

	private Recipe mixedIronSludgeToThickSludge(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeIron.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickIronSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe mixedTinSludgeToThickSludge(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeTin.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickTinSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe mixedCopperSludgeToThickSludge(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeCopper.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickCopperSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe mixedGoldSludgeToThickSludge(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeGold.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickGoldSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe mixedTaliaSludgeToThickSludge(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeTalia.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickTaliaSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe mixedChromiteSludgeToThickSludge(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeChromite.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickChromiteSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe mixedGalenaSludgeToThickSludge(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeGalena.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickGalenaSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ConcentratedSludgeToThickSedementIron(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedIronSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ConcentratedSludgeToThickSedementTin(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedTinSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ConcentratedSludgeToThickSedementCopper(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedCopperSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ConcentratedSludgeToThickSedementGold(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedGoldSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ConcentratedSludgeToThickSedementGalena(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedGalenaSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ConcentratedSludgeToThickSedementChromite(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedChromiteSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ConcentratedSludgeToThickSedementTalia(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedTaliaSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe CycloneSedimentToLightSedimentIron(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneIronSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidLightIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe CycloneSedimentToLightSedimentTin(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneTinSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidLightTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe CycloneSedimentToLightSedimentCopper(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneCopperSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidLightCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe CycloneSedimentToLightSedimentGold(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneGoldSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidLightGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe CycloneSedimentToLightSedimentGalena(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneGalenaSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidLightGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe CycloneSedimentToLightSedimentChromite(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneChromiteSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidLightChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe CycloneSedimentToLightSedimentTalia(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneTaliaSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidLightTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe FlotationSedimentToPasteSedimentIron(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationIronSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPasteIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe FlotationSedimentToPasteSedimentTin(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationTinSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPasteTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe FlotationSedimentToPasteSedimentCopper(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationCopperSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPasteCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe FlotationSedimentToPasteSedimentGold(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationGoldSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPasteGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe FlotationSedimentToPasteSedimentGalena(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationGalenaSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPasteGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe FlotationSedimentToPasteSedimentChromite(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationChromiteSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPasteChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe FlotationSedimentToPasteSedimentTalia(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationTaliaSediment.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPasteTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

}

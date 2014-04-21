package ip.industrialProcessing.machines.thickener;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
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

    private Recipe mixedIronSludgeToThickSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeIron.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickIronSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe mixedTinSludgeToThickSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeTin.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTinSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe mixedCopperSludgeToThickSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeCopper.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickCopperSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe mixedGoldSludgeToThickSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeGold.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGoldSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe mixedTaliaSludgeToThickSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeTalia.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTaliaSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe mixedChromiteSludgeToThickSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeChromite.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickChromiteSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe mixedGalenaSludgeToThickSludge(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeGalena.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGalenaSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe ConcentratedSludgeToThickSedementIron(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedIronSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe ConcentratedSludgeToThickSedementTin(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedTinSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe ConcentratedSludgeToThickSedementCopper(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedCopperSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe ConcentratedSludgeToThickSedementGold(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedGoldSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe ConcentratedSludgeToThickSedementGalena(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedGalenaSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe ConcentratedSludgeToThickSedementChromite(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedChromiteSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe ConcentratedSludgeToThickSedementTalia(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedTaliaSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe CycloneSedimentToLightSedimentIron(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneIronSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe CycloneSedimentToLightSedimentTin(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneTinSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe CycloneSedimentToLightSedimentCopper(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneCopperSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe CycloneSedimentToLightSedimentGold(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneGoldSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe CycloneSedimentToLightSedimentGalena(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneGalenaSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe CycloneSedimentToLightSedimentChromite(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneChromiteSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe CycloneSedimentToLightSedimentTalia(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneTaliaSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe FlotationSedimentToPasteSedimentIron(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationIronSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe FlotationSedimentToPasteSedimentTin(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationTinSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe FlotationSedimentToPasteSedimentCopper(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationCopperSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe FlotationSedimentToPasteSedimentGold(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationGoldSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe FlotationSedimentToPasteSedimentGalena(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationGalenaSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe FlotationSedimentToPasteSedimentChromite(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationChromiteSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

    private Recipe FlotationSedimentToPasteSedimentTalia(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationTaliaSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidPasteTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 500, 500, 0.5) };
	return recipe;
    }

}

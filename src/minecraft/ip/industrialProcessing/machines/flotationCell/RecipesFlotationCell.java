package ip.industrialProcessing.machines.flotationCell;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

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

    private Recipe dirtyToUnclean(int i, int power) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = power;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidUncleanWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidResidu.getName()), RecipeSlotType.TANK, 100, 200, 0.5) };
	return recipe;
    }

    private Recipe ThickSludgeToFlotationSedimentIron(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickIronSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedIronSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe ThickSludgeToFlotationSedimentTin(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTinSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedTinSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe ThickSludgeToFlotationSedimentCopper(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickCopperSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedCopperSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe ThickSludgeToFlotationSedimentGold(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGoldSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedGoldSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe ThickSludgeToFlotationSedimentGalena(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGalenaSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedGalenaSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe ThickSludgeToFlotationSedimentChromite(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickChromiteSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedChromiteSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe ThickSludgeToFlotationSedimentTalia(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTaliaSludge.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidFlotationTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidConcentratedTaliaSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

}

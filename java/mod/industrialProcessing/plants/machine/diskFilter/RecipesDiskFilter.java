package mod.industrialProcessing.plants.machine.diskFilter;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMachine;
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

    private Recipe IronSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickIronSediment.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightIronSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemIronOxideDust, RecipeSlotType.INVENTORY, 1, 1, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 200, 0.5) };
	return recipe;
    }

    private Recipe GoldSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGoldSediment.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightGoldSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemGoldDust, RecipeSlotType.INVENTORY, 1, 1, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 200, 0.5) };
	return recipe;
    }

    private Recipe TinSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTinSediment.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightTinSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTinOxideDust, RecipeSlotType.INVENTORY, 1, 1, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 200, 0.5) };
	return recipe;
    }

    private Recipe CopperSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickCopperSediment.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightCopperSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemCopperMineral, RecipeSlotType.INVENTORY, 1, 1, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 200, 0.5) };
	return recipe;
    }

    private Recipe ChromiteSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickChromiteSediment.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightChromiteSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemChromiteDust, RecipeSlotType.INVENTORY, 1, 1, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 200, 0.5) };
	return recipe;
    }

    private Recipe GalenaSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGalenaSediment.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightGalenaSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemLeadDust, RecipeSlotType.INVENTORY, 1, 1, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 200, 0.5) };
	return recipe;
    }

    private Recipe TaliaSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTaliaSediment.getName()), RecipeSlotType.TANK, 1000), new RecipeInputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightTaliaSediment.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, ISetupItems.itemTaliaDust, RecipeSlotType.INVENTORY, 1, 1, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 200, 0.5) };
	return recipe;
    }
}

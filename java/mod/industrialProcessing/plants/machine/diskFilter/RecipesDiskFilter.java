package mod.industrialProcessing.plants.machine.diskFilter;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
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

    private Recipe IronSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickIronSediment.getName()), 1000), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightIronSediment.getName()), 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemIronOxideDust, 1, 1, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 0.5) };
	return recipe;
    }

    private Recipe GoldSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGoldSediment.getName()), 1000), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightGoldSediment.getName()), 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemGoldDust, 1, 1, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 0.5) };
	return recipe;
    }

    private Recipe TinSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTinSediment.getName()), 1000), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightTinSediment.getName()), 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemTinOxideDust, 1, 1, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 0.5) };
	return recipe;
    }

    private Recipe CopperSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickCopperSediment.getName()), 1000), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightCopperSediment.getName()), 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemCopperMineral, 1, 1, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 0.5) };
	return recipe;
    }

    private Recipe ChromiteSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickChromiteSediment.getName()), 1000), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightChromiteSediment.getName()), 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemChromiteDust, 1, 1, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 0.5) };
	return recipe;
    }

    private Recipe GalenaSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickGalenaSediment.getName()), 1000), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightGalenaSediment.getName()), 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemLeadDust, 1, 1, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 0.5) };
	return recipe;
    }

    private Recipe TaliaSedimentToDust(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidThickTaliaSediment.getName()), 1000), new RecipeInputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidLightTaliaSediment.getName()), 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(0, ISetupItems.itemTaliaDust, 1, 1, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 200, 0.5) };
	return recipe;
    }
}

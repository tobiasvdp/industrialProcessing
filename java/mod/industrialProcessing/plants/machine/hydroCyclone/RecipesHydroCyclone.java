package ip.industrialProcessing.machines.hydroCyclone;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesHydroCyclone extends RecipesMachine {
    public RecipesHydroCyclone() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(filtyToDirty(3000));
	addRecipe(MixedChromiteSludgeToCycloneSedement(3000, 1));
	addRecipe(MixedIronSludgeToCycloneSedement(3000, 1));
	addRecipe(MixedGoldSludgeToCycloneSedement(3000, 1));
	addRecipe(MixedTaliaSludgeToCycloneSedement(3000, 1));
	addRecipe(MixedTinSludgeToCycloneSedement(3000, 1));
	addRecipe(MixedCopperSludgeToCycloneSedement(3000, 1));
	addRecipe(MixedGalenaSludgeToCycloneSedement(3000, 1));
    }

    private Recipe filtyToDirty(int i) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidGritSludge.getName()), RecipeSlotType.TANK, 100, 200, 0.5) };
	return recipe;
    }

    private Recipe MixedIronSludgeToCycloneSedement(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeIron.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 300, 300, 0.5) };
	return recipe;
    }

    private Recipe MixedGoldSludgeToCycloneSedement(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeGold.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 300, 300, 0.5) };
	return recipe;
    }

    private Recipe MixedTinSludgeToCycloneSedement(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeTin.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 300, 300, 0.5) };
	return recipe;
    }

    private Recipe MixedCopperSludgeToCycloneSedement(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeCopper.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 300, 300, 0.5) };
	return recipe;
    }

    private Recipe MixedChromiteSludgeToCycloneSedement(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeChromite.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 300, 300, 0.5) };
	return recipe;
    }

    private Recipe MixedTaliaSludgeToCycloneSedement(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeTalia.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 300, 300, 0.5) };
	return recipe;
    }

    private Recipe MixedGalenaSludgeToCycloneSedement(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeGalena.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidCycloneGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputInventorySlot(2, FluidRegistry.getFluidID(ISetupFluids.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 300, 300, 0.5) };
	return recipe;
    }
}

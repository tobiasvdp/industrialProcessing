package ip.industrialProcessing.machines.hydroCyclone;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

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
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidGritSludge.getName()), RecipeSlotType.TANK, 100, 200, 0.5) };
	return recipe;
    }

    private Recipe MixedIronSludgeToCycloneSedement(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeIron.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe MixedGoldSludgeToCycloneSedement(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeGold.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe MixedTinSludgeToCycloneSedement(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeTin.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe MixedCopperSludgeToCycloneSedement(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeCopper.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe MixedChromiteSludgeToCycloneSedement(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeChromite.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe MixedTaliaSludgeToCycloneSedement(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeTalia.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }

    private Recipe MixedGalenaSludgeToCycloneSedement(int i, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.workRequired = i;
	recipe.powerRequired = powerConsumption;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeGalena.getName()), RecipeSlotType.TANK, 1000) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidCycloneGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
	return recipe;
    }
}

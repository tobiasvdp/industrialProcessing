package ip.industrialProcessing.machines.classifier;

import mod.industrialProcessing.fluids.ISetupFluids;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesClassifier extends RecipesMachine {
    public RecipesClassifier() {
    	addDefaultRecipes();
    }

	private void addDefaultRecipes() {
		addRecipe(mixedFragmentsToSludgeIron(3000,1));
		addRecipe(mixedFragmentsToSludgeTin(3000,1));
		addRecipe(mixedFragmentsToSludgeCopper(3000,1));
		addRecipe(mixedFragmentsToSludgeTalia(3000,1));
		addRecipe(mixedFragmentsToSludgeGold(3000,1));
		addRecipe(mixedFragmentsToSludgeGalena(3000,1));
		addRecipe(mixedFragmentsToSludgeChromite(3000,1));
	}
	
    private Recipe mixedFragmentsToSludgeIron(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemIronMixedFragments, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.fluidMixedSludgeIron.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemCoalDust, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeTin(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemTinMixedFragments, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.fluidMixedSludgeTin.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemTinOxideDust, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeCopper(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemCopperMixedFragments, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.fluidMixedSludgeCopper.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemGoldDust, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeTalia(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemTaliaMixedFragments, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.fluidMixedSludgeTalia.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemSulfur, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeGold(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemGoldMixedFragments, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.fluidMixedSludgeGold.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemSilverDust, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeGalena(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemGalenaMixedFragments, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.fluidMixedSludgeGalena.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemSulfur, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeChromite(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER, 1000), new RecipeInputSlot(0, ISetupItems.itemChromiteMixedFragments, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.fluidMixedSludgeChromite.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) ,new RecipeOutputSlot(1, ISetupItems.itemIronOxideDust, RecipeSlotType.INVENTORY, 0, 1, 0.2)};
        return recipe;
    }
}

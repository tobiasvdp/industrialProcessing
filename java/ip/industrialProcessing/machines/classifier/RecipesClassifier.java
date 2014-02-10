package ip.industrialProcessing.machines.classifier;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
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
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemIronMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeIron.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemCoalDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeTin(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemTinMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeTin.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemTinOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeCopper(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemCopperMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeCopper.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemGoldDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeTalia(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemTaliaMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeTalia.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemSulfur.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeGold(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemGoldMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeGold.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemSilverDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeGalena(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemGalenaMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeGalena.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, ISetupItems.itemSulfur.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeChromite(int i, int powerConsumption) {
	PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, ISetupItems.itemChromiteMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(ISetupFluids.itemFluidMixedSludgeChromite.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) ,new RecipeOutputSlot(1, ISetupItems.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2)};
        return recipe;
    }
}

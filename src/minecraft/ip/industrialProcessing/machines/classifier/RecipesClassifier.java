package ip.industrialProcessing.machines.classifier;

import cpw.mods.fml.common.registry.GameRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
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
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemIronMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeIron.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, IndustrialProcessing.itemCoalDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeTin(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemTinMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeTin.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, IndustrialProcessing.itemTinOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeCopper(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemCopperMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeCopper.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, IndustrialProcessing.itemGoldDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeTalia(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemTaliaMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeTalia.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, IndustrialProcessing.itemSulfur.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeGold(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemGoldMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeGold.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, IndustrialProcessing.itemSilverDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeGalena(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemGalenaMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeGalena.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(1, IndustrialProcessing.itemSulfur.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2) };
        return recipe;
    }
    
    private Recipe mixedFragmentsToSludgeChromite(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemChromiteMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidMixedSludgeChromite.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) ,new RecipeOutputSlot(1, IndustrialProcessing.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.2)};
        return recipe;
    }
}

package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesFilter extends RecipesMachine {
    public RecipesFilter() {

        addRecipe(copperCrushedToLarge(3000, 1));
        addRecipe(tinCrushedToLarge(3000, 1));
        addRecipe(ironCrushedToLarge(3000, 1));
        addRecipe(goldCrushedToLarge(3000, 1));
        addRecipe(galenaCrushedToLarge(3000, 1));
        addRecipe(chromiteCrushedToLarge(3000, 1));
        addRecipe(taliaCrushedToLarge(3000, 1));

        addRecipe(copperFineToDust(3000, 1));
        addRecipe(tinFineToDust(3000, 1));
        addRecipe(ironFineToDust(2000, 1));
        addRecipe(goldFineToDust(3000, 1));
        addRecipe(galenaFineToDust(3000, 1));
        addRecipe(chromiteFineToDust(3000, 1));
        addRecipe(taliaFineToDust(3000, 1));
    }

    private Recipe taliaFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTaliaFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemTaliaMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe chromiteFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemChromiteFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemChromiteMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe galenaFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGalenaFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemLeadDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemGalenaMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe goldFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGoldFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemGoldMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe ironFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 2, 0.5), new RecipeOutputSlot(2, ISetupItems.itemIronMixedFragments.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.6) };
        return recipe;
    }

    private Recipe tinFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTinFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemTinMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe copperFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperMineral.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemCopperMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe taliaCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTaliaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemTaliaSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe chromiteCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemChromiteCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemChromiteSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe galenaCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGalenaLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemGalenaSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe goldCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemGoldSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe ironCrushedToLarge(int i, int powerConsumption) {
        // crushed iron to large and small ore chunks
	PoweredRecipe iron = new PoweredRecipe();
        iron.workRequired = i;
        iron.powerRequired = powerConsumption;
        iron.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 2) };
        iron.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0.35), new RecipeOutputSlot(2, ISetupItems.itemIronSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0.45) };
        return iron;
    }

    private Recipe tinCrushedToLarge(int i, int powerConsumption) {
        // crushed tin to large and small ore chunks
	PoweredRecipe tin = new PoweredRecipe();
        tin.workRequired = i;
        tin.powerRequired = powerConsumption;
        tin.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        tin.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemTinSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return tin;
    }

    private Recipe copperCrushedToLarge(int i, int powerConsumption) {
        // crushed copper to large and small ore chunks
	PoweredRecipe copper = new PoweredRecipe();
        copper.workRequired = i;
        copper.powerRequired = powerConsumption;
        copper.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        copper.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemCopperSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return copper;
    }

}

package mod.industrialProcessing.plants.machine.filter;

import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipeSlotType;
import mod.industrialProcessing.work.recipe.RecipesMachine;

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
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTaliaFineChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaDust, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemTaliaMixedFragments, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe chromiteFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemChromiteFineChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteDust, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemChromiteMixedFragments, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe galenaFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGalenaFineChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemLeadDust, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemGalenaMixedFragments, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe goldFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGoldFineChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldDust, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemGoldMixedFragments, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe ironFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronFineChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronOxideDust, RecipeSlotType.INVENTORY, 0, 2, 0.5), new RecipeOutputSlot(2, ISetupItems.itemIronMixedFragments, RecipeSlotType.INVENTORY, 0, 1, 0.6) };
        return recipe;
    }

    private Recipe tinFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTinFineChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinOxideDust, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemTinMixedFragments, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe copperFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperFineChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperMineral, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemCopperMixedFragments, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe taliaCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTaliaCrushedChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTaliaLargeChunks, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemTaliaSmallChunks, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe chromiteCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemChromiteCrushedChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemChromiteLargeChunks, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemChromiteSmallChunks, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe galenaCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGalenaCrushedChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGalenaLargeChunks, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemGalenaSmallChunks, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe goldCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemGoldCrushedChunks, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemGoldLargeChunks, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemGoldSmallChunks, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe ironCrushedToLarge(int i, int powerConsumption) {
        // crushed iron to large and small ore chunks
	PoweredRecipe iron = new PoweredRecipe();
        iron.workRequired = i;
        iron.powerRequired = powerConsumption;
        iron.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemIronCrushedChunks, RecipeSlotType.INVENTORY, 2) };
        iron.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemIronLargeChunks, RecipeSlotType.INVENTORY, 0, 1, 0.35), new RecipeOutputSlot(2, ISetupItems.itemIronSmallChunks, RecipeSlotType.INVENTORY, 1, 3, 0.45) };
        return iron;
    }

    private Recipe tinCrushedToLarge(int i, int powerConsumption) {
        // crushed tin to large and small ore chunks
	PoweredRecipe tin = new PoweredRecipe();
        tin.workRequired = i;
        tin.powerRequired = powerConsumption;
        tin.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemTinCrushedChunks, RecipeSlotType.INVENTORY, 1) };
        tin.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemTinLargeChunks, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemTinSmallChunks, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return tin;
    }

    private Recipe copperCrushedToLarge(int i, int powerConsumption) {
        // crushed copper to large and small ore chunks
	PoweredRecipe copper = new PoweredRecipe();
        copper.workRequired = i;
        copper.powerRequired = powerConsumption;
        copper.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, ISetupItems.itemCopperCrushedChunks, RecipeSlotType.INVENTORY, 1) };
        copper.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, ISetupItems.itemCopperLargeChunks, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, ISetupItems.itemCopperSmallChunks, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return copper;
    }

}

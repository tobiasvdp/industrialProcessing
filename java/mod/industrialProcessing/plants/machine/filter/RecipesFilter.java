package mod.industrialProcessing.plants.machine.filter;

import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;

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
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTaliaFineChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTaliaDust, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemTaliaMixedFragments, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe chromiteFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemChromiteFineChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemChromiteDust, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemChromiteMixedFragments, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe galenaFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGalenaFineChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemLeadDust, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemGalenaMixedFragments, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe goldFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGoldFineChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGoldDust, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemGoldMixedFragments, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe ironFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronFineChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemIronOxideDust, 0, 2, 0.5), new RecipeOutputInventorySlot(2, ISetupItems.itemIronMixedFragments, 0, 1, 0.6) };
        return recipe;
    }

    private Recipe tinFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTinFineChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTinOxideDust, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemTinMixedFragments, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe copperFineToDust(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCopperFineChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCopperMineral, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemCopperMixedFragments, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe taliaCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTaliaCrushedChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTaliaLargeChunks, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemTaliaSmallChunks, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe chromiteCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemChromiteCrushedChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemChromiteLargeChunks, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemChromiteSmallChunks, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe galenaCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGalenaCrushedChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGalenaLargeChunks, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemGalenaSmallChunks, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe goldCrushedToLarge(int i, int powerConsumption) {
        PoweredRecipe recipe = new PoweredRecipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemGoldCrushedChunks, 1) };
        recipe.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemGoldLargeChunks, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemGoldSmallChunks, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe ironCrushedToLarge(int i, int powerConsumption) {
        // crushed iron to large and small ore chunks
	PoweredRecipe iron = new PoweredRecipe();
        iron.workRequired = i;
        iron.powerRequired = powerConsumption;
        iron.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemIronCrushedChunks, 2) };
        iron.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemIronLargeChunks, 0, 1, 0.35), new RecipeOutputInventorySlot(2, ISetupItems.itemIronSmallChunks, 1, 3, 0.45) };
        return iron;
    }

    private Recipe tinCrushedToLarge(int i, int powerConsumption) {
        // crushed tin to large and small ore chunks
	PoweredRecipe tin = new PoweredRecipe();
        tin.workRequired = i;
        tin.powerRequired = powerConsumption;
        tin.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemTinCrushedChunks, 1) };
        tin.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemTinLargeChunks, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemTinSmallChunks, 1, 2, 0.75) };
        return tin;
    }

    private Recipe copperCrushedToLarge(int i, int powerConsumption) {
        // crushed copper to large and small ore chunks
	PoweredRecipe copper = new PoweredRecipe();
        copper.workRequired = i;
        copper.powerRequired = powerConsumption;
        copper.inputs = new RecipeInputInventorySlot[] { new RecipeInputInventorySlot(0, ISetupItems.itemCopperCrushedChunks, 1) };
        copper.outputs = new RecipeOutputInventorySlot[] { new RecipeOutputInventorySlot(1, ISetupItems.itemCopperLargeChunks, 0, 1, 0), new RecipeOutputInventorySlot(2, ISetupItems.itemCopperSmallChunks, 1, 2, 0.75) };
        return copper;
    }

}

package ip.industrialProcessing.machines.filter;

import java.util.Iterator;

import net.minecraft.block.Block;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlot;
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
        addRecipe(ironFineToDust(3000, 1));
        addRecipe(goldFineToDust(3000, 1));
        addRecipe(galenaFineToDust(3000, 1));
        addRecipe(chromiteFineToDust(3000, 1));
        addRecipe(taliaFineToDust(3000, 1));
    }

    private Recipe taliaFineToDust(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTaliaFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTaliaDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0) };
        return recipe;
    }

    private Recipe chromiteFineToDust(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemChromiteFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemChromiteDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0) };
        return recipe;
    }

    private Recipe galenaFineToDust(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGalenaFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemLeadDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0) };
        return recipe;
    }

    private Recipe goldFineToDust(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGoldFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0) };
        return recipe;
    }

    private Recipe ironFineToDust(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemIronMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe tinFineToDust(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemTinMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe copperFineToDust(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperMineral.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemCopperMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe taliaCrushedToLarge(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTaliaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTaliaLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemTaliaSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe chromiteCrushedToLarge(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemChromiteCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemChromiteLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemChromiteSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe galenaCrushedToLarge(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGalenaCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGalenaLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemGalenaSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe goldCrushedToLarge(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemGoldCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemGoldLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemGoldSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return recipe;
    }

    private Recipe ironCrushedToLarge(int i, int powerConsumption) {
        // crushed iron to large and small ore chunks
        Recipe iron = new Recipe();
        iron.workRequired = i;
        iron.powerRequired = powerConsumption;
        iron.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        iron.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemIronSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return iron;
    }

    private Recipe tinCrushedToLarge(int i, int powerConsumption) {
        // crushed tin to large and small ore chunks
        Recipe tin = new Recipe();
        tin.workRequired = i;
        tin.powerRequired = powerConsumption;
        tin.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        tin.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemTinSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return tin;
    }

    private Recipe copperCrushedToLarge(int i, int powerConsumption) {
        // crushed copper to large and small ore chunks
        Recipe copper = new Recipe();
        copper.workRequired = i;
        copper.powerRequired = powerConsumption;
        copper.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
        copper.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemCopperSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
        return copper;
    }

}

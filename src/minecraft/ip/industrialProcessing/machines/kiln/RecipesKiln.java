package ip.industrialProcessing.machines.kiln;

import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesKiln extends RecipesMachine {
    public RecipesKiln() {
        addDefaultRecipes();
    }

    private void addDefaultRecipes() {
    	addRecipe(coalToCoke(3000,1));
    }
    
    private Recipe coalToCoke(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Item.coal.itemID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCokes.itemID, RecipeSlotType.INVENTORY, 1, 2, 0) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }
}

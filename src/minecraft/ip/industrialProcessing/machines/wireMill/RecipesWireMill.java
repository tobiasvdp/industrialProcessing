package ip.industrialProcessing.machines.wireMill;

import net.minecraft.item.Item;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesWireMill extends RecipesMachine {
    public RecipesWireMill(){
	addRecipe(copperToWire(3000,0));
    }

    private Recipe copperToWire(int workTime, int powerConsumption) {
	Recipe recipe = new Recipe();
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperIngot.itemID, RecipeSlotType.INVENTORY, 3) };

	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperWire.itemID, RecipeSlotType.INVENTORY, 12, 16, 0) };
	recipe.workRequired = workTime;
	recipe.powerRequired = powerConsumption;
	return recipe;
    }
}
package ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesBloomery extends RecipesMachine {
	public RecipesBloomery() {
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(iron(750,0));
	}
	
    private Recipe iron(int workTime, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1) };

        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1, 1, 0.25) };
        recipe.workRequired = workTime;
        recipe.powerRequired = powerConsumption;
        return recipe;
    }

}

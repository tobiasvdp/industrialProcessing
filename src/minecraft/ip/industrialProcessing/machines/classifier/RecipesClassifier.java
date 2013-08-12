package ip.industrialProcessing.machines.classifier;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesClassifier extends RecipesMachine {
	public RecipesClassifier() {
		Recipe copper = new Recipe();
		copper.workRequired = 30;
		copper.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperMixedFragments.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(0, IndustrialProcessing.itemCopperMixedFragments.itemID, RecipeSlotType.INVENTORY, 1) };
		copper.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemCopperSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
		addRecipe(copper);
	}
}

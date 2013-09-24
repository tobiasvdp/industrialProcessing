package ip.industrialProcessing.machines.classifier;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesClassifier extends RecipesMachine {
	public RecipesClassifier() {
		Recipe copper = new Recipe();
		copper.workRequired = 3000;
		copper.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperMixedFragments.itemID, RecipeSlotType.INVENTORY, 1), new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000) };
		copper.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.LAVA.getID(), RecipeSlotType.TANK, 1000, 1000, 0), new RecipeOutputSlot(1, Block.sand.blockID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
		addRecipe(copper);
	}
}

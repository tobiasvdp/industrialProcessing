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
		// crushed copper to large and small ore chunks
		Recipe copper = new Recipe();
		copper.workRequired = 3000;
		copper.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		copper.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemCopperSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
		addRecipe(copper);

		// crushed tin to large and small ore chunks
		Recipe tin = new Recipe();
		tin.workRequired = 3000;
		tin.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		tin.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemTinSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
		addRecipe(tin);
		// crushed iron to large and small ore chunks
		Recipe iron = new Recipe();
		iron.workRequired = 3000;
		iron.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		iron.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronLargeChunks.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemIronSmallChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
		addRecipe(iron);

		// Fine copper to dust and mixed fragments chunks
		Recipe copper2 = new Recipe();
		copper2.workRequired = 3000;
		copper2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemCopperFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		copper2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemCopperMineral.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemCopperMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
		addRecipe(copper2);

		// Fine tin to dust and mixed fragments chunks
		Recipe tin2 = new Recipe();
		tin2.workRequired = 3000;
		tin2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemTinFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		tin2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemTinOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemTinMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
		addRecipe(tin2);
		// Fine iron to dust and mixed fragments chunks
		Recipe iron2 = new Recipe();
		iron2.workRequired = 3000;
		iron2.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, IndustrialProcessing.itemIronFineChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		iron2.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, IndustrialProcessing.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0), new RecipeOutputSlot(2, IndustrialProcessing.itemIronMixedFragments.itemID, RecipeSlotType.INVENTORY, 1, 2, 0.75) };
		addRecipe(iron2);
	}

}

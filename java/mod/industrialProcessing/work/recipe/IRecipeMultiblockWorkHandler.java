package mod.industrialProcessing.work.recipe;

import java.util.Iterator;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.utils.inventory.IInventorySlots;
import mod.industrialProcessing.work.worker.IWorkHandler;

public interface IRecipeMultiblockWorkHandler extends IWorkHandler, IInventorySlots{
	Iterator<RecipeMultiblock> iterateRecipes();
	Tiers getTier();
}

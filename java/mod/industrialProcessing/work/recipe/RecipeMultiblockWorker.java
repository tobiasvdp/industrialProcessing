package mod.industrialProcessing.work.recipe;

import java.util.Iterator;
import java.util.Random;

import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.worker.ServerWorker;
import net.minecraft.item.ItemStack;

public class RecipeMultiblockWorker extends RecipeGenericWorker<RecipeMultiblock, IRecipeMultiblockWorkHandler> {

	public RecipeMultiblockWorker(IRecipeMultiblockWorkHandler handler) {
		super(handler); 
	}

	@Override
	protected boolean recipeValid(RecipeMultiblock iterator) {
		return iterator.getTier() == this.handler.getTier();
	}
}

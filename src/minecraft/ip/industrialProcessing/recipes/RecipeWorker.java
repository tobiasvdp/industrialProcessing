package ip.industrialProcessing.recipes;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.item.ItemStack;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.Worker;

public class RecipeWorker extends Worker {

	private Random random = new Random();
	private IRecipeWorkHandler handler;
	private Recipe recipe;

	public RecipeWorker(IRecipeWorkHandler handler) {
		super(handler, 100);
		this.handler = handler;

	}

	@Override
	protected boolean hasWork() {
		return super.hasWork() && matchesInput(this.recipe);
	};

	@Override
	protected boolean canWork() {
		return super.canWork() && outputAvailable(this.recipe);
	};

	@Override
	protected void onEndWork() {
		removeInput(recipe);
			produceOutput(recipe);
		super.onEndWork();
		this.recipe = null;
	}

	@Override
	protected void onBeginWork() {
		this.recipe = this.getCurrentRecipe();
		if (recipe != null)
			this.totalWork = this.recipe.workRequired;
		else
			this.totalWork = 0;
		super.onBeginWork();
	}

	public Recipe getCurrentRecipe() {
		for (Iterator<Recipe> iterator = this.handler.iterateRecipes(); iterator
				.hasNext();) {
			Recipe currentRecipe = iterator.next();
			if (matchesInput(currentRecipe)) {
				return currentRecipe;
			}
		}
		return null;
	}

	private boolean matchesInput(Recipe currentRecipe) {
		if (currentRecipe == null)
			return false;
		if (currentRecipe.inputs == null)
			return false;
		for (int i = 0; i < currentRecipe.inputs.length; i++) {
			// TODO: liquids and tank recipes!
			RecipeInputSlot slot = currentRecipe.inputs[i];
			if (!this.handler
					.slotContains(slot.index, slot.itemId, slot.amount))
				return false;
		}
		return true;
	}

	private boolean outputAvailable(Recipe currentRecipe) {
		if (currentRecipe == null || currentRecipe.outputs == null)
			return false;
		for (int i = 0; i < currentRecipe.inputs.length; i++) {
			// TODO: liquids and tank recipes!
			RecipeOutputSlot slot = currentRecipe.outputs[i];
			if (!this.handler.slotHasRoomFor(slot.index, slot.itemId,
					slot.maxAmount))
				return false;
		}
		return true;
	}

	private void removeInput(Recipe currentRecipe) {
		if (currentRecipe == null || currentRecipe.inputs == null)
			return;
		for (int i = 0; i < currentRecipe.inputs.length; i++) {
			// TODO: liquids and tank recipes!
			RecipeInputSlot slot = currentRecipe.inputs[i];

			if (!this.handler.removeFromSlot(slot.index, slot.itemId,
					slot.amount))
				System.out.println("Failed to remove recipe input?!");
		}
	}

	protected void produceOutput(Recipe recipe) {
		if (recipe == null || recipe.outputs == null)
			return;
		for (int i = 0; i < recipe.outputs.length; i++) {
			// TODO: liquids and tank recipes!
			RecipeOutputSlot slot = recipe.outputs[i];

			int amount = getAmount(slot.minAmount, slot.maxAmount,
					slot.distributionCenter);
			if (!this.handler.addToSlot(slot.index, slot.itemId, amount))
				System.out.println("Failed to create recipe output?!");
		}

	}

	private int getAmount(int minAmount, int maxAmount,
			double distributionCenter) {

		int size = maxAmount - minAmount;
		if (size == 0)
			return minAmount;

		double value = random.nextGaussian() + distributionCenter;

		int amount = (int) Math.round(value * size) + minAmount;

		return 0;
	}
}

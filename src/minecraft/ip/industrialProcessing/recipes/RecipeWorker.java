package ip.industrialProcessing.recipes;

import java.util.Iterator;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.ServerWorker; 
public class RecipeWorker extends ServerWorker {

	private Random random;
	private IRecipeWorkHandler handler;
	private Recipe recipe;

	public RecipeWorker(IRecipeWorkHandler handler) {
		super(handler, 100);
		this.handler = handler;
		this.random = new Random(156464564);
	}

	@Override
	public boolean hasWork() {
		return super.hasWork() && matchesInput(this.recipe);
	};

	@Override
	public boolean canWork() {
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
	protected void onPrepareWork() {
			this.recipe = this.getCurrentRecipe();
			if (recipe != null)
				this.totalWork = this.recipe.workRequired;
			else
				this.totalWork = 0;
		super.onPrepareWork();
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
			RecipeInputSlot slot = currentRecipe.inputs[i];
			if (!hasInputIngredients(slot))
				return false;
		}
		return true;
	}

	protected boolean hasInputIngredients(RecipeInputSlot slot) {
		if (slot.type == RecipeSlotType.INVENTORY) {
			return this.handler.slotContains(slot.index, slot.itemId,
					slot.amount);
		}
		return false;
	}

	private boolean outputAvailable(Recipe currentRecipe) {
		if (currentRecipe == null || currentRecipe.outputs == null)
			return false;
		for (int i = 0; i < currentRecipe.outputs.length; i++) {
			RecipeOutputSlot slot = currentRecipe.outputs[i];
			if (!hasOutputSpace(slot))
				return false;
		}
		return true;
	}

	protected boolean hasOutputSpace(RecipeOutputSlot slot) {
		if (slot.type == RecipeSlotType.INVENTORY) {
			return this.handler.slotHasRoomFor(slot.index, slot.itemId,
					slot.maxAmount);
		}
		return false;
	}

	private void removeInput(Recipe currentRecipe) {
		if (currentRecipe == null || currentRecipe.inputs == null)
			return;
		for (int i = 0; i < currentRecipe.inputs.length; i++) {
			RecipeInputSlot slot = currentRecipe.inputs[i];

			removeFromInput(slot);
		}
	}

	protected void removeFromInput(RecipeInputSlot slot) {
		if (slot.type == RecipeSlotType.INVENTORY) {
			if (!this.handler.removeFromSlot(slot.index, slot.itemId,
					slot.amount))
				System.out.println("Failed to remove recipe input?!");
		}
	}

	protected void produceOutput(Recipe recipe) {

		if (recipe == null || recipe.outputs == null)
			return;
		System.out.println("Outputting recipe after working "
				+ recipe.workRequired);
		for (int i = 0; i < recipe.outputs.length; i++) {
			RecipeOutputSlot slot = recipe.outputs[i];

			double randomValue = random.nextGaussian();

			int amount = getAmount(randomValue, slot.minAmount, slot.maxAmount,
					slot.distributionCenter);
			if (amount > 0)
				addToOutput(amount, slot);
		}

	}

	protected void addToOutput(int amount, RecipeOutputSlot slot) {
		if (slot.type == RecipeSlotType.INVENTORY) {
			if (!this.handler.addToSlot(slot.index, slot.itemId, amount))
				System.out.println("Failed to create recipe output?!");
		}
	}

	protected int getAmount(double randomValue, int minAmount, int maxAmount,
			double distributionCenter) {
		int size = maxAmount - minAmount;
		if (size == 0)
			return minAmount;

		double value = randomValue;
		double resize = Math.abs(0.5 - distributionCenter) + 1;
		value *= resize;
		value = Math.max(0, Math.min(value + distributionCenter, 1));
		int amount = (int) Math.round(value * size) + minAmount;
		System.out.println(String.format("%s: %s-%s %s = %s", randomValue,
				minAmount, maxAmount, distributionCenter, amount));
		return amount;
	}
}

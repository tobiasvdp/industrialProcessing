package mod.industrialProcessing.work.recipe;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.item.ItemStack;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;
import mod.industrialProcessing.work.worker.ServerWorker;

public class RecipeMultiblockWorker extends ServerWorker {

	private Random random;
	protected IRecipeMultiblockWorkHandler handler;
	protected RecipeMultiblock recipe;

	public RecipeMultiblockWorker(IRecipeMultiblockWorkHandler handler) {
		super(handler, 100);
		this.handler = handler;
		this.random = new Random(156464564);
	}

	protected boolean matchesInput(RecipeMultiblock currentRecipe) {
		if (currentRecipe == null)
			return false;
		if (currentRecipe.inputs == null)
			return false;
		if (currentRecipe.tier != handler.getTier())
			return false;
		for (int i = 0; i < currentRecipe.inputs.length; i++) {
			RecipeInputInventorySlot slot = currentRecipe.inputs[i];
			if (!hasInputIngredients(slot))
				return false;
		}
		return true;
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

	public RecipeMultiblock getCurrentRecipe() {
		Iterator<RecipeMultiblock> iterator = this.handler.iterateRecipes();
		if (iterator == null)
			return null;
		for (; iterator.hasNext();) {
			RecipeMultiblock currentRecipe = iterator.next();
			if (matchesInput(currentRecipe)) {
				return currentRecipe;
			}
		}
		return null;
	}

	protected boolean hasInputIngredients(RecipeInputInventorySlot slot) {
		ItemStack stack = this.handler.getStackInSlot(slot.index);
		if (stack == null)
			return false;
		return slot.isItemValid(stack);
	}

	protected boolean outputAvailable(Recipe currentRecipe) {
		RecipeOutputInventorySlot[] outputSlots = recipe.getInventoryOutputs();
		if (currentRecipe == null || outputSlots == null)
			return false;
		for (int i = 0; i < outputSlots.length; i++) {
			RecipeOutputInventorySlot slot = outputSlots[i];
			if (!hasOutputSpace(slot))
				return false;
		}
		return true;
	}

	protected boolean hasOutputSpace(RecipeOutputInventorySlot slot) {
		return slot.hasSpace(this.handler);
	}

	protected void removeInput(Recipe currentRecipe) {
		RecipeInputInventorySlot[] inputSlots = currentRecipe.getInventoryInputs();
		if (currentRecipe == null || inputSlots == null)
			return;
		for (int i = 0; i < inputSlots.length; i++) {
			RecipeInputInventorySlot slot = currentRecipe.inputs[i];

			removeFromInput(slot);
		}
	}

	protected void removeFromInput(RecipeInputInventorySlot slot) {
		slot.removeFrom(handler);
	}

	protected void produceOutput(Recipe recipe) {
		RecipeOutputInventorySlot[] outputSlots = recipe.getInventoryOutputs();
		if (recipe == null || outputSlots == null)
			return;
		for (int i = 0; i < outputSlots.length; i++) {
			RecipeOutputInventorySlot slot = outputSlots[i];

			double randomValue = random.nextGaussian();

			int amount = slot.getRandomAmount(randomValue);
			if (amount > 0)
				addToOutput(amount, slot);
		}
	}

	protected void addToOutput(int amount, RecipeOutputInventorySlot slot) {
		slot.addToOutput(this.handler, amount);
	}
}

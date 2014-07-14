package mod.industrialProcessing.work.recipe;

import java.util.Iterator;
import java.util.Random;

import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.worker.ServerWorker;
import net.minecraft.item.ItemStack;

public class RecipeGenericWorker<TMachineRecipe extends IMachineRecipe, TWorkHandler extends IRecipeWorkHandler<TMachineRecipe>> extends ServerWorker {

	protected final Random random;
	protected TWorkHandler handler;
	protected TMachineRecipe recipe;

	public TMachineRecipe getRecipe() {
		return recipe;
	}

	public RecipeGenericWorker(TWorkHandler handler) {
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
		this.recipe = this.findCurrentRecipe();
		if (recipe != null)
			this.totalWork = this.recipe.getWorkRequired();
		else
			this.totalWork = 0;
		super.onPrepareWork();
	}

	public TMachineRecipe findCurrentRecipe() {
		Iterator<TMachineRecipe> iterator = this.handler.iterateRecipes();
		if (iterator == null)
			return null;
		for (; iterator.hasNext();) {
			TMachineRecipe currentRecipe = iterator.next();
			if (matchesInput(currentRecipe)) {
				return currentRecipe;
			}
		}
		return null;
	}

	protected boolean recipeValid(TMachineRecipe iterator) {
		return true;
	}

	protected boolean matchesInput(TMachineRecipe currentRecipe) {
		if (currentRecipe == null)
			return false;
		if (!recipeValid(currentRecipe))
			return false;
		RecipeInputInventorySlot[] inputSlots = currentRecipe.getInventoryInputs();
		if (inputSlots == null)
			return false;
		for (int i = 0; i < inputSlots.length; i++) {
			RecipeInputInventorySlot slot = inputSlots[i];
			if (!hasInputIngredients(slot))
				return false;
		}
		return true;
	}

	protected boolean hasInputIngredients(RecipeInputInventorySlot slot) {

		ItemStack stack = this.handler.getStackInSlot(slot.index);

		if (stack == null)
			return false;
		return slot.isStackValid(stack);
	}

	protected boolean outputAvailable(TMachineRecipe currentRecipe) {
		RecipeOutputInventorySlot[] outputSlots = recipe.getInventoryOutputs();
		if (currentRecipe == null)
			return false;
		if( outputSlots == null)// no outputs means room enough to output nothing!
			return true;
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

	protected void removeInput(TMachineRecipe currentRecipe) {
		RecipeInputInventorySlot[] inputSlots = currentRecipe.getInventoryInputs();
		if (currentRecipe == null || inputSlots == null)
			return;
		for (int i = 0; i < inputSlots.length; i++) {
			RecipeInputInventorySlot slot = inputSlots[i];

			removeFromInput(slot);
		}
	}

	protected void removeFromInput(RecipeInputInventorySlot slot) {
		slot.removeFrom(handler);
	}

	protected void produceOutput(TMachineRecipe recipe) {
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

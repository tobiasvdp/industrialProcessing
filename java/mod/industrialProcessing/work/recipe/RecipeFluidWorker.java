package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;

public class RecipeFluidWorker extends RecipeWorker {

	private IRecipeFluidWorkHandler fluidHanlder;

	public RecipeFluidWorker(IRecipeFluidWorkHandler handler) {
		super(handler);
		this.fluidHanlder = handler;
	}

	@Override
	protected boolean matchesInput(IMachineRecipe currentRecipe) {
		boolean inventory = super.matchesInput(currentRecipe);
		if (!inventory)
			return false;

		RecipeInputFluidSlot[] inputSlots = currentRecipe.getFluidInputs();
		if (inputSlots == null)
			return false;
		for (int i = 0; i < inputSlots.length; i++) {
			RecipeInputFluidSlot slot = inputSlots[i];
			if (!hasInputIngredients(slot))
				return false;
		}
		return true;
	}

	@Override
	protected void removeInput(IMachineRecipe currentRecipe) {
		super.removeInput(currentRecipe);

		RecipeInputFluidSlot[] inputSlots = currentRecipe.getFluidInputs();
		if (currentRecipe == null || inputSlots == null)
			return;
		for (int i = 0; i < inputSlots.length; i++) {
			RecipeInputFluidSlot slot = inputSlots[i];

			removeFromInput(slot);
		}
	}

	@Override
	protected boolean outputAvailable(IMachineRecipe currentRecipe) {
		boolean inventory = super.outputAvailable(currentRecipe);

		if (!inventory)
			return false;

		RecipeOutputFluidSlot[] outputSlots = recipe.getFluidOutputs();
		if (currentRecipe == null || outputSlots == null)
			return false;
		for (int i = 0; i < outputSlots.length; i++) {
			RecipeOutputFluidSlot slot = outputSlots[i];
			if (!hasOutputSpace(slot))
				return false;
		}
		return true;

	}

	@Override
	protected void produceOutput(IMachineRecipe recipe) {
		super.produceOutput(recipe);

		RecipeOutputFluidSlot[] outputSlots = recipe.getFluidOutputs();
		if (recipe == null || outputSlots == null)
			return;
		for (int i = 0; i < outputSlots.length; i++) {
			RecipeOutputFluidSlot slot = outputSlots[i];

			double randomValue = random.nextGaussian();
  			
			int amount = slot.getRandomAmount(randomValue); 
			if (amount > 0)
				addToOutput(amount, slot);

		}
	}

	protected boolean hasOutputSpace(RecipeOutputFluidSlot slot) {

		return slot.hasRoom(this.fluidHanlder);
	}

	protected boolean hasInputIngredients(RecipeInputFluidSlot fluidSlot) {
		return this.fluidHanlder.tankContains(fluidSlot.index, fluidSlot.getFluid(), fluidSlot.getMaxAmount());
	};

	protected void removeFromInput(RecipeInputFluidSlot slot) {

		slot.removeFrom(this.fluidHanlder);
	}

	protected void addToOutput(int amount, RecipeOutputFluidSlot slot) {
		slot.addToOutput(this.fluidHanlder, amount);
	}
}

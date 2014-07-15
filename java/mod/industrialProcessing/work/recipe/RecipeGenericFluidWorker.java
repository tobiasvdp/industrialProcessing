package mod.industrialProcessing.work.recipe;

import net.minecraftforge.fluids.FluidStack;
import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputFluidSlot;

public class RecipeGenericFluidWorker<TMachineRecipe extends IMachineRecipe, TWorkHandler extends IRecipeFluidWorkHandler<TMachineRecipe>> extends RecipeGenericWorker<TMachineRecipe, TWorkHandler> {

	private TWorkHandler fluidHanlder;

	public RecipeGenericFluidWorker(TWorkHandler handler) {
		super(handler);
		this.fluidHanlder = handler;
	}

	@Override
	protected boolean matchesInput(TMachineRecipe currentRecipe) {
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
	protected void removeInput(TMachineRecipe currentRecipe) {
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
	protected boolean outputAvailable(TMachineRecipe currentRecipe) {
		boolean inventory = super.outputAvailable(currentRecipe);

		System.out.println("output available?");
		if (!inventory)
			return false;

		RecipeOutputFluidSlot[] outputSlots = recipe.getFluidOutputs();
		if (currentRecipe == null)
			return false;
		if (outputSlots == null)// no outputs means room enough to output nothing!
			return true;
		for (int i = 0; i < outputSlots.length; i++) {
			RecipeOutputFluidSlot slot = outputSlots[i];
			if (!hasOutputSpace(slot))
				return false;
		}
		return true;

	}

	@Override
	protected void produceOutput(TMachineRecipe recipe) {
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

		FluidStack stack = this.fluidHanlder.getFluidStackInSlot(fluidSlot.index); 
		return fluidSlot.isFluidStackValid(stack);
	};

	protected void removeFromInput(RecipeInputFluidSlot slot) {

		slot.removeFrom(this.fluidHanlder);
	}

	protected void addToOutput(int amount, RecipeOutputFluidSlot slot) {
		slot.addToOutput(this.fluidHanlder, amount);
	}
}

package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import net.minecraft.item.ItemStack;

public class Recipe implements IMachineRecipe {
	public RecipeInputInventorySlot[] inputs;
	public RecipeOutputInventorySlot[] outputs;

	public RecipeInputFluidSlot[] inputFluids;
	public RecipeOutputFluidSlot[] outputFluids;

	public int workRequired;

	public Recipe(RecipeInputInventorySlot[] input, RecipeOutputInventorySlot[] output, int work) {
		this.inputs = input;
		this.outputs = output;
		this.workRequired = work;
	}

	public Recipe(RecipeInputInventorySlot[] input, RecipeInputFluidSlot[] inputFluids, RecipeOutputInventorySlot[] output, RecipeOutputFluidSlot[] outputFluids, int work) {
		this.inputFluids = inputFluids;
		this.inputs = input;

		this.outputFluids = outputFluids;
		this.outputs = output;

		this.workRequired = work;
	}

	public Recipe(RecipeInputFluidSlot[] inputFluids, RecipeOutputInventorySlot[] output, RecipeOutputFluidSlot[] outputFluids, int work) {
		this.inputFluids = inputFluids;

		this.outputFluids = outputFluids;
		this.outputs = output;

		this.workRequired = work;
	}

	public Recipe(RecipeInputInventorySlot[] input, RecipeOutputInventorySlot[] output, RecipeOutputFluidSlot[] outputFluids, int work) {

		this.inputs = input;

		this.outputFluids = outputFluids;
		this.outputs = output;

		this.workRequired = work;
	}

	public Recipe(RecipeInputInventorySlot[] input, RecipeOutputFluidSlot[] outputFluids, int work) {

		this.inputs = input;

		this.outputFluids = outputFluids;

		this.workRequired = work;
	}

	public Recipe(RecipeInputInventorySlot[] input, RecipeInputFluidSlot[] inputFluids, RecipeOutputInventorySlot[] output, int work) {
		this.inputFluids = inputFluids;
		this.inputs = input;

		this.outputs = output;

		this.workRequired = work;
	}

	public Recipe(RecipeInputInventorySlot[] input, RecipeInputFluidSlot[] inputFluids, RecipeOutputFluidSlot[] outputFluids, int work) {
		this.inputFluids = inputFluids;
		this.inputs = input;

		this.outputFluids = outputFluids;

		this.workRequired = work;
	}

	public Recipe(RecipeInputFluidSlot[] inputFluids, RecipeOutputInventorySlot[] output, int work) {
		this.inputFluids = inputFluids;

		this.outputs = output;

		this.workRequired = work;
	}

	public Recipe(RecipeInputFluidSlot[] input, RecipeOutputFluidSlot[] output, int work) {
		this.inputFluids = input;
		this.outputFluids = output;
		this.workRequired = work;
	}

	public Recipe() {
	}

	@Override
	public RecipeInputInventorySlot[] getInventoryInputs() {
		return inputs;
	}

	@Override
	public RecipeOutputInventorySlot[] getInventoryOutputs() {
		return outputs;
	}

	@Override
	public RecipeInputFluidSlot[] getFluidInputs() {
		return inputFluids;
	}

	@Override
	public RecipeOutputFluidSlot[] getFluidOutputs() {
		return outputFluids;
	}

	@Override
	public int getWorkRequired() {
		return workRequired;
	}

	public boolean matchesInput(ItemStack[] config) {
		if (config == null)
			return false;
		for (int i = 0; i < inputs.length; i++) {
			RecipeInputInventorySlot input = this.inputs[i];
			if (input == null)
				continue;
			if (input.index >= config.length)
				return false;

			ItemStack stack = config[input.index];
			if (!input.isStackValid(stack))
				return false;
		}
		return inputs != null && inputs.length > 0;
	}

}

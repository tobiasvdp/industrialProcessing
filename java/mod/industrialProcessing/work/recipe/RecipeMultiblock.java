package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;

public class RecipeMultiblock extends Recipe implements ITierRecipe {
	public RecipeMultiblock() {
		super();
	}

	public RecipeMultiblock(RecipeInputInventorySlot[] input, RecipeOutputInventorySlot[] output, int work, Tiers tier) {
		super(input, output, work);
	}

	public RecipeMultiblock(RecipeInputInventorySlot[] input, RecipeInputFluidSlot[] inputFluids, RecipeOutputInventorySlot[] output, RecipeOutputFluidSlot[] outputFluids, int work) {
		super(input, inputFluids, output, outputFluids, work);
	}

	public Tiers tier;

	@Override
	public Tiers getTier() {
		return tier;
	}

}

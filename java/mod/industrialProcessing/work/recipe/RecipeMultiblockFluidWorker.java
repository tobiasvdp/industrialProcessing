package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;

public class RecipeMultiblockFluidWorker extends RecipeMultiblockWorker {

	private IRecipeMultiblockFluidWorkHandler fluidHanlder;

	public RecipeMultiblockFluidWorker(IRecipeMultiblockFluidWorkHandler handler) {
		super(handler);
		this.fluidHanlder = handler;
	}

	@Override
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
	protected boolean hasOutputSpace(RecipeOutputInventorySlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			return this.fluidHanlder.tankHasRoomFor(slot.index, slot.fluid, slot.maxAmount);
		} else {
			return super.hasOutputSpace(slot);
		}
	}

	@Override
	protected boolean hasInputIngredients(RecipeInputInventorySlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			return this.fluidHanlder.tankContains(slot.index, slot.fluid, slot.amount);
		} else {
			return super.hasInputIngredients(slot);
		}
	};

	@Override
	protected void removeFromInput(RecipeInputInventorySlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			if (!this.fluidHanlder.removeFromTank(slot.index, slot.fluid, slot.amount))
				System.out.println("Failed to remove recipe inpt?!");
		} else {
			super.removeFromInput(slot);
		}
	}

	@Override
	protected void addToOutput(int amount, RecipeOutputInventorySlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			if (!this.fluidHanlder.addToTank(slot.index, slot.fluid, amount))
				System.out.println("Failed to create recipe output?! ");
		} else {
			super.addToOutput(amount, slot);
		}
	}

}

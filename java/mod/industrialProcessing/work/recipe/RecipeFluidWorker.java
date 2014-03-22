package mod.industrialProcessing.work.recipe;

public class RecipeFluidWorker extends RecipeWorker {

	private IRecipeFluidWorkHandler fluidHanlder;

	public RecipeFluidWorker(IRecipeFluidWorkHandler handler) {
		super(handler);
		this.fluidHanlder = handler;
	}

	@Override
	protected boolean hasOutputSpace(RecipeOutputSlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			return this.fluidHanlder.tankHasRoomFor(slot.index, slot.itemId, slot.maxAmount);
		} else {
			return super.hasOutputSpace(slot);
		}
	}

	@Override
	protected boolean hasInputIngredients(RecipeInputSlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			return this.fluidHanlder.tankContains(slot.index, slot.itemId, slot.amount);
		} else {
			return super.hasInputIngredients(slot);
		}
	};

	@Override
	protected void removeFromInput(RecipeInputSlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			if (!this.fluidHanlder.removeFromTank(slot.index, slot.itemId, slot.amount))
				System.out.println("Failed to remove recipe inpt?!");
		} else {
			super.removeFromInput(slot);
		}
	}

	@Override
	protected void addToOutput(int amount, RecipeOutputSlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			if (!this.fluidHanlder.addToTank(slot.index, slot.itemId, amount))
				System.out.println("Failed to create recipe output?! ");
		} else {
			super.addToOutput(amount, slot);
		}
	}
}

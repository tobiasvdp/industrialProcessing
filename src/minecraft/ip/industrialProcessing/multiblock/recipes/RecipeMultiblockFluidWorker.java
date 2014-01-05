package ip.industrialProcessing.multiblock.recipes;

import ip.industrialProcessing.recipes.IRecipeFluidWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeFluidWorker;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipeMultiblockFluidWorker extends RecipeMultiblockWorker {

	private IRecipeMultiblockFluidWorkHandler fluidHanlder;

	public RecipeMultiblockFluidWorker(IRecipeMultiblockFluidWorkHandler handler) {
		super(handler);
		this.fluidHanlder = handler;
	}
	
	protected boolean matchesInput(RecipeMultiblock currentRecipe) {
        if (currentRecipe == null)
            return false;
        if (currentRecipe.inputs == null)
            return false;
        if(currentRecipe.tier != handler.getTier())
        	return false;
        for (int i = 0; i < currentRecipe.inputs.length; i++) {
            RecipeInputSlot slot = currentRecipe.inputs[i];
            if (!hasInputIngredients(slot))
                return false;
        }
        return true;
    }
	
	@Override
	protected boolean hasOutputSpace(RecipeOutputSlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			return this.fluidHanlder.tankHasRoomFor(slot.index, slot.itemId,
					slot.maxAmount);
		} else {
			return super.hasOutputSpace(slot);
		}
	}

	@Override
	protected boolean hasInputIngredients(RecipeInputSlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			return this.fluidHanlder.tankContains(slot.index, slot.itemId,
					slot.amount);
		} else {
			return super.hasInputIngredients(slot);
		}
	};

	@Override
	protected void removeFromInput(RecipeInputSlot slot) {
		if (slot.type == RecipeSlotType.TANK) {
			if (!this.fluidHanlder.removeFromTank(slot.index, slot.itemId,
					slot.amount))
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

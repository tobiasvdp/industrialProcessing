package mod.industrialProcessing.work.recipe;

import java.util.Iterator;
import java.util.Random;

import mod.industrialProcessing.work.worker.ServerWorker;

public class RecipeWorker extends ServerWorker {

    private Random random;
    protected IRecipeWorkHandler handler;
    protected IMachineRecipe recipe;

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
            this.totalWork = this.recipe.getWorkRequired();
        else
            this.totalWork = 0;
        super.onPrepareWork();
    }

    public IMachineRecipe getCurrentRecipe() {
        Iterator<IMachineRecipe> iterator = this.handler.iterateRecipes();
        if (iterator == null)
            return null;
        for (; iterator.hasNext();) {
            IMachineRecipe currentRecipe = iterator.next();
            if (matchesInput(currentRecipe)) {
                return currentRecipe;
            }
        }
        return null;
    }

    protected boolean matchesInput(IMachineRecipe currentRecipe) {
        if (currentRecipe == null)
            return false;
	RecipeInputSlot[] inputSlots = currentRecipe.getInputs();
        if (inputSlots == null)
            return false;
        for (int i = 0; i < inputSlots.length; i++) {
            RecipeInputSlot slot = inputSlots[i];
            if (!hasInputIngredients(slot))
                return false;
        }
        return true;
    }

    protected boolean hasInputIngredients(RecipeInputSlot slot) {
        if (slot.type == RecipeSlotType.INVENTORY || slot.type == RecipeSlotType.DAMAGEDITEM) {
            if (slot.hasMetadata)
                return this.handler.slotContains(slot.index, slot.getItem(), slot.metadata, slot.amount);
            else
                return this.handler.slotContains(slot.index, slot.getItem(), slot.amount);
        }
        return false;
    }

    private boolean outputAvailable(IMachineRecipe currentRecipe) {
	RecipeOutputSlot[] outputSlots = recipe.getOutputs();
        if (currentRecipe == null || outputSlots == null)
            return false;
        for (int i = 0; i < outputSlots.length; i++) {
            RecipeOutputSlot slot = outputSlots[i];
            if (!hasOutputSpace(slot))
                return false;
        }
        return true;
    }

    protected boolean hasOutputSpace(RecipeOutputSlot slot) {
        if (slot.type == RecipeSlotType.INVENTORY) {
            return this.handler.slotHasRoomFor(slot.index, slot.getItem(), slot.maxAmount, slot.damage);
        }
        return false;
    }

    private void removeInput(IMachineRecipe currentRecipe) {
	RecipeInputSlot[] inputSlots = currentRecipe.getInputs();
        if (currentRecipe == null || inputSlots == null)
            return;
        for (int i = 0; i < inputSlots.length; i++) {
            RecipeInputSlot slot = inputSlots[i];

            removeFromInput(slot);
        }
    }

    protected void removeFromInput(RecipeInputSlot slot) {
        if (slot.type == RecipeSlotType.INVENTORY) {
            if (!this.handler.removeFromSlot(slot.index, slot.getItem(), slot.amount))
                System.err.println("Failed to remove recipe input?!");
        } else if (slot.type == RecipeSlotType.DAMAGEDITEM) {
            if (!this.handler.damageItem(slot.index, slot.getItem()))
                System.err.println("Failed to damage recipe input?!");
        }
    }

    protected void produceOutput(IMachineRecipe recipe) {
	RecipeOutputSlot[] outputSlots = recipe.getOutputs();
        if (recipe == null || outputSlots == null)
            return;
        for (int i = 0; i < outputSlots.length; i++) {
            RecipeOutputSlot slot = outputSlots[i];

            double randomValue = random.nextGaussian();

            int amount = getAmount(randomValue, slot.minAmount, slot.maxAmount, slot.distributionCenter);
            if (amount > 0)
                addToOutput(amount, slot);
        }

    }

    protected void addToOutput(int amount, RecipeOutputSlot slot) {
        if (slot.type == RecipeSlotType.INVENTORY) {
            if (!this.handler.addToSlot(slot.index, slot.getItem(), amount, slot.damage))
                System.err.println("Failed to create recipe output?!");
        }
    }

    protected int getAmount(double randomValue, int minAmount, int maxAmount, double distributionCenter) {
        double size = maxAmount - minAmount;
        if (size == 0)
            return minAmount;
        
        distributionCenter = minAmount + distributionCenter*size; 
        double value = distributionCenter + randomValue/3 * size;
        value = Math.max(minAmount, value);
        value = Math.min(maxAmount, value); 
        return (int) Math.round(value);
    }
}

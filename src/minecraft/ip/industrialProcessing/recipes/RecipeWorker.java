package ip.industrialProcessing.recipes;

import java.util.Iterator;
import java.util.Random;

import ip.industrialProcessing.utils.working.ServerWorker;

public class RecipeWorker extends ServerWorker {

    private Random random;
    protected IRecipeWorkHandler handler;
    protected Recipe recipe;

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
            this.totalWork = this.recipe.workRequired;
        else
            this.totalWork = 0;
        super.onPrepareWork();
    }

    public Recipe getCurrentRecipe() {
        Iterator<Recipe> iterator = this.handler.iterateRecipes();
        if (iterator == null)
            return null;
        for (; iterator.hasNext();) {
            Recipe currentRecipe = iterator.next();
            if (matchesInput(currentRecipe)) {
                return currentRecipe;
            }
        }
        return null;
    }

    protected boolean matchesInput(Recipe currentRecipe) {
        if (currentRecipe == null)
            return false;
        if (currentRecipe.inputs == null)
            return false;
        for (int i = 0; i < currentRecipe.inputs.length; i++) {
            RecipeInputSlot slot = currentRecipe.inputs[i];
            if (!hasInputIngredients(slot))
                return false;
        }
        return true;
    }

    protected boolean hasInputIngredients(RecipeInputSlot slot) {
        if (slot.type == RecipeSlotType.INVENTORY || slot.type == RecipeSlotType.DAMAGEDITEM) {
            if (slot.hasMetadata)
                return this.handler.slotContains(slot.index, slot.itemId, slot.metadata, slot.amount);
            else
                return this.handler.slotContains(slot.index, slot.itemId, slot.amount);
        }
        return false;
    }

    private boolean outputAvailable(Recipe currentRecipe) {
        if (currentRecipe == null || currentRecipe.outputs == null)
            return false;
        for (int i = 0; i < currentRecipe.outputs.length; i++) {
            RecipeOutputSlot slot = currentRecipe.outputs[i];
            if (!hasOutputSpace(slot))
                return false;
        }
        return true;
    }

    protected boolean hasOutputSpace(RecipeOutputSlot slot) {
        if (slot.type == RecipeSlotType.INVENTORY) {
            return this.handler.slotHasRoomFor(slot.index, slot.itemId, slot.maxAmount, slot.damage);
        }
        return false;
    }

    private void removeInput(Recipe currentRecipe) {
        if (currentRecipe == null || currentRecipe.inputs == null)
            return;
        for (int i = 0; i < currentRecipe.inputs.length; i++) {
            RecipeInputSlot slot = currentRecipe.inputs[i];

            removeFromInput(slot);
        }
    }

    protected void removeFromInput(RecipeInputSlot slot) {
        if (slot.type == RecipeSlotType.INVENTORY) {
            if (!this.handler.removeFromSlot(slot.index, slot.itemId, slot.amount))
                System.err.println("Failed to remove recipe input?!");
        } else if (slot.type == RecipeSlotType.DAMAGEDITEM) {
            if (!this.handler.damageItem(slot.index, slot.itemId))
                System.err.println("Failed to damage recipe input?!");
        }
    }

    protected void produceOutput(Recipe recipe) {

        if (recipe == null || recipe.outputs == null)
            return;
        for (int i = 0; i < recipe.outputs.length; i++) {
            RecipeOutputSlot slot = recipe.outputs[i];

            double randomValue = random.nextGaussian();

            int amount = getAmount(randomValue, slot.minAmount, slot.maxAmount, slot.distributionCenter);
            if (amount > 0)
                addToOutput(amount, slot);
        }

    }

    protected void addToOutput(int amount, RecipeOutputSlot slot) {
        if (slot.type == RecipeSlotType.INVENTORY) {
            if (!this.handler.addToSlot(slot.index, slot.itemId, amount, slot.damage))
                System.err.println("Failed to create recipe output?!");
        }
    }

    protected int getAmount(double randomValue, int minAmount, int maxAmount, double distributionCenter) {
        double size = maxAmount - minAmount;
        if (size == 0)
            return minAmount;
        
        distributionCenter = minAmount + distributionCenter*size;
        System.out.println("center:"+distributionCenter);
        System.out.println("div:"+randomValue/3 * size);
        double value = distributionCenter + randomValue/3 * size;
        value = Math.max(minAmount, value);
        value = Math.min(maxAmount, value);
        System.out.println("calc:"+value);
        return (int) Math.round(value);
    }
}

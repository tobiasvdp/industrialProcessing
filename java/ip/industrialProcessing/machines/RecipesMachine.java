package ip.industrialProcessing.machines;

import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.IMachineRecipes;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

import java.util.ArrayList;
import java.util.Iterator;

public class RecipesMachine implements IMachineRecipes<IMachineRecipe> {
    private ArrayList<IMachineRecipe> recipes = new ArrayList<IMachineRecipe>();

    public RecipesMachine() {

    }

    public RecipesMachine(ArrayList<IMachineRecipe> list) {
	Iterator<IMachineRecipe> recipe = list.iterator();
	while (recipe.hasNext())
	    addRecipe(recipe.next());
    }

    public void addRecipe(IMachineRecipe recipe) {
	this.recipes.add(recipe);
    }

    public boolean isEmpty() {
	return this.recipes.isEmpty();
    }

    public int size() {
	return this.recipes.size();
    }

    public IMachineRecipe get(int index) {
	return this.recipes.get(index);
    }

    @Override
    public Iterator<IMachineRecipe> getRecipes() {
	return recipes.iterator();
    }

    public boolean isValidFluidInput(int slot, int fluidId) {
	for (Iterator<IMachineRecipe> i = getRecipes(); i.hasNext();) {
	    IMachineRecipe recipe = i.next();
	    for (RecipeInputSlot input : recipe.getInputs()) {
		if (input.type != RecipeSlotType.TANK)
		    continue;
		if (input.index == slot && input.itemId == fluidId)
		    return true;
	    }
	}
	return false;
    }

    public boolean isValidInput(int slot, int itemID) {
	for (Iterator<IMachineRecipe> i = getRecipes(); i.hasNext();) {
	    IMachineRecipe recipe = i.next();
	    for (RecipeInputSlot input : recipe.getInputs()) {
		if (input.type != RecipeSlotType.INVENTORY && input.type != RecipeSlotType.DAMAGEDITEM)
		    continue;
		if (input.index == slot && input.itemId == itemID)
		    return true;
	    }
	}
	return false;
    }
}

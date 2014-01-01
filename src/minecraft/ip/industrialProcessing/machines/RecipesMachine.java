package ip.industrialProcessing.machines;

import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

import java.util.ArrayList;
import java.util.Iterator;

public class RecipesMachine {
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

	public RecipesMachine() {

	}

	public RecipesMachine(ArrayList<Recipe> list) {
		Iterator<Recipe> recipe = list.iterator();
		while (recipe.hasNext())
			addRecipe(recipe.next());
	}

	public void addRecipe(Recipe recipe) {
		this.recipes.add(recipe);
	}

	public Iterator<Recipe> iterator() {
		return recipes.iterator();
	}

	public boolean isValidFluidInput(int slot, int fluidId) {
		for (Iterator<Recipe> i = iterator(); i.hasNext();) {
			Recipe recipe = i.next();
			for (RecipeInputSlot input : recipe.inputs) {
				if (input.type != RecipeSlotType.TANK)
					continue;
				if (input.index == slot && input.itemId == fluidId)
					return true;
			}
		}
		return false;
	}

	public boolean isValidInput(int slot, int itemID) {
		for (Iterator<Recipe> i = iterator(); i.hasNext();) {
			Recipe recipe = i.next();
			for (RecipeInputSlot input : recipe.inputs) {
				if (input.type != RecipeSlotType.INVENTORY && input.type != RecipeSlotType.DAMAGEDITEM)
					continue;
				if (input.index == slot && input.itemId == itemID)
					return true;
			}
		}
		return false;
	}
}

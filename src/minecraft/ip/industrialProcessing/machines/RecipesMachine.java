package ip.industrialProcessing.machines;

import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;

import java.util.ArrayList;
import java.util.Iterator;

public class RecipesMachine {
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

	public void addRecipe(Recipe recipe) {
		this.recipes.add(recipe);
	}

	public Iterator<Recipe> iterator() {
		return recipes.iterator();
	}

	public boolean isValidInput(int slot, int itemID) {
		for(Iterator<Recipe> i = iterator(); i.hasNext();)
		{
			Recipe recipe = i.next();
			for(RecipeInputSlot input : recipe.inputs)
			{
				if(input.index == slot && input.itemId == itemID) return true;
			}
		}
		return false;
	}
}

package ip.industrialProcessing.machines;

import ip.industrialProcessing.recipes.Recipe;

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
}

package ip.industrialProcessing.multiblock.recipes;

import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

import java.util.ArrayList;
import java.util.Iterator;

public class RecipesMultiblock {
	private ArrayList<RecipeMultiblock> recipes = new ArrayList<RecipeMultiblock>();

	public RecipesMultiblock() {

	}

	public RecipesMultiblock(ArrayList<RecipeMultiblock> list) {
		Iterator<RecipeMultiblock> recipe = list.iterator();
		while (recipe.hasNext())
			addRecipe(recipe.next());
	}

	public void addRecipe(RecipeMultiblock recipe) {
		this.recipes.add(recipe);
	}

	public Iterator<RecipeMultiblock> iterator() {
		return recipes.iterator();
	}

	public boolean isValidFluidInput(int slot, int fluidId, Tiers tier) {
		for (Iterator<RecipeMultiblock> i = iterator(); i.hasNext();) {
			RecipeMultiblock recipe = i.next();
			for (RecipeInputSlot input : recipe.inputs) {
				if (input.type != RecipeSlotType.TANK)
					continue;
				if (input.index == slot && input.itemId == fluidId)
					if(recipe.tier == tier)
						return true;
			}
		}
		return false;
	}

	public boolean isValidInput(int slot, int itemID, Tiers tier) {
		for (Iterator<RecipeMultiblock> i = iterator(); i.hasNext();) {
			RecipeMultiblock recipe = i.next();
			for (RecipeInputSlot input : recipe.inputs) {
				if (input.type != RecipeSlotType.INVENTORY && input.type != RecipeSlotType.DAMAGEDITEM)
					continue;
				if (input.index == slot && input.itemId == itemID)
					if(recipe.tier == tier)
						return true;
			}
		}
		return false;
	}
}

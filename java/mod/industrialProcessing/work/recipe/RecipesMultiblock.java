package ip.industrialProcessing.multiblock.recipes;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.item.Item;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;

public class RecipesMultiblock implements IMachineRecipes<RecipeMultiblock> {
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

    @Override
    public Iterator<RecipeMultiblock> getRecipes() {
	return recipes.iterator();
    }

    public boolean isValidFluidInput(int slot, int fluidId, Tiers tier) {
	for (Iterator<RecipeMultiblock> i = getRecipes(); i.hasNext();) {
	    RecipeMultiblock recipe = i.next();
	    for (RecipeInputSlot input : recipe.inputs) {
		if (input.type != RecipeSlotType.TANK)
		    continue;
		if (input.index == slot && input.itemId == fluidId)
		    if (recipe.tier == tier)
			return true;
	    }
	}
	return false;
    }

    public boolean isValidInput(int slot, Item item, Tiers tier) {
	for (Iterator<RecipeMultiblock> i = getRecipes(); i.hasNext();) {
	    RecipeMultiblock recipe = i.next();
	    for (RecipeInputSlot input : recipe.inputs) {
		if (input.type != RecipeSlotType.INVENTORY && input.type != RecipeSlotType.DAMAGEDITEM)
		    continue;
		if (input.index == slot && input.item.equals(item))
		    if (recipe.tier == tier)
			return true;
	    }
	}
	return false;
    }

    @Override
    public int size() {
	return recipes.size();
    }

    @Override
    public boolean isEmpty() {
	return recipes.isEmpty();
    }

    @Override
    public RecipeMultiblock get(int index) {
	return recipes.get(index);
    }
}

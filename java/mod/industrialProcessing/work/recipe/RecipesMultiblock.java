package mod.industrialProcessing.work.recipe;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;

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

	public boolean isValidFluidInput(int slot, Fluid fluid, Tiers tier) {
		for (Iterator<RecipeMultiblock> i = getRecipes(); i.hasNext();) {
			RecipeMultiblock recipe = i.next();
			if (recipe.tier == tier)
				for (RecipeInputFluidSlot input : recipe.getFluidInputs()) {
					if (input.index == slot && input.isFluidValid(fluid))
						return true;
				}
		}
		return false;
	}

	public boolean isValidInput(int slot, Item item, Tiers tier) {
		for (Iterator<RecipeMultiblock> i = getRecipes(); i.hasNext();) {
			RecipeMultiblock recipe = i.next();
			if (recipe.tier == tier)
				for (RecipeInputInventorySlot input : recipe.getInventoryInputs()) {
					if (input.index == slot && input.isItemValid(item))
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

	@Override
	public boolean isValidInput(int slot, Item item) {
		for (Iterator<RecipeMultiblock> i = getRecipes(); i.hasNext();) {
			RecipeMultiblock recipe = i.next();
			for (RecipeInputInventorySlot input : recipe.getInventoryInputs()) {

				if (input.index == slot && input.isItemValid(item))
					return true;
			}
		}
		return false;
	}
}

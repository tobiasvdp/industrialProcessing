package mod.industrialProcessing.work.recipe;

import java.util.ArrayList;
import java.util.Iterator;

import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

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

	@Override
	public boolean isEmpty() {
		return this.recipes.isEmpty();
	}

	@Override
	public int size() {
		return this.recipes.size();
	}

	@Override
	public IMachineRecipe get(int index) {
		return this.recipes.get(index);
	}

	@Override
	public Iterator<IMachineRecipe> getRecipes() {
		return recipes.iterator();
	}

	public boolean isValidFluidInput(int slot, Fluid fluid) {
		for (Iterator<IMachineRecipe> i = getRecipes(); i.hasNext();) {
			IMachineRecipe recipe = i.next();
			for (RecipeInputFluidSlot input : recipe.getFluidInputs()) {				
				if(input.index == slot && input.isFluidValid(fluid))
					return true;
			}
		}
		return false;
	}

	public boolean isValidInput(int slot, Item item) {
		for (Iterator<IMachineRecipe> i = getRecipes(); i.hasNext();) {
			IMachineRecipe recipe = i.next();
			for (RecipeInputInventorySlot input : recipe.getInventoryInputs()) {

				if (input.index == slot && input.isItemValid(item))
					return true;
			}
		}
		return false;
	}
}

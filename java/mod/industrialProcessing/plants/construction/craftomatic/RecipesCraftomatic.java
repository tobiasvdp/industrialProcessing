package mod.industrialProcessing.plants.construction.craftomatic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.IMachineRecipes;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.VanillaRecipeBridge;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipesCraftomatic implements IMachineRecipes<IMachineRecipe> {

	private ArrayList<IMachineRecipe> recipes = new ArrayList<IMachineRecipe>();

	@Override
	public Iterator<IMachineRecipe> getRecipes() {
		return recipes.iterator();
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
	public IMachineRecipe get(int index) {
		return recipes.get(index);
	}

	@Override
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

	public void setRecipeConfig(ItemStack[] config) {
		this.recipes.clear();

		List recipes = CraftingManager.getInstance().getRecipeList();

		for (int i = 0; i < recipes.size(); i++) {
			IRecipe vanillaRecipe = (IRecipe) recipes.get(i);

			Recipe recipe = VanillaRecipeBridge.getRecipeFromVanilla(vanillaRecipe);
			if (recipe != null)
				if (recipe.matchesInput(config)) {
					for (int j = 0; j < recipe.inputs.length; j++) {
						recipe.inputs[i].index = 9 + recipe.inputs[i].index * 3;
					}
					for (int j = 0; j < recipe.outputs.length; j++) {
						recipe.outputs[i].index = 9 + 9 * 3;
					}
					recipe.workRequired = 300;

					this.recipes.add(recipe);
				}

		}
	}

}

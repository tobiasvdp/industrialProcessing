package mod.industrialProcessing.work.recipe;

import java.util.ArrayList;
import java.util.Iterator;

import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeFireworks;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class VanillaRecipeBridge {

	public static ArrayList<Recipe> addVanillaRecipes() {
		ArrayList<Recipe> ipRecipes = new ArrayList<Recipe>();
		Iterator recipes = CraftingManager.getInstance().getRecipeList().iterator();
		while (recipes.hasNext()) {
			IRecipe recipe = (IRecipe) recipes.next();
			Recipe ipRecipe = getRecipeFromVanilla(recipe);
			if (ipRecipe != null)
				ipRecipes.add(ipRecipe);
		}
		return ipRecipes;
	}

	public static Recipe getRecipeFromVanilla(IRecipe recipe) {
		Recipe ipRecipe = new Recipe();

		if (recipe instanceof RecipeFireworks) {
		} else if (recipe instanceof RecipesArmorDyes) {
			return null;
		} else if (recipe instanceof RecipesMapCloning) {
			return null;
		} else if (recipe instanceof ShapedOreRecipe) {
			return null;
		} else if (recipe instanceof ShapedRecipes) {
			ShapedRecipes recipeVanilla = (ShapedRecipes) recipe;
			ipRecipe.inputs = new RecipeInputInventorySlot[recipeVanilla.recipeItems.length];
			for (int i = 0; i < recipeVanilla.recipeItems.length; i++) {
				ItemStack itemStack = recipeVanilla.recipeItems[i];
				if (itemStack != null)
					ipRecipe.inputs[i] = new RecipeInputInventorySlot(i, itemStack.getItem(), itemStack.getItemDamage(), itemStack.stackSize);
			}
		} else if (recipe instanceof ShapelessOreRecipe) {
			return null;
		} else if (recipe instanceof ShapelessRecipes) {
			ShapelessRecipes recipeVanilla = (ShapelessRecipes) recipe;
			if (recipeVanilla.getRecipeSize() > 4) {
				ipRecipe.inputs = new RecipeInputInventorySlot[recipeVanilla.recipeItems.size()];
				for (int i = 0; i < recipeVanilla.recipeItems.size(); i++) {
					ItemStack itemStack = (ItemStack) recipeVanilla.recipeItems.get(i);
					ipRecipe.inputs[i] = new RecipeInputInventorySlot(i, itemStack.getItem(), itemStack.getItemDamage(), itemStack.stackSize);
				}
			} else {
				ipRecipe.inputs = new RecipeInputInventorySlot[recipeVanilla.recipeItems.size() + 1];
				for (int i = 0; i < recipeVanilla.recipeItems.size(); i++) {
					ItemStack itemStack = (ItemStack) recipeVanilla.recipeItems.get(i);
					if (i == 3)
						i++;
					ipRecipe.inputs[i] = new RecipeInputInventorySlot(i, itemStack.getItem(), itemStack.getItemDamage(), itemStack.stackSize);
				}
			}
		}

		if (recipe.getRecipeOutput() != null) {
			// new RecipeOutputInventorySlot(9, recipe.getRecipeOutput().getItem(), recipe.getRecipeOutput().getItemDamage(), RecipeSlotType.INVENTORY, recipe.getRecipeOutput().stackSize, recipe.getRecipeOutput().stackSize, 0)

			RecipeOutputInventorySlot output = new RecipeOutputInventorySlot(9, recipe.getRecipeOutput());
			ipRecipe.outputs = new RecipeOutputInventorySlot[] { output };
			ipRecipe.workRequired = 0;
			return ipRecipe;
		}
		return null;
	}
}

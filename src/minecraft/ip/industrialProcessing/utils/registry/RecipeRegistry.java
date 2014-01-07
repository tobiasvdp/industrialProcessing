package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.google.common.collect.Lists;

public class RecipeRegistry {
	private static HashMap<Recipe, Block> recipes = new HashMap<Recipe, Block>();

	public static void registerMachinesRecipes(RecipesMachine recipe, Block block) {
		Iterator<Recipe> list = recipe.iterator();
		while (list.hasNext()) {
			recipes.put(list.next(), block);
		}
	}
	
	public static void registerMachinesRecipes(RecipesMultiblock recipe, Block block) {
		Iterator<RecipeMultiblock> list = recipe.iterator();
		while (list.hasNext()) {
			recipes.put(list.next(), block);
		}
	}
	
	public static void addRecipe(Recipe recipe, Block block) {
			recipes.put(recipe, block);
	}

	public static ArrayList<Recipe> FindRecipeForOutput(ItemStack stack) {
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		if (stack != null) {
			Iterator<Entry<Recipe, Block>> iterator = recipes.entrySet().iterator();
			while (iterator.hasNext()) {
				Recipe recipe = iterator.next().getKey();
				for (int i = 0; i < recipe.outputs.length; i++) {
					if (recipe.outputs[i].itemId == stack.itemID) {
						list.add(recipe);
					}
				}
			}
		}
		return list;
	}

	public static ArrayList<Recipe> FindRecipeForOutput(ItemStack stack, int damage) {
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		if (stack != null) {
			Iterator<Entry<Recipe, Block>> iterator = recipes.entrySet().iterator();
			while (iterator.hasNext()) {
				Recipe recipe = iterator.next().getKey();
				for (int i = 0; i < recipe.outputs.length; i++) {
					if (recipe.outputs[i].itemId == stack.itemID && recipe.outputs[i].damage == damage) {
						list.add(recipe);
					}
				}
			}
		}
		return list;
	}

	public static ArrayList<Recipe> FindRecipeForInput(ItemStack stack) {
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		if (stack != null) {
			Iterator<Entry<Recipe, Block>> iterator = recipes.entrySet().iterator();
			while (iterator.hasNext()) {
				Recipe recipe = iterator.next().getKey();
				for (int i = 0; i < recipe.inputs.length; i++) {
					if (recipe.inputs[i].itemId == stack.itemID) {
						list.add(recipe);
					}
				}
			}
		}
		return list;
	}

	public static ArrayList<Recipe> FindRecipeForInput(ItemStack stack, int damage) {
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		if (stack != null) {
			Iterator<Entry<Recipe, Block>> iterator = recipes.entrySet().iterator();
			while (iterator.hasNext()) {
				Recipe recipe = iterator.next().getKey();
				for (int i = 0; i < recipe.inputs.length; i++) {
					if (recipe.inputs[i].itemId == stack.itemID && recipe.outputs[i].damage == damage) {
						list.add(recipe);
					}
				}
			}
		}
		return list;
	}

	public static Block getBlockForRecipe(Recipe recipe) {
		return recipes.get(recipe);
	}

	public static ArrayList<Recipe> getRecipesForMachine(Block block) {
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		Iterator<Entry<Recipe, Block>> iterator = recipes.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Recipe, Block> set = iterator.next();
			if (set.getValue().getClass() == block.getClass()) {
				list.add(set.getKey());
			}
		}
		return list;
	}
}

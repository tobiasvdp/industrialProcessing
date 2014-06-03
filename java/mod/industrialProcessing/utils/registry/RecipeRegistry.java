package mod.industrialProcessing.utils.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.IMachineRecipes;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.RecipeInputSlot;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class RecipeRegistry {
	private static HashMap<IMachineRecipe, Block> recipes = new HashMap<IMachineRecipe, Block>();

	public static void registerMachinesRecipes(IMachineRecipes recipe, Block block) {
		Iterator<IMachineRecipe> list = recipe.getRecipes();
		while (list.hasNext()) {
			recipes.put(list.next(), block);
		}
	}

	public static void registerMachinesRecipes(RecipesMultiblock recipe, Block block) {
		Iterator<RecipeMultiblock> list = recipe.getRecipes();
		while (list.hasNext()) {
			recipes.put(list.next(), block);
		}
	}

	public static void addRecipe(IMachineRecipe recipe, Block block) {
		recipes.put(recipe, block);
	}

	public static void addVanillaRecipes(ArrayList<Recipe> vanillaRecipes) {
		for (int i = 0; i < vanillaRecipes.size(); i++) {
			if (vanillaRecipes.get(i) != null)
				addRecipe(vanillaRecipes.get(i), Blocks.crafting_table);
		}
	}
	
	public static void appendVanillaRecipe(Recipe vanillaRecipe) {
		addRecipe(vanillaRecipe, Blocks.crafting_table);
	}

	public static ArrayList<IMachineRecipe> FindRecipeForOutput(ItemStack stack) {
		ArrayList<IMachineRecipe> list = new ArrayList<IMachineRecipe>();
		if (stack != null) {
			Iterator<Entry<IMachineRecipe, Block>> iterator = recipes.entrySet().iterator();
			while (iterator.hasNext()) {
				IMachineRecipe recipe = iterator.next().getKey();
				RecipeOutputSlot[] outputs = recipe.getOutputs();
				for (int i = 0; i < outputs.length; i++) {
					if (outputs[i].getItem().equals(stack.getItem())) {
						list.add(recipe);
					}
				}
			}
		}
		return list;
	}

	public static ArrayList<IMachineRecipe> FindRecipeForOutput(ItemStack stack, int damage) {
		ArrayList<IMachineRecipe> list = new ArrayList<IMachineRecipe>();
		if (stack != null) {
			Iterator<Entry<IMachineRecipe, Block>> iterator = recipes.entrySet().iterator();
			while (iterator.hasNext()) {
				IMachineRecipe recipe = iterator.next().getKey();
				RecipeOutputSlot[] outputs = recipe.getOutputs();
				for (int i = 0; i < outputs.length; i++) {
					if (outputs[i].getItem().equals(stack.getItem()) && outputs[i].damage == damage) {
						list.add(recipe);
					}
				}
			}
		}
		return list;
	}

	public static ArrayList<IMachineRecipe> FindRecipeForInput(ItemStack stack) {
		ArrayList<IMachineRecipe> list = new ArrayList<IMachineRecipe>();
		if (stack != null) {
			Iterator<Entry<IMachineRecipe, Block>> iterator = recipes.entrySet().iterator();
			while (iterator.hasNext()) {
				IMachineRecipe recipe = iterator.next().getKey();
				RecipeInputSlot[] inputs = recipe.getInputs();
				for (int i = 0; i < inputs.length; i++) {
					if (inputs[i].getItem().equals(stack.getItem())) {
						list.add(recipe);
					}
				}
			}
		}
		return list;
	}

	public static ArrayList<IMachineRecipe> FindRecipeForInput(ItemStack stack, int damage) {
		ArrayList<IMachineRecipe> list = new ArrayList<IMachineRecipe>();
		if (stack != null) {
			Iterator<Entry<IMachineRecipe, Block>> iterator = recipes.entrySet().iterator();
			while (iterator.hasNext()) {
				IMachineRecipe recipe = iterator.next().getKey();
				RecipeInputSlot[] inputs = recipe.getInputs();
				RecipeOutputSlot[] outputs = recipe.getOutputs();
				for (int i = 0; i < recipe.getInputs().length; i++) {
					if (inputs[i].getItem().equals(stack.getItem()) && outputs[i].damage == damage) {
						list.add(recipe);
					}
				}
			}
		}
		return list;
	}

	public static Block getBlockForRecipe(IMachineRecipe recipe) {
		return recipes.get(recipe);
	}

	public static ArrayList<IMachineRecipe> getRecipesForMachine(Block block) {
		ArrayList<IMachineRecipe> list = new ArrayList<IMachineRecipe>();
		Iterator<Entry<IMachineRecipe, Block>> iterator = recipes.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<IMachineRecipe, Block> set = iterator.next();
			if (set.getValue().getClass() == block.getClass()) {
				list.add(set.getKey());
			}
		}
		return list;
	}
}

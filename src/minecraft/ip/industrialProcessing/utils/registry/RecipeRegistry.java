package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.IMachineRecipes;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.block.Block;
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
                addRecipe(vanillaRecipes.get(i), Block.workbench);
        }
    }

    public static void appendVanillaRecipe(Recipe vanillaRecipe) {
        addRecipe(vanillaRecipe, Block.workbench);
    }

    public static ArrayList<IMachineRecipe> FindRecipeForOutput(ItemStack stack) {
        ArrayList<IMachineRecipe> list = new ArrayList<IMachineRecipe>();
        if (stack != null) {
            Iterator<Entry<IMachineRecipe, Block>> iterator = recipes.entrySet().iterator();
            while (iterator.hasNext()) {
                IMachineRecipe recipe = iterator.next().getKey();
                RecipeOutputSlot[] outputs = recipe.getOutputs();
                for (int i = 0; i < outputs.length; i++) {
                    if (outputs[i].itemId == stack.itemID) {
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
                    if (outputs[i].itemId == stack.itemID && outputs[i].damage == damage) {
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
                if (recipe != null) {
                    RecipeInputSlot[] inputs = recipe.getInputs();
                    for (int i = 0; i < inputs.length; i++) {
                        RecipeInputSlot input = inputs[i];
                        if (input != null) {
                            if (input.itemId == stack.itemID) {
                                list.add(recipe);
                            }
                        }
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
                    if (inputs[i].itemId == stack.itemID && outputs[i].damage == damage) {
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

package ip.industrialProcessing.gui3.guide.pages.techtree;

import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import ip.industrialProcessing.utils.registry.RecipeRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ResourceChain {

    Tree<ItemStack> tree = new Tree<ItemStack>();
    private HashSet<Integer> visitedIds = new HashSet<Integer>();
    private TreeNode<ItemStack> root;

    public ResourceChain(ItemStack resource) {
        if(resource == null)
            throw new NullPointerException();
        this.root = new TreeNode<ItemStack>(tree, resource);

        populateMachines(root);
    }

    private void populateMachines(TreeNode<ItemStack> parent) {
        ItemStack resource = parent.getItem();
        visitedIds.add(resource.itemID);
        ArrayList<IMachineRecipe> recipes = RecipeRegistry.FindRecipeForInput(resource);
        HashMap<Block, TreeNode<ItemStack>> map = new HashMap<Block, TreeNode<ItemStack>>();
        for (Iterator iterator = recipes.iterator(); iterator.hasNext();) {
            IMachineRecipe iMachineRecipe = (IMachineRecipe) iterator.next();
            Block machine = RecipeRegistry.getBlockForRecipe(iMachineRecipe);
            TreeNode<ItemStack> node = map.get(machine);
            if (node == null) {
                node = parent.addChild(new ItemStack(machine));
                map.put(machine, node);
            }
            RecipeOutputSlot[] outputs = iMachineRecipe.getOutputs();
            if (outputs != null && outputs.length > 0) {
                for (int i = 0; i < outputs.length; i++) {
                    RecipeOutputSlot output = outputs[i];
                    ItemStack outputResource = getStack(output);
                    if(outputResource != null)
                    {
                        TreeNode<ItemStack> subResource = node.addChild(outputResource);
                        if(i == 0 && !visitedIds.contains(outputResource.itemID))
                            populateMachines(subResource);
                    }
                }
            }
        }
    }

    private ItemStack getStack(RecipeOutputSlot output) {
        if (output.type != RecipeSlotType.TANK)
            return getItem(output);
        else
            return getFluid(output);
    }

    private ItemStack getFluid(RecipeOutputSlot output) {
        Fluid fluid = FluidRegistry.getFluid(output.itemId);
        if (fluid != null) {
            return new ItemStack(fluid.getBlockID(), 0, 1);
        }
        return null;
    }

    private ItemStack getItem(RecipeOutputSlot output) {
        return new ItemStack(output.itemId, output.damage, 1);
    }

    public TreeNode<ItemStack> getRoot() {
        return this.root;
    }
}

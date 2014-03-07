package ip.industrialProcessing.gui3.guide.pages.techtree;

import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.utils.registry.RecipeRegistry;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class TechChain {

    private Tree<ItemStack> tree = new Tree<ItemStack>();
    private TreeNode<ItemStack> root;

    public TreeNode<ItemStack> getRoot() {
        return root;
    }

    public TechChain(ItemStack root) {
        if (root != null)
            getParentMachine(this.root = tree.getNode(root));
        else
            this.root = null;
    }

    private void getParentMachine(TreeNode<ItemStack> root) {

        ArrayList<IMachineRecipe> recipes = RecipeRegistry.FindRecipeForOutput(root.getItem());

        for (IMachineRecipe recipe : recipes) {
            Block block = RecipeRegistry.getBlockForRecipe(recipe);
            if (block != null) {
                TreeNode<ItemStack> node = root.addParent(new ItemStack(block));
                getParentMachine(node);
            } else
                System.out.println("TechChain.getParentMachine() found a recipe without associated block?");
        }
    }
}

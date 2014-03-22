package mod.industrialProcessing.gui.guide.pages.techtree;

import java.util.ArrayList;

import mod.industrialProcessing.utils.registry.RecipeRegistry;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class TechChain {

    private Tree<Block> tree = new Tree<Block>();
    private TreeNode<Block> root;

    public TreeNode<Block> getRoot() {
        return root;
    }

    public TechChain(Block root) {
        if (root != null)
            getParentMachine(this.root = tree.getNode(root));
        else
            this.root = null;
    }

    private void getParentMachine(TreeNode<Block> root) {

        ArrayList<IMachineRecipe> recipes = RecipeRegistry.FindRecipeForOutput(new ItemStack(root.getItem()));

        for (IMachineRecipe recipe : recipes) {
            Block block = RecipeRegistry.getBlockForRecipe(recipe);
            if (block != null) {
                TreeNode<Block> node = root.addParent(block);
                getParentMachine(node);
            } else
                System.out.println("TechChain.getParentMachine() found a recipe without associated block?");
        }
    }
}

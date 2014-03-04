package mod.industrialProcessing.gui.guide.pages.techtree;

import java.util.HashMap;

public class Tree<T extends Object> {
    private HashMap<T, TreeNode<T>> map = new HashMap<T, TreeNode<T>>();

    public TreeNode<T> getNode(T item) {
        TreeNode<T> node = this.map.get(item);
        if (node == null) {
            node = new TreeNode(this, item);
            this.map.put(item, node);
        }
        return node;
    }

    public TreeNode<T> addItem(T item) {
        TreeNode<T> node = getNode(item);
        return node;
    }

    public void removeItem(T item) {
        TreeNode<T> node = getNode(item);
        node.unlink();
        this.map.remove(item);
    }
}

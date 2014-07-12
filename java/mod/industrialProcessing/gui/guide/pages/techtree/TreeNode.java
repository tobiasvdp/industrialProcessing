package mod.industrialProcessing.gui.guide.pages.techtree;

import java.util.HashSet;
import java.util.Iterator;

public class TreeNode<T extends Object> {
    private Tree<T> tree;
    private T item;

    public T getItem() {
        return item;
    }

    TreeNode(Tree<T> tree, T item) {
        this.tree = tree;
        this.item = item;
    }

    private HashSet<TreeNode<T>> parents = new HashSet<TreeNode<T>>();
    private HashSet<TreeNode<T>> children = new HashSet<TreeNode<T>>();

    public Iterator<TreeNode<T>> listParents() {
        return parents.iterator();
    }
    public Iterator<TreeNode<T>> listChildren() {
        return children.iterator();
    }

    public TreeNode<T> addChild(T item) {
        TreeNode<T> node = this.tree.getNode(item);
        linkChild(node);
        return node;
    }

    public TreeNode<T> addParent(T item) {
        TreeNode<T> node = this.tree.getNode(item);
        linkParent(node);
        return node;
    }

    public void linkParent(TreeNode<T> node) {
        node.children.add(this);
        this.parents.add(node);
    }

    public void linkChild(TreeNode<T> node) {
        node.parents.remove(this);
        this.children.add(node);
    }

    public void unlinkParent(TreeNode<T> node) {
        node.children.remove(this);
        this.parents.remove(node);
    }

    public void unlinkChild(TreeNode<T> node) {
        node.parents.remove(this);
        this.children.remove(node);
    }

    public void unlink() {
        for (TreeNode<T> treeNode : parents) {
            treeNode.unlinkChild(this);
        }
        for (TreeNode<T> treeNode : children) {
            treeNode.unlinkParent(this);
        }
    }
}

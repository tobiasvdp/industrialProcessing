package ip.industrialProcessing.gui3.guide.pages.techtree;

import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.canvas.CanvasChild;
import ip.industrialProcessing.gui3.framework.panels.canvas.CanvasPanel;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.guide.pages.machines.TreeConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class TechChainControl extends UserControl {
    private ScrollPanel scrollPanel;
    private CanvasPanel canvas;

    private ArrayList<TreeConnection> connections = new ArrayList<TreeConnection>();
    private ArrayList<CanvasChild> children = new ArrayList<CanvasChild>();
    private HashMap<TreeNode<Block>, CanvasChild> map = new HashMap<TreeNode<Block>, CanvasChild>();
    private boolean followParents = true;
    private boolean followChildren = false;
    private IButtonClickListener<ItemStack> stackClickListener;

    public TechChainControl(IButtonClickListener<ItemStack> stackClickListener) {
        this.verticalAlign = Alignment.STRETCH;
        this.horizontalAlign = Alignment.STRETCH;
        this.canvas = new CanvasPanel();
        this.child = this.canvas;
        this.width = Float.NaN;
        this.height = Float.NaN;
        this.stackClickListener = stackClickListener;
    }

    public void setChain(TechChain techChain) {
  
        this.map.clear();
        this.connections.clear();

        TreeNode<Block> root = techChain.getRoot();

        CanvasChild child = map.get(root);
        if (child == null) {
            child = createChild(root.getItem(), 0, 0);
            map.put(root, child);
        }
        children.add(child);

        addConnections(root);
        this.canvas.children = children;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
        super.renderOverride(size, renderer);
        for (TreeConnection treeConnection : connections) {
            CanvasChild a = treeConnection.a;
            CanvasChild b = treeConnection.b;
            renderer.drawLine(new Size(a.left + 9, a.top + 9), new Size(b.left + 9, b.top + 9), 10f, 0xff000000);
        }
    }

    private void addConnections(TreeNode<Block> root) {
        int i = 0;
        if (followParents) {
            Iterator<TreeNode<Block>> parents = root.listParents();
            while (parents.hasNext()) {
                TreeNode<Block> block = parents.next();
                addConnection(block, root, i++, 1);
            }
        }
        if (followChildren) {
            Iterator<TreeNode<Block>> children = root.listChildren();
            while (children.hasNext()) {
                TreeNode<Block> block = children.next();
                addConnection(block, root, i++, -1);
            }
        }
    }

    private void addConnection(TreeNode<Block> parent, TreeNode<Block> root, int li, int dl) {
        if (parent != root) {
            CanvasChild canvasChild = map.get(parent);
            CanvasChild rootCanvasChild = map.get(root);
            if (canvasChild == null) {
                canvasChild = createChild(parent.getItem(), rootCanvasChild.left + 18 * li * 1.5f, rootCanvasChild.top + 18 * dl * 1.5f);
                map.put(parent, canvasChild);
                addConnections(parent);
            }
            children.add(canvasChild);
            this.connections.add(new TreeConnection(rootCanvasChild, canvasChild));
        }
    }

    private CanvasChild createChild(Block item, float x, float y) {
        CanvasChild child = new CanvasChild();
        UIElement control = SlotItemControl.createButtonSlot(new ItemStack(item, 1), stackClickListener);
        child.content = control;
        child.left = x;
        child.top = y;
        return child;
    }
}

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

public class TreeControl extends UserControl {
    private ScrollPanel scrollPanel;
    private CanvasPanel canvas;

    private ArrayList<TreeConnection> connections = new ArrayList<TreeConnection>();
    private ArrayList<CanvasChild> children = new ArrayList<CanvasChild>();
    private HashMap<TreeNode<ItemStack>, CanvasChild> map = new HashMap<TreeNode<ItemStack>, CanvasChild>();
    public boolean followParents = true;
    private IButtonClickListener<ItemStack> stackClickListener;
    private ArrayList<Integer> rowSizes = new ArrayList<Integer>();

    public TreeControl(IButtonClickListener<ItemStack> stackClickListener) {
        this.verticalAlign = Alignment.STRETCH;
        this.horizontalAlign = Alignment.STRETCH;
        this.canvas = new CanvasPanel();
        this.child = this.canvas;
        this.width = Float.NaN;
        this.height = Float.NaN;
        this.stackClickListener = stackClickListener;
    }

    public void setChain(TreeNode<ItemStack> treeRoot) {

        this.map.clear();
        this.connections.clear();
        this.children.clear();
        this.rowSizes.clear(); 

        addNode(treeRoot, null, 0); 
        this.canvas.children = children;
        
    }

    private void addNode(TreeNode<ItemStack> root, CanvasChild connectedNode, int row) {
        for (int i = rowSizes.size(); i <= row; i++)
            rowSizes.add(0);
        CanvasChild canvasChild = map.get(root);
        if (canvasChild == null) {
            int rowSize = rowSizes.get(row);
            rowSizes.set(row, rowSize + 1);
            canvasChild = createChild(root.getItem(), 18 * rowSize * 1.5f, 18 * row * 1.5f);
            map.put(root, canvasChild);
            children.add(canvasChild);
        }
        if (connectedNode != null) {
            this.connections.add(new TreeConnection(connectedNode, canvasChild));
        }
        int i = 0;
        Iterator<TreeNode<ItemStack>> parents = followParents ? root.listParents() : root.listChildren();
        row++;
        while (parents.hasNext()) {
            TreeNode<ItemStack> block = parents.next();
            addNode(block, canvasChild, row);
        }
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
        super.renderOverride(size, renderer);
        for (TreeConnection treeConnection : connections) {
            CanvasChild a = treeConnection.a;
            CanvasChild b = treeConnection.b;
            renderer.drawLine(new Size(a.left + 9, a.top + 18), new Size(b.left + 9, b.top ), 10f, 0xff000000);
        }
    }

    private CanvasChild createChild(ItemStack item, float x, float y) {
        CanvasChild child = new CanvasChild();
        UIElement control = SlotItemControl.createButtonSlot(item, stackClickListener);
        child.content = control;
        child.left = x;
        child.top = y;
        return child;
    }
}

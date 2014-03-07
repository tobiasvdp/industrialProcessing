package ip.industrialProcessing.gui3.guide.pages.machines;

import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.canvas.CanvasChild;
import ip.industrialProcessing.gui3.framework.panels.canvas.CanvasPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.guide.pages.techtree.TechChain;
import ip.industrialProcessing.gui3.guide.pages.techtree.TreeControl;
import ip.industrialProcessing.gui3.guide.pages.techtree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MachineTechChainTab extends TabPage {

    private TreeControl techTree;

    public MachineTechChainTab(IButtonClickListener<ItemStack> stackClickListener) {
        this.techTree = new TreeControl(stackClickListener);
        this.content = techTree;
        this.header = TextBlock.createText("Chain");
        this.activeHeader = TextBlock.createText("Chain", 0xffffffff);
        this.header.margin = this.activeHeader.margin = new Thickness(0, 5, 0, 0);
        
    }

    public void setBlock(Block block) {
        TechChain chain = new TechChain(new ItemStack(block));
        this.techTree.setChain(chain.getRoot());
    }

}

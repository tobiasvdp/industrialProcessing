package mod.industrialProcessing.gui.guide.pages.machines;

import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.guide.pages.techtree.TechChain;
import ip.industrialProcessing.gui3.guide.pages.techtree.TechChainControl;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MachineTechChainTab extends TabPage {

    private TechChainControl techTree;

    public MachineTechChainTab(IButtonClickListener<ItemStack> stackClickListener) {
        this.techTree = new TechChainControl(stackClickListener);
        this.content = techTree;
        this.header = TextBlock.createText("Chain");
        this.activeHeader = TextBlock.createText("Chain", 0xffffffff);
        this.header.margin = this.activeHeader.margin = new Thickness(0, 5, 0, 0);
        
    }

    public void setBlock(Block block) {
        this.techTree.setChain(new TechChain(block));
    }

}

package mod.industrialProcessing.gui.guide.pages.machines;

import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.panels.tabs.TabPage;
import mod.industrialProcessing.gui.guide.pages.techtree.TechChain;
import mod.industrialProcessing.gui.guide.pages.techtree.TechChainControl;
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

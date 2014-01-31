package ip.industrialProcessing.gui3.guide.pages.machines;

import net.minecraft.block.Block;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.WrapPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;

public class MachineCraftTab extends TabPage {
    private WrapPanel wrapPanel;
    private UserControl recipeDock;

    public MachineCraftTab(){
	this.header = TextBlock.createText("Craft");
	this.activeHeader = TextBlock.createText("Craft", 0xffffffff);
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.VERTICAL;
	this.wrapPanel = new WrapPanel();
	ScrollPanel scroll = new ScrollPanel();
	scroll.allowHorizontalScroll = false;
	scroll.allowVerticalScroll = true;
	scroll.maxHeight = 18 * 2 + 2;
	scroll.minHeight = 18 * 2 + 2; 
	scroll.content = wrapPanel;
	stack.addChild(scroll);
	this.recipeDock = new UserControl();
	this.recipeDock.width = this.recipeDock.height = Float.NaN;
	this.recipeDock.margin = new Thickness(7, 0, 0, 0);
	stack.addChild(recipeDock);
	this.content = stack;
    }

    public void setBlock(Block tag) {
	// TODO Auto-generated method stub
	
    }
}

package ip.industrialProcessing.gui3.guide.pages;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ToolsTab extends TabPage {
    public ToolsTab() {
	Decorator headerDecorator = Decorator.createTabDecorator(false);
	headerDecorator.setChild(TextBlock.createText("Tools"));
	this.header = headerDecorator;

	Decorator activeHeaderDecorator = Decorator.createTabDecorator(true);
	activeHeaderDecorator.setChild(TextBlock.createText("Tools"));
	this.activeHeader = activeHeaderDecorator;

	Decorator decorator = Decorator.createDecorator();
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.VERTICAL;

	ScrollPanel scrollPanel = new ScrollPanel();
	scrollPanel.content = stack;
	scrollPanel.allowHorizontalScroll = false;
	scrollPanel.maxWidth = 106;
	Item[] tools = new Item[] { IndustrialProcessing.itemWrench, IndustrialProcessing.itemHexKey, IndustrialProcessing.itemSolderingIron, IndustrialProcessing.itemBlowingTorch, IndustrialProcessing.itemDrawPlate };
	for (int i = 0; i < tools.length; i++) {
	    StackPanel toolStack = new StackPanel();
	    toolStack.orientation = Orientation.HORIZONTAL;
	    ItemStack itemStack = new ItemStack(tools[i]);
	    SlotItemControl slot = SlotItemControl.createItemstack(itemStack);
	    toolStack.addChild(slot);
	    TextBlock title = TextBlock.createText(itemStack.getDisplayName(), 0xffffffff);
	    title.margin = new Thickness(0, 0, 0, 5);
	    title.verticalAlign = Alignment.CENTER;
	    toolStack.addChild(title);
	    stack.addChild(new Button(toolStack));
	}
	decorator.setChild(scrollPanel);
	this.content = decorator;
    }
}

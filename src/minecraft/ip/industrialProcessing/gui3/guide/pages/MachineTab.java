package ip.industrialProcessing.gui3.guide.pages;

import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.guide.pages.machines.MachineList;

public class MachineTab extends TabPage {

    public MachineTab() {

	Decorator headerDecorator = Decorator.createTabDecorator(false);
	headerDecorator.setChild(TextBlock.createText("Machines"));
	this.header = headerDecorator;

	Decorator activeHeaderDecorator = Decorator.createTabDecorator(true);
	activeHeaderDecorator.setChild(TextBlock.createText("Machines"));
	this.activeHeader = activeHeaderDecorator;

	Decorator decorator = Decorator.createDecorator();

	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.HORIZONTAL;

	ScrollPanel scrollPanel = new ScrollPanel();
	scrollPanel.content = new MachineList(); 
	scrollPanel.maxWidth = 18 * 5 + 16;
	scrollPanel.minWidth = 18 * 5 + 16;
	stack.addChild(scrollPanel);

	decorator.setChild(stack);
	this.content = decorator;
    }

}

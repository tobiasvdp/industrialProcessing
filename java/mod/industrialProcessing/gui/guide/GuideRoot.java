package mod.industrialProcessing.gui.guide;

import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.tabs.TabPanel;
import mod.industrialProcessing.gui.guide.pages.MachineTab;
import mod.industrialProcessing.gui.guide.pages.ToolsTab;

public class GuideRoot extends UserControl {
    private TabPanel tabs;

    public GuideRoot() {
	
	this.isHittestVisible = true;
	tabs = new TabPanel();
	tabs.addTab(new MachineTab());
	tabs.addTab(new ToolsTab());
	this.width = 300;
	this.height = 230;
	this.horizontalAlign = Alignment.CENTER;
	this.verticalAlign = Alignment.CENTER;
	this.child = tabs;
    }
}

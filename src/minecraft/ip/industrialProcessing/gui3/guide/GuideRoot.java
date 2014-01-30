package ip.industrialProcessing.gui3.guide;

import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPanel;
import ip.industrialProcessing.gui3.guide.pages.MachineTab;
import ip.industrialProcessing.gui3.guide.pages.ToolsTab;

public class GuideRoot extends UserControl {
    private TabPanel tabs;

    public GuideRoot() {
	
	this.isHittestVisible = true;
	tabs = new TabPanel();
	tabs.addTab(new MachineTab());
	tabs.addTab(new ToolsTab());
	this.width = 300;
	this.height = 200;
	this.horizontalAlign = Alignment.CENTER;
	this.verticalAlign = Alignment.CENTER;
	this.child = tabs;
    }
}

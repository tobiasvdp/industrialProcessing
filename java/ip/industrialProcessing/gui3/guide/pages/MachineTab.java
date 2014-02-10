package ip.industrialProcessing.gui3.guide.pages;

import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.DockPanel;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.guide.pages.machines.MachineDetails;
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

        DockPanel dock = new DockPanel();
        dock.orientation = Orientation.HORIZONTAL;

        MachineDetails detailPage = new MachineDetails();
        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.content = new MachineList(detailPage);
        scrollPanel.maxWidth = 18 * 5 + 16;
        scrollPanel.minWidth = 18 * 5 + 16;
        dock.docked = scrollPanel;
        dock.content = detailPage;

        decorator.setChild(dock);
        this.content = decorator;
    }

}

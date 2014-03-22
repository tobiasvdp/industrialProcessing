package mod.industrialProcessing.gui.guide.pages;

import mod.industrialProcessing.gui.framework.controls.Decorator;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.panels.DockPanel;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.ScrollPanel;
import mod.industrialProcessing.gui.framework.panels.tabs.TabPage;
import mod.industrialProcessing.gui.guide.pages.machines.MachineDetails;
import mod.industrialProcessing.gui.guide.pages.machines.MachineList;

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

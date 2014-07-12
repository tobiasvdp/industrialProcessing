package mod.industrialProcessing.gui.guide.pages;

import mod.industrialProcessing.gui.framework.controls.Decorator;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.panels.DockPanel;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.ScrollPanel;
import mod.industrialProcessing.gui.framework.panels.tabs.TabPage;
import mod.industrialProcessing.gui.guide.pages.machines.MachineDetails;
import mod.industrialProcessing.gui.guide.pages.tools.ToolsList;

public class ToolsTab extends TabPage {
    public ToolsTab() {

        Decorator headerDecorator = Decorator.createTabDecorator(false);
        headerDecorator.setChild(TextBlock.createText("Tools"));
        this.header = headerDecorator;

        Decorator activeHeaderDecorator = Decorator.createTabDecorator(true);
        activeHeaderDecorator.setChild(TextBlock.createText("Tools"));
        this.activeHeader = activeHeaderDecorator;

        Decorator decorator = Decorator.createDecorator();

        DockPanel dock = new DockPanel();
        dock.orientation = Orientation.HORIZONTAL;

        MachineDetails detailPage = new MachineDetails();
        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.content = new ToolsList(detailPage);
        scrollPanel.maxWidth = 18 * 5 + 16;
        scrollPanel.minWidth = 18 * 5 + 16;
        dock.docked = scrollPanel;
        dock.content = detailPage;

        decorator.setChild(dock);
        this.content = decorator;
    }
}

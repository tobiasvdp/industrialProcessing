package ip.industrialProcessing.gui3.guide.pages;

import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.DockPanel;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.guide.pages.machines.MachineDetails;
import ip.industrialProcessing.gui3.guide.pages.resources.ResourceDetails;
import ip.industrialProcessing.gui3.guide.pages.resources.ResourceList;

public class ResourceTab extends TabPage {
    public ResourceTab() {

        Decorator headerDecorator = Decorator.createTabDecorator(false);
        headerDecorator.setChild(TextBlock.createText("IP.Guide.Resources"));
        this.header = headerDecorator;

        Decorator activeHeaderDecorator = Decorator.createTabDecorator(true);
        activeHeaderDecorator.setChild(TextBlock.createText("IP.Guide.Resources"));
        this.activeHeader = activeHeaderDecorator;

        Decorator decorator = Decorator.createDecorator();

        DockPanel dock = new DockPanel();
        dock.orientation = Orientation.HORIZONTAL;

        ResourceDetails detailPage = new ResourceDetails();
        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.content = new ResourceList(detailPage);
        scrollPanel.maxWidth = 18 * 5 + 16;
        scrollPanel.minWidth = 18 * 5 + 16;
        dock.docked = scrollPanel;
        dock.content = detailPage;

        decorator.setChild(dock);
        this.content = decorator;
    }
}

package ip.industrialProcessing.gui3.guide.pages;

import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.DockPanel;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.guide.pages.machines.MachineDetails;
import ip.industrialProcessing.gui3.guide.pages.machines.MachineList;
import ip.industrialProcessing.gui3.guide.pages.tools.ToolsList;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;

import java.util.Iterator;

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

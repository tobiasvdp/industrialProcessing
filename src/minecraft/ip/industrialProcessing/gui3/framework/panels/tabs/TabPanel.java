package ip.industrialProcessing.gui3.framework.panels.tabs;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

import java.util.ArrayList;

public class TabPanel extends UIElement {

    private ArrayList<TabPage> tabs = new ArrayList<TabPage>();
    private TabPage activeTab;
    private Size headerSize;

    public void addTab(TabPage tab) {
	this.tabs.add(tab);
	if (activeTab == null)
	    activeTab = tab;
    }

    public void removeTab(TabPage tab) {
	this.tabs.remove(tab);
	if (activeTab == tab) {
	    if (tabs.isEmpty())
		activeTab = null;
	    else
		activeTab = tabs.get(0);
	}
    }

    public TabPanel() {
	this.isHittestVisible = true;
    }

    @Override
    protected Size measureOverride(Size maxSize) {
	Size headerSize = measureHeaders(maxSize);
	this.headerSize = headerSize;
	Size contentSize = new Size(maxSize.width, maxSize.height - headerSize.height);
	contentSize = measureContent(contentSize);
	return new Size(Math.max(contentSize.width, headerSize.width), headerSize.height + contentSize.height);
    }

    private Size measureContent(Size contentSize) {
	if (activeTab != null && activeTab.content != null)
	    return activeTab.content.measure(contentSize);
	return new Size(0, 0);
    }

    private Size measureHeaders(Size maxSize) {
	float left = 3;
	float height = 0;
	for (TabPage tabPage : tabs) {
	    UIElement header = tabPage == activeTab ? tabPage.activeHeader : tabPage.header;
	    if (header != null) {
		Size size = header.measure(new Size(maxSize.width - left, maxSize.height));
		left += size.width;
		if (size.height > height)
		    height = size.height;
	    }
	}
	return new Size(left + 3, height);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	float left = 3;
	for (TabPage tabPage : tabs) {
	    UIElement header = tabPage == activeTab ? tabPage.activeHeader : tabPage.header;
	    if (header != null) {
		Size size = header.getDesiredSize();
		header.arrange(new Rect(left, 0, size.width, headerSize.height));
		left += size.width;
	    }
	}
	if (activeTab != null && activeTab.content != null) {
	    activeTab.content.arrange(new Rect(0, headerSize.height, maxSize.width, maxSize.height - headerSize.height));
	}
	return maxSize;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	for (TabPage tabPage : tabs) {
	    if (tabPage != activeTab) {
		if (tabPage.header != null) {
		    Rect where = new Rect(tabPage.header.getX(), tabPage.header.getY(), tabPage.header.getActualSize());
		    tabPage.header.render(renderer);
		}
	    }
	}
	if (activeTab != null && activeTab.content != null) {
	    activeTab.content.render(renderer);
	    if (activeTab.activeHeader != null)
		activeTab.activeHeader.render(renderer);
	}

    }

    @Override
    protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
	for (TabPage tabPage : tabs) {
	    if (tabPage.header != null) {
		tabPage.header.mouseUp(mouseX, mouseY, button);
		if (tabPage.header.contains(mouseX, mouseY) && tabPage.mouseInHeaderDown) {
		    activeTab = tabPage;
		}
	    }
	}
	if (activeTab != null && activeTab.content != null) {
	    activeTab.content.mouseUp(mouseX, mouseY, button);
	}
    }

    @Override
    protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
	for (TabPage tabPage : tabs) {
	    if (tabPage.header != null) {
		tabPage.header.mouseDown(mouseX, mouseY, button);
		if (tabPage.header.contains(mouseX, mouseY))
		    tabPage.mouseInHeaderDown = true;
	    }
	}
	if (activeTab != null && activeTab.content != null) {
	    activeTab.content.mouseDown(mouseX, mouseY, button);
	}
    }

    @Override
    protected void mouseLeftOverride(float mouseX, float mouseY) {
	for (TabPage tabPage : tabs) {
	    if (tabPage.header != null) {
		tabPage.header.mouseLeft(mouseX, mouseY);
	    }
	    tabPage.mouseInHeaderDown = false;
	}
	if (activeTab != null && activeTab.content != null) {
	    activeTab.content.mouseLeft(mouseX, mouseY);
	}
    }

    @Override
    protected void mouseEnteredOverride(float mouseX, float mouseY) {
	for (TabPage tabPage : tabs) {
	    if (tabPage.header != null) {
		tabPage.header.mouseEntered(mouseX, mouseY);
	    }
	}
	if (activeTab != null && activeTab.content != null) {
	    activeTab.content.mouseEntered(mouseX, mouseY);
	}
    }

    @Override
    protected void mouseMovedOverride(float mouseX, float mouseY) {
	for (TabPage tabPage : tabs) {
	    if (tabPage.header != null) {
		tabPage.header.mouseMoved(mouseX, mouseY);
		if (!tabPage.header.contains(mouseX, mouseY))
		    tabPage.mouseInHeaderDown = false;
	    }
	}
	if (activeTab != null && activeTab.content != null) {
	    activeTab.content.mouseMoved(mouseX, mouseY);
	}
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	for (TabPage tabPage : tabs) {
	    if (tabPage.header != null) {
		ToolTip toolTip = tabPage.header.getTooltip(mouseX, mouseY);
		if (toolTip != null)
		    return toolTip;
	    }
	}
	if (activeTab != null && activeTab.content != null) {
	    ToolTip toolTip = activeTab.content.getTooltip(mouseX, mouseY);
	    if (toolTip != null)
		return toolTip;
	}
	return null;
    }

    public void clear() {
	this.tabs.clear();
    }
}

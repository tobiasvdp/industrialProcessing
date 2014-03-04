package mod.industrialProcessing.gui.framework.panels.tabs;

import ip.industrialProcessing.gui3.framework.UIElement;

public class TabPage {
    public TabPage(UIElement header, UIElement activeHeader, UIElement content) {
	this.header = header;
	this.activeHeader = activeHeader;
	this.content = content;
    }

    protected TabPage() {
    }

    public UIElement header;
    public UIElement activeHeader;
    public UIElement content;
    boolean mouseInHeaderDown;
}

package ip.industrialProcessing.gui3.framework.panels;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

import java.util.ArrayList;
import java.util.List;

public abstract class Panel extends UIElement {

    public Panel() {
	this.isHittestVisible = true;
    }

    private ArrayList<UIElement> children = new ArrayList<UIElement>();

    protected List<UIElement> getChildren() {
	return this.children;
    }

    public void addChild(UIElement child) {
	children.add(child);
    }

    public void clear() {
	this.children.clear();
    }

    public boolean removeChild(UIElement child) {
	return children.remove(child);
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	for (UIElement child : children) {
	    child.render(renderer);
	}
    }

    @Override
    protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
	for (UIElement child : children) {
	    if (child != null)
		child.mouseDown(mouseX, mouseY, button);
	}
    }

    @Override
    protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
	for (UIElement child : children) {
	    if (child != null)
		child.mouseUp(mouseX, mouseY, button);
	}
    }

    @Override
    protected void mouseMovedOverride(float mouseX, float mouseY) {
	for (UIElement child : children) {
	    if (child != null)
		child.mouseMoved(mouseX, mouseY);
	}
    }

    @Override
    protected void mouseLeftOverride(float mouseX, float mouseY) {
	for (UIElement child : children) {
	    if (child != null)
		child.mouseLeft(mouseX, mouseY);
	}
    }

    @Override
    protected void mouseEnteredOverride(float mouseX, float mouseY) {
	for (UIElement child : children) {
	    if (child != null)
		child.mouseEntered(mouseX, mouseY);
	}
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	for (UIElement child : getChildren()) {
	    ToolTip tooltip = child.getTooltip(mouseX, mouseY);
	    if (tooltip != null)
		return tooltip;
	}
	return null;
    }
}

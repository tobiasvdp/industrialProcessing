package ip.industrialProcessing.gui3.framework.panels;

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
    public void mouseDown(float x, float y, MouseButton button) {
	for (UIElement child : children) {
	    if (child.hitTest()) {
		child.mouseDown(x - child.getX(), y - child.getY(), button);
	    }
	}
    }

    @Override
    public void mouseUp(float x, float y, MouseButton button) {
	for (UIElement child : children) {
	    if (child.hitTest()) {
		child.mouseUp(x - child.getX(), y - child.getY(), button);
	    }
	}
    }

    @Override
    public void mouseMouseMove(float x, float y) {
	for (UIElement child : children) {
	    if (child.hitTest()) {
		child.mouseMouseMove(x - child.getX(), y - child.getY());
	    }
	}
    }

    @Override
    public void mouseEntered(float x, float y) {
	for (UIElement child : children) {
	    if (child.hitTest()) {
		child.setMouseInside(true, x, y);
	    } else
		child.setMouseInside(false, x, y);
	}
    }

    @Override
    public void mouseLeft(float x, float y) {
	for (UIElement child : children) {
	    child.setMouseInside(false, x, y);
	}
    }
}

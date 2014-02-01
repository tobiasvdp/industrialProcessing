package ip.industrialProcessing.gui3.framework.panels;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

public class DockPanel extends UIElement {

    public Orientation orientation = Orientation.HORIZONTAL;

    public UIElement docked;
    public UIElement content;

    public DockPanel() {
	this.isHittestVisible = true;
    }

    private Size measureElement(UIElement element, Size maxSize) {
	if (element == null)
	    return new Size(0, 0);

	return element.measure(maxSize);
    }

    @Override
    protected Size measureOverride(Size maxSize) {
	Size sizeA = measureElement(docked, maxSize);
	Size sizeB = orientation == Orientation.HORIZONTAL ? new Size(maxSize.width - sizeA.width, maxSize.height) : new Size(maxSize.width, maxSize.height - sizeA.height);
	sizeB = measureElement(content, sizeB);
	return orientation == Orientation.HORIZONTAL ? new Size(sizeB.width + sizeA.width, Math.max(sizeA.height, sizeB.height)) : new Size(Math.max(sizeA.width, sizeB.width), sizeB.height + sizeA.height);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	Size size = arrangeHeader(docked, maxSize);
	size = arrangeElement(content, size, maxSize);
	return size;
    }

    private Size arrangeElement(UIElement element, Size previous, Size maxSize) {
	if (element == null)
	    return previous;
	float maxWidth, maxHeight;
	float top = 0;
	float left = 0;
	Size size = element.getDesiredSize();
	switch (orientation) {
	case HORIZONTAL:
	    maxWidth = this.verticalAlign == horizontalAlign.STRETCH ? maxSize.width - previous.width : size.width;
	    maxHeight = this.verticalAlign == horizontalAlign.STRETCH ? maxSize.height : size.height;
	    left = previous.width;
	    break;
	case VERTICAL:
	default:
	    maxWidth = this.horizontalAlign == horizontalAlign.STRETCH ? maxSize.width : size.width;
	    maxHeight = this.verticalAlign == horizontalAlign.STRETCH ? maxSize.height - previous.height : size.height;
	    top = previous.height;
	    break;
	}
	element.arrange(new Rect(left, top, maxWidth, maxHeight));
	return new Size(Math.max(left + maxWidth, previous.width), Math.max(left + maxHeight, previous.height));
    }

    private Size arrangeHeader(UIElement header, Size maxSize) {
	if (header == null)
	    return new Size(0, 0);
	float maxWidth, maxHeight;
	Size size = header.getDesiredSize();
	switch (orientation) {
	case HORIZONTAL:
	    maxWidth = size.width;
	    maxHeight = this.verticalAlign == horizontalAlign.STRETCH ? maxSize.height : size.height;
	    break;
	case VERTICAL:
	default:
	    maxWidth = this.horizontalAlign == horizontalAlign.STRETCH ? maxSize.width : size.width;
	    maxHeight = size.height;
	    break;
	}
	header.arrange(new Rect(0, 0, maxWidth, maxHeight));
	return new Size(maxWidth, maxHeight);
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	if (this.docked != null) { 
	    this.docked.render(renderer);
	}
	if (this.content != null)
	    this.content.render(renderer);
    }

    @Override
    protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
	if (this.docked != null) {
	    this.docked.mouseUp(mouseX, mouseY, button);
	}
	if (this.content != null)
	    this.content.mouseUp(mouseX, mouseY, button);
    }

    @Override
    protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
	if (this.docked != null) {
	    this.docked.mouseDown(mouseX, mouseY, button);
	}
	if (this.content != null)
	    this.content.mouseDown(mouseX, mouseY, button);
    }

    @Override
    protected void mouseLeftOverride(float mouseX, float mouseY) {
	if (this.docked != null)
	    this.docked.mouseLeft(mouseX, mouseY);
	if (this.content != null)
	    this.content.mouseLeft(mouseX, mouseY);
    }

    @Override
    protected void mouseEnteredOverride(float mouseX, float mouseY) {
	if (this.docked != null)
	    this.docked.mouseEntered(mouseX, mouseY);
	if (this.content != null)
	    this.content.mouseEntered(mouseX, mouseY);
    }

    @Override
    protected void mouseMovedOverride(float mouseX, float mouseY) {
	if (this.docked != null) {
	    this.docked.mouseMoved(mouseX, mouseY);
	}
	if (this.content != null)
	    this.content.mouseMoved(mouseX, mouseY);
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	if (this.docked != null) {
	    ToolTip toolTip = this.docked.getTooltip(mouseX, mouseY);
	    if (toolTip != null)
		return toolTip;
	}

	if (this.content != null) {
	    ToolTip toolTip = this.content.getTooltip(mouseX, mouseY);
	    if (toolTip != null)
		return toolTip;
	}
	return null;
    }

}

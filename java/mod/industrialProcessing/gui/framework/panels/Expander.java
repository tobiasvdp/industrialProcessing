package mod.industrialProcessing.gui.framework.panels;

import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.controls.ToolTip;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;

public class Expander extends UIElement {

    public Orientation orientation = Orientation.HORIZONTAL;
    public UIElement header;
    public UIElement expandedHeader;
    public UIElement content;
    public boolean isExpanded;
    private boolean mouseInHeaderDown;

    public Expander() {
	this.isHittestVisible = true;
    }

    @Override
    protected Size measureOverride(Size maxSize) {
	if (this.isExpanded) {
	    Size sizeA = measureElement(expandedHeader, maxSize);
	    Size sizeB = orientation == Orientation.HORIZONTAL ? new Size(maxSize.width - sizeA.width, maxSize.height) : new Size(maxSize.width, maxSize.height - sizeA.height);
	    sizeB = measureElement(content, sizeB);
	    return orientation == Orientation.HORIZONTAL ? new Size(sizeB.width + sizeA.width, Math.max(sizeA.height, sizeB.height)) : new Size(Math.max(sizeA.width, sizeB.width), sizeB.height + sizeA.height);
	} else {
	    return measureElement(header, maxSize);
	}
    }

    private Size measureElement(UIElement element, Size maxSize) {
	if (element == null)
	    return new Size(0, 0);

	return element.measure(maxSize);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	if (isExpanded) {
	    Size size = arrangeHeader(expandedHeader, maxSize);
	    size = arrangeElement(content, size, maxSize);
	    return size;
	} else {
	    return arrangeHeader(header, maxSize);
	}
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
	    maxWidth = this.verticalAlign == Alignment.STRETCH ? maxSize.width - previous.width : size.width;
	    maxHeight = this.verticalAlign == Alignment.STRETCH ? maxSize.height : size.height;
	    left = previous.width;
	    break;
	case VERTICAL:
	default:
	    maxWidth = this.horizontalAlign == Alignment.STRETCH ? maxSize.width : size.width;
	    maxHeight = this.verticalAlign == Alignment.STRETCH ? maxSize.height - previous.height : size.height;
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
	    maxHeight = this.verticalAlign == Alignment.STRETCH ? maxSize.height : size.height;
	    break;
	case VERTICAL:
	default:
	    maxWidth = this.horizontalAlign == Alignment.STRETCH ? maxSize.width : size.width;
	    maxHeight = size.height;
	    break;
	}
	header.arrange(new Rect(0, 0, maxWidth, maxHeight));
	return new Size(maxWidth, maxHeight);
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	if (isExpanded) {
	    if (this.expandedHeader != null) {
		renderer.drawRectangle(new Rect(this.expandedHeader.getX(), this.expandedHeader.getY(), this.expandedHeader.getActualSize()), 0xffff0000);
		this.expandedHeader.render(renderer);
	    }
	    if (this.content != null)
		this.content.render(renderer);
	} else {
	    if (this.header != null)
		this.header.render(renderer);
	}
    }

    @Override
    protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
	if (isExpanded) {
	    if (this.expandedHeader != null) {
		this.expandedHeader.mouseUp(mouseX, mouseY, button);
		if (this.expandedHeader.contains(mouseX, mouseY) && this.mouseInHeaderDown)
		    this.isExpanded = false;
	    }
	    if (this.content != null)
		this.content.mouseUp(mouseX, mouseY, button);
	} else {
	    if (this.header != null) {
		this.header.mouseUp(mouseX, mouseY, button);
		if (this.header.contains(mouseX, mouseY) && this.mouseInHeaderDown)
		    this.isExpanded = true;
	    }
	}
	this.mouseInHeaderDown = false;
    }

    @Override
    protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
	if (isExpanded) {
	    if (this.expandedHeader != null) {
		this.expandedHeader.mouseDown(mouseX, mouseY, button);
		if (this.expandedHeader.contains(mouseX, mouseY))
		    this.mouseInHeaderDown = true;
	    }
	    if (this.content != null)
		this.content.mouseDown(mouseX, mouseY, button);
	} else {
	    if (this.header != null) {
		this.header.mouseDown(mouseX, mouseY, button);
		if (this.header.contains(mouseX, mouseY))
		    this.mouseInHeaderDown = true;
	    }
	}
    }

    @Override
    protected void mouseLeftOverride(float mouseX, float mouseY) {
	if (isExpanded) {
	    if (this.expandedHeader != null)
		this.expandedHeader.mouseLeft(mouseX, mouseY);
	    if (this.content != null)
		this.content.mouseLeft(mouseX, mouseY);
	} else {
	    if (this.header != null)
		this.header.mouseLeft(mouseX, mouseY);
	}
	this.mouseInHeaderDown = false;
    }

    @Override
    protected void mouseEnteredOverride(float mouseX, float mouseY) {
	if (isExpanded) {
	    if (this.expandedHeader != null)
		this.expandedHeader.mouseEntered(mouseX, mouseY);
	    if (this.content != null)
		this.content.mouseEntered(mouseX, mouseY);
	} else {
	    if (this.header != null)
		this.header.mouseEntered(mouseX, mouseY);
	}
    }

    @Override
    protected void mouseMovedOverride(float mouseX, float mouseY) {
	if (isExpanded) {
	    if (this.expandedHeader != null) {
		this.expandedHeader.mouseMoved(mouseX, mouseY);
		if (!this.expandedHeader.contains(mouseX, mouseY))
		    this.mouseInHeaderDown = false;
	    }
	    if (this.content != null)
		this.content.mouseMoved(mouseX, mouseY);
	} else {
	    if (this.header != null) {
		this.header.mouseMoved(mouseX, mouseY);
		if (!this.header.contains(mouseX, mouseY))
		    this.mouseInHeaderDown = false;
	    }
	}
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	if (isExpanded) {
	    if (this.expandedHeader != null) {
		ToolTip toolTip = this.expandedHeader.getTooltip(mouseX, mouseY);
		if (toolTip != null)
		    return toolTip;
	    }

	    if (this.content != null) {
		ToolTip toolTip = this.content.getTooltip(mouseX, mouseY);
		if (toolTip != null)
		    return toolTip;
	    }
	} else {
	    if (this.header != null) {
		ToolTip toolTip = this.header.getTooltip(mouseX, mouseY);
		if (toolTip != null)
		    return toolTip;
	    }
	}
	return null;
    }
}

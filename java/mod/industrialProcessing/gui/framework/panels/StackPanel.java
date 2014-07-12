package mod.industrialProcessing.gui.framework.panels;

import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;

public class StackPanel extends Panel {

    public Orientation orientation = Orientation.HORIZONTAL;

    @Override
    protected Size measureOverride(Size maxSize) {

	switch (orientation) {
	default:
	case HORIZONTAL:
	    float maxHeight = 0;
	    float availableWidth = maxSize.width;
	    float desiredWidth = 0;
	    for (UIElement child : getChildren()) {
		Size size = child.measure(new Size(availableWidth, maxSize.height));
		if (size.height > maxHeight)
		    maxHeight = size.height;
		availableWidth -= size.width;
		desiredWidth += size.width;
	    }
	    return new Size(Math.min(maxSize.width, desiredWidth), Math.min(maxSize.height, maxHeight));
	case VERTICAL:
	    float maxWidth = 0;
	    float availableHeight = maxSize.height;
	    float desiredHeight = 0;
	    for (UIElement child : getChildren()) {
		Size size = child.measure(new Size(maxSize.width, availableHeight));
		if (size.width > maxWidth)
		    maxWidth = size.width;
		availableHeight -= size.height;
		desiredHeight += size.height;
	    }

	    return new Size(Math.min(maxSize.width, maxWidth), Math.min(maxSize.height, desiredHeight));
	}
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	switch (orientation) {
	default:
	case HORIZONTAL:
	    float maxHeight = (this.verticalAlign != Alignment.STRETCH) ? this.getDesiredSize().height : maxSize.height;
	    float left = 0;
	    for (UIElement child : getChildren()) {
		Size size = child.getDesiredSize(); 
		child.arrange(new Rect(left, 0, size.width, maxHeight));
		left += size.width;
	    }
	    return new Size(left, maxHeight);
	case VERTICAL:
	    float maxWidth = (this.horizontalAlign != Alignment.STRETCH) ? this.getDesiredSize().width : maxSize.width;
	    float top = 0;
	    for (UIElement child : getChildren()) {
		Size size = child.getDesiredSize();
		// desired size can't be bigger then maxSize, measure should
		// have fixed that correctly. 
		child.arrange(new Rect(0, top, maxWidth, size.height));
		top += size.height;
	    }
	    return new Size(maxWidth, top);
	}
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) { 
	super.renderOverride(size, renderer);   
    } 
}

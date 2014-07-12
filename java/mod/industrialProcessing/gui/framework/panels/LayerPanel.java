package mod.industrialProcessing.gui.framework.panels;

import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;

public class LayerPanel extends Panel {

    @Override
    protected Size measureOverride(Size maxSize) {
	float minWidth = 0;
	float minHeight = 0;
	for (UIElement child : getChildren()) {
	    Size size = child.measure(maxSize);
	    if (size.width > minWidth)
		minWidth = size.width;
	    if (size.height > minHeight)
		minHeight = size.height;

	}

	return new Size(minWidth, minHeight);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	for (UIElement child : getChildren()) {
	    child.arrange(new Rect(0, 0, maxSize));
	}
	return maxSize;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	super.renderOverride(size, renderer);
    } 
}

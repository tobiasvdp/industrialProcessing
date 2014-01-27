package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

public class UserControl extends Control {

    public UIElement child;

    @Override
    protected Size measureOverride(Size maxSize) {
	float maxWidth = Float.isNaN(this.width) ? maxSize.width : this.width;
	float maxHeight = Float.isNaN(this.height) ? maxSize.height : this.height;

	float minWidth = Float.isNaN(this.width) ? 0 : this.width;
	float minHeight = Float.isNaN(this.height) ? 0 : this.height;

	Size childSize = new Size(maxWidth, maxHeight);
	if (child != null) {
	    childSize = child.measure(childSize);
	}
	return new Size(Math.max(childSize.width, minWidth), Math.max(childSize.height, minHeight));
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	if (child != null) {
	    child.arrange(new Rect(0, 0, maxSize));
	    return child.getActualSize();
	}
	return super.arrangeOverride(maxSize);
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	if (child != null)
	    child.render(renderer);
    }

}
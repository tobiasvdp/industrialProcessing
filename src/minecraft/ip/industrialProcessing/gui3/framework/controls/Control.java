package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

public abstract class Control extends UIElement {

    public float width;
    public float height;

    @Override
    protected Size measureOverride(Size maxSize) {
	float width = Float.isNaN(this.width) ? 0 : this.width;
	float height = Float.isNaN(this.height) ? 0 : this.height;
	return new Size(Math.min(width, maxSize.width), Math.min(height, maxSize.height));
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	float width = Float.isNaN(this.width) ? maxSize.width : Math.min(this.width, maxSize.width);
	float height = Float.isNaN(this.height) ? maxSize.height : Math.min(this.height, maxSize.height);
	return new Size(width, height);
    }

    @Override
    protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
    }

    @Override
    protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
    }

    @Override
    protected void mouseLeftOverride(float mouseX, float mouseY) {
    }

    @Override
    protected void mouseEnteredOverride(float mouseX, float mouseY) {
    }

    @Override
    protected void mouseMovedOverride(float mouseX, float mouseY) {
    }
}

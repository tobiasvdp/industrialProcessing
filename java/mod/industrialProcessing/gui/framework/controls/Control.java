package mod.industrialProcessing.gui.framework.controls;

import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.panels.MouseButton;

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
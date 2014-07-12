package mod.industrialProcessing.gui.framework.controls;

import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;

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

	@Override
	protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
		if (child != null)
			child.mouseUp(mouseX, mouseY, button);
	}

	@Override
	protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
		if (child != null)
			child.mouseDown(mouseX, mouseY, button);
	}

	@Override
	protected void mouseLeftOverride(float mouseX, float mouseY) {
		if (child != null)
			child.mouseLeft(mouseX, mouseY);
	}

	@Override
	protected void mouseEnteredOverride(float mouseX, float mouseY) {
		if (child != null)
			child.mouseEntered(mouseX, mouseY);
	}

	@Override
	protected void mouseMovedOverride(float mouseX, float mouseY) {
		if (child != null)
			child.mouseMoved(mouseX, mouseY);
	}

	@Override
	protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
		if (child != null)
			return child.getTooltip(mouseX, mouseY);
		return null;
	}
}

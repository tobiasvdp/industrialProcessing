package ip.industrialProcessing.gui3.framework;

import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

public class UIRoot {
    private UIElement element;
    private GuiRenderer guiRenderer;
    private int mouseX;
    private int mouseY;

    public UIRoot(UIElement element) {
	this(element, new GuiRenderer());
    }

    public UIRoot(UIElement element, GuiRenderer guiRenderer) {
	this.element = element;
	this.guiRenderer = guiRenderer;
    }

    public void mouseUp(int mouseX, int mouseY, MouseButton button) {

	if (this.element != null) {
	    if (this.element.hitTest(mouseX, mouseY)) {
		this.element.mouseUp(mouseX, mouseY, button);
	    }
	}
    }

    public void mouseDown(int mouseX, int mouseY, MouseButton button) {

	if (this.element != null) {
	    if (this.element.hitTest(mouseX, mouseY)) {
		this.element.mouseDown(mouseX, mouseY, button);
	    }
	}
    }

    public void render(int width, int height, int x, int y, int mouseX, int mouseY) {
	if (this.element != null) {
	    Size size = new Size(width, height);
	    Rect rect = new Rect(x, y, size);
	    this.element.measure(size);
	    this.element.arrange(rect);
	    mouseMoved(mouseX, mouseY);
	    this.element.render(this.guiRenderer);
	}
    }

    public void renderForeground(int mouseX, int mouseY) {
	mouseMoved(mouseX, mouseY);
    }

    public void mouseMoved(int mouseX, int mouseY) {
	if (mouseX != this.mouseX || mouseY != this.mouseY) {
	    this.mouseX = mouseX;
	    this.mouseY = mouseY;
	    float x = mouseX;
	    float y = mouseY;
	    if (this.element.hitTest(x, y)) {
		this.element.setMouseInside(true, x, y);
		this.element.mouseMove(x, y);
	    } else
		this.element.setMouseInside(false, x, y);
	}
    }
}

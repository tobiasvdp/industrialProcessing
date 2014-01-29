package ip.industrialProcessing.gui3.framework;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

import org.lwjgl.opengl.GL11;

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
	    Rect rect = new Rect(0, 0, size);
	    this.element.measure(size);
	    this.element.arrange(rect);
	    mouseMoved(mouseX - x, mouseY - y);
	    GL11.glPushMatrix();
	    GL11.glTranslatef(x, y, 0);
	    this.element.render(this.guiRenderer);
	    GL11.glPopMatrix();
	}
    }

    public void renderForeground(int x, int y, int mouseX, int mouseY) {
	if (this.element != null) {
	    mouseMoved(mouseX - x, mouseY - y);
	    ToolTip tooltip = this.element.getTooltip(mouseX - x, mouseY - y);
	    if (tooltip != null) {
		this.guiRenderer.drawToolTip(tooltip, mouseX, mouseY);
	    }
	}
    }

    public void mouseMoved(int mouseX, int mouseY) {
	if (this.element != null) {
	    if (mouseX != this.mouseX || mouseY != this.mouseY) {
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		float x = mouseX;
		float y = mouseY;
		this.element.mouseMoved(x, y);
	    }
	}
    }
}

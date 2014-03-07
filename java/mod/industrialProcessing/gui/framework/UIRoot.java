package mod.industrialProcessing.gui.framework;

import mod.industrialProcessing.gui.framework.controls.ToolTip;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;

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

    public synchronized void mouseUp(int x, int y, int mouseX, int mouseY, MouseButton button) {

        if (this.element != null) {
            mouseX -= x;
            mouseY -= y;
            this.element.mouseUp(mouseX, mouseY, button);
        }
    }

    public synchronized void mouseDown(int x, int y, int mouseX, int mouseY, MouseButton button) {

        if (this.element != null) {
            mouseX -= x;
            mouseY -= y;
            this.element.mouseDown(mouseX, mouseY, button);
        }
    }

    public synchronized void render(int width, int height, int x, int y, int mouseX, int mouseY) {

        if (this.element != null) {
            this.guiRenderer.offsetX = x;
            this.guiRenderer.offsetY = y;
            Size size = new Size(width, height);
            Rect rect = new Rect(0, 0, size);
            this.element.measure(size);
            this.element.arrange(rect);
            mouseMoved(x, y, mouseX, mouseY);
            GL11.glPushMatrix();
            GL11.glTranslatef(x, y, 0);
            this.element.render(this.guiRenderer);
            GL11.glPopMatrix();
        }
    }

    public synchronized void renderForeground(int x, int y, int mouseX, int mouseY) {
        if (this.element != null) {
            mouseMoved(x, y, mouseX, mouseY);
            ToolTip tooltip = this.element.getTooltip(mouseX - x, mouseY - y);
            if (tooltip != null) {
                this.guiRenderer.drawToolTip(tooltip, mouseX - x + 10, mouseY - y + 10);
            }
        }
    }

    public synchronized void mouseMoved(int x, int y, int mouseX, int mouseY) {
        if (this.element != null) {
            mouseX -= x;
            mouseY -= y;
            if (mouseX != this.mouseX || mouseY != this.mouseY) {
                this.mouseX = mouseX;
                this.mouseY = mouseY;
                this.element.mouseMoved(mouseX, mouseY);
            }
        }
    }
}

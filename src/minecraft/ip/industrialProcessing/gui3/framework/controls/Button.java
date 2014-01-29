package ip.industrialProcessing.gui3.framework.controls;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.Resource;
import net.minecraft.util.ResourceLocation;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class Button extends UIElement {

    private ArrayList<IButtonClickListener> clickEventHandlers = new ArrayList<IButtonClickListener>();

    public void subscribeClick(IButtonClickListener listener) {
	this.clickEventHandlers.add(listener);
    }

    public void unssubscribeClick(IButtonClickListener listener) {
	this.clickEventHandlers.remove(listener);
    }

    private static TextureReference buttonTexture = new TextureReference(new Size(200, 60), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Buttons.png");

    private TextureReference texture;

    public Button(UIElement child) {
	this(buttonTexture, child);
    }

    // texture size: 128x32 for each state: 128x96
    public Button(TextureReference texture, UIElement child) {
	this.isHittestVisible = true;
	this.texture = texture;
	this.child = child;
    }

    public UIElement child;

    boolean hover = false;
    boolean mouseDown = false;

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	if (hover || mouseDown) {
	    if (mouseDown) {
		drawButton(size, 1, renderer);
	    } else {
		drawButton(size, 2, renderer);
	    }
	} else {
	    drawButton(size, 0, renderer);
	}
	GL11.glPushMatrix();
	if (mouseDown)
	    GL11.glTranslatef(0.5f, 0.5f, 0);
	if (this.child != null)
	    this.child.render(renderer);
	GL11.glPopMatrix();
    }

    private void drawButton(Rect rect, int i, GuiRenderer renderer) {
	float uMin = 0;
	float vMin = i / 3f;
	float uSize = 1;
	float vSize = 1 / 3f;

	float cornerSize = 4;
	renderer.drawNineGrid(rect, new Thickness(cornerSize, cornerSize, cornerSize, cornerSize), new Rect(uMin, vMin, uSize, vSize), this.texture);
    }

    @Override
    protected Size measureOverride(Size maxSize) {
	if (child != null)
	    return child.measure(maxSize);
	return new Size(0, 0);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	if (child != null) {
	    Size size = child.getDesiredSize();
	    child.arrange(new Rect(0, 0, maxSize));
	    return size;
	}
	return new Size(0, 0);
    }

    @Override
    protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
	this.mouseDown = false;
	for (IButtonClickListener listener : this.clickEventHandlers) {
	    listener.buttonClicked(this, mouseX, mouseY, button);
	}
    }

    @Override
    protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
	this.mouseDown = true;
    }

    @Override
    protected void mouseLeftOverride(float mouseX, float mouseY) {
	this.hover = false;
	this.mouseDown = false;
    }

    @Override
    protected void mouseEnteredOverride(float mouseX, float mouseY) {
	this.hover = true;
    }

    @Override
    protected void mouseMovedOverride(float mouseX, float mouseY) {
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	if (child != null)
	    return child.getTooltip(mouseX, mouseY);
	return null;
    }

}

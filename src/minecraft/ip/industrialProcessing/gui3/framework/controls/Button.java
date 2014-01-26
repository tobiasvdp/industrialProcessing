package ip.industrialProcessing.gui3.framework.controls;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.Resource;
import net.minecraft.util.ResourceLocation;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class Button extends UIElement {

    private static TextureReference buttonTexture = new TextureReference(new Size(128, 96), IndustrialProcessing.TEXTURE_DOMAIN, "gui/button");

    private TextureReference texture;

    public Button() {
	this(buttonTexture);
    }

    // texture size: 128x32 for each state: 128x96
    public Button(TextureReference texture) {
	this.isHittestVisible = true;
	this.texture = texture;
    }

    UIElement child;

    boolean hover = false;
    boolean mouseDown = false;

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	if (hover) {
	    if (mouseDown) {
		drawButton(size, 2, renderer);
	    } else {
		drawButton(size, 1, renderer);
	    }
	}
	drawButton(size, 0, renderer);
	if (this.child != null)
	    this.child.render(renderer);
    }

    private void drawButton(Rect rect, int i, GuiRenderer renderer) {
	float uMin = 0;
	float vMin = i / 3f;
	float uSize = 1;
	float vSize = 1 / 3f;

	float cornerSize = Math.min(rect.width / 4, Math.min(rect.height / 4, 4));
	// TODO: support for tilable NineGrid?
	renderer.drawNineGrid(rect, new Size(cornerSize, cornerSize), new Rect(uMin, vMin, uSize, vSize), this.texture);
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
    public void mouseEntered(float x, float y) {
	this.hover = true;
    }

    @Override
    public void mouseLeft(float x, float y) {
	this.hover = false;
	this.mouseDown = false;
    }

    @Override
    public void mouseMouseMove(float x, float y) {
    }

    @Override
    public void mouseUp(float x, float y, MouseButton button) {
	this.mouseDown = false;
	// TODO: handle click
    }

    @Override
    public void mouseDown(float x, float y, MouseButton button) {
	this.mouseDown = true;
    }

}

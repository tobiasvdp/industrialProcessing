package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class Decorator extends UIElement {

    private UIElement child;
    public int borderWidth;
    private TextureReference texture;

    public void setChild(UIElement child) {
	this.child = child;
	if (this.child == null)
	    this.isHittestVisible = false;
	else
	    this.isHittestVisible = child.isHittestVisible;
    }

    public Decorator(TextureReference texture, int borderWidth) {
	this.texture = texture;
	this.borderWidth = borderWidth;
    }

    @Override
    protected Size measureOverride(Size maxSize) {
	Size size;
	if (child != null)
	    size = child.measure(new Size(maxSize.width - borderWidth * 2, maxSize.height - borderWidth * 2));
	else
	    size = new Size(0, 0);
	return new Size(size.width + borderWidth * 2, size.height + borderWidth * 2);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	if (child != null) {
	    Size size = child.getDesiredSize();
	    child.arrange(new Rect(borderWidth, borderWidth, new Size(maxSize.width - borderWidth * 2, maxSize.height - borderWidth * 2)));
	    return size;
	}
	return new Size(borderWidth * 2, borderWidth * 2);
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	if (child != null)
	    child.render(renderer);
	if (borderWidth > 0)
	    renderer.drawNineGrid(size, new Thickness(borderWidth, borderWidth, borderWidth, borderWidth), new Rect(0, 0, 1, 1), texture);
	else
	    renderer.drawTexture(size, new Rect(0, 0, 1, 1), texture);
    }

    @Override
    public void mouseEntered(float x, float y) {
	x += borderWidth;
	y += borderWidth;
	if (child != null)
	    if (child.hitTest(x, y))
		child.mouseEntered(x, y);
    }

    @Override
    public void mouseLeft(float x, float y) {
	x += borderWidth;
	y += borderWidth;
	if (child != null)
	    if (child.hitTest(x, y))
		child.mouseLeft(x, y);
    }

    @Override
    public void mouseMove(float x, float y) {
	x += borderWidth;
	y += borderWidth;
	if (child != null)
	    if (child.hitTest(x, y))
		child.mouseMove(x, y);
    }

    @Override
    public void mouseUp(float x, float y, MouseButton button) {
	x += borderWidth;
	y += borderWidth;
	if (child != null)
	    if (child.hitTest(x, y))
		child.mouseUp(x, y, button);
    }

    @Override
    public void mouseDown(float x, float y, MouseButton button) {
	x += borderWidth;
	y += borderWidth;
	if (child != null)
	    if (child.hitTest(x, y))
		child.mouseDown(x, y, button);

    }

}

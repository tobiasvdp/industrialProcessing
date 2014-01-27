package ip.industrialProcessing.gui3.framework;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

public abstract class UIElement {
    private Size actualSize;
    private float x;
    private float y;
    private Size desiredSize;

    public float getX() {
	return x;
    }

    public float getY() {
	return y;
    }

    public Thickness margin = new Thickness(0, 0, 0, 0);
    public Alignment horizontalAlign = Alignment.STRETCH;
    public Alignment verticalAlign = Alignment.STRETCH;

    public float maxWidth = Float.POSITIVE_INFINITY;
    public float maxHeight = Float.POSITIVE_INFINITY;
    public float minHeight = 0;
    public float minWidth = 0;
    public boolean isHittestVisible = false;
    private boolean isMouseInside;

    public Size getDesiredSize() {
	return desiredSize;
    }

    public Size getActualSize() {
	return actualSize;
    }

    public Size measure(Size rect) {

	float width = rect.width;
	float height = rect.height;

	if (width > maxWidth)
	    width = maxWidth;
	if (height > maxHeight)
	    height = maxHeight;

	if (margin != null) {
	    width -= margin.left + margin.right;
	    height -= margin.top + margin.bottom;
	}
	Size clamp = new Size(width, height);
	Size measured = measureOverride(clamp);

	width = Math.min(measured.width, clamp.width);
	height = Math.min(measured.height, clamp.height);

	if (width < this.minWidth)
	    width = this.minWidth;
	if (height < this.minHeight)
	    height = this.minHeight;

	if (margin != null) {
	    width += margin.left + margin.right;
	    height += margin.top + margin.bottom;
	}

	return this.desiredSize = new Size(width, height);
    }

    protected float clamp(float a, float min, float max) {
	if (a < min)
	    a = min;
	if (a > max)
	    a = max;
	return a;
    }
    protected int clamp(int a, int min, int max) {
	if (a < min)
	    a = min;
	if (a > max)
	    a = max;
	return a;
    }

    protected abstract Size measureOverride(Size maxSize);

    public void arrange(Rect rect) { 
	Size size = arrangeOverride(rect.getSize());

	float width = Math.min(size.width, rect.width);
	float height = Math.min(size.height, rect.width);
	this.y = rect.y;

	switch (this.horizontalAlign) {
	case MIN:
	    this.x = rect.x;
	    break;
	case MAX:
	    this.x = (rect.width - size.width) + rect.x;
	    break;
	case CENTER:
	    this.x = (rect.width - size.width) / 2 + rect.x;
	    break;
	default:
	case STRETCH:
	    this.x = rect.x;
	    width = rect.width;
	    break;
	}

	switch (this.verticalAlign) {
	case MIN:
	    this.y = rect.y;
	    break;
	case MAX:
	    this.y = (rect.height - size.height) + rect.y;
	    break;
	case CENTER:
	    this.y = (rect.height - size.height) / 2 + rect.y;
	    break;
	default:
	case STRETCH:
	    this.y = rect.y;
	    height = rect.height;
	    break;
	}
	this.actualSize = new Size(width, height);
    }

    protected abstract Size arrangeOverride(Size maxSize);

    public void render(GuiRenderer renderer) {
	GL11.glPushMatrix();
	GL11.glTranslatef(x, y, 1);
	Rect bounds = new Rect(0, 0, this.actualSize);
	renderOverride(bounds, renderer);
	GL11.glPopMatrix();
    }

    protected abstract void renderOverride(Rect size, GuiRenderer renderer);
     
    public void setMouseInside(boolean isInside, float x, float y) {
	if (isHittestVisible) {
	    if (isMouseInside != isInside) {
		this.isMouseInside = isInside;
		if (isInside)
		    mouseEntered(x, y);
		else
		    mouseLeft(x, y);
	    }
	}
    }

    public abstract void mouseEntered(float x, float y);

    public abstract void mouseLeft(float x, float y);

    public abstract void mouseMouseMove(float x, float y);

    public abstract void mouseUp(float x, float y, MouseButton button);

    public abstract void mouseDown(float x, float y, MouseButton button);

    public boolean hitTest() {
	if (this.isHittestVisible) {
	    Rect rect = new Rect(this.x, this.y, this.actualSize);
	    if (rect.contains(x, y))
		return true;
	}
	return false;
    }
}

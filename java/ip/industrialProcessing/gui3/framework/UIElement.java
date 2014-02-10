package ip.industrialProcessing.gui3.framework;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

public abstract class UIElement {
    private Size actualSize;
    private float x;
    private float y;
    private Size desiredSize;
    private static float absoluteX = 0;
    private static float absoluteY = 0;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Thickness margin = new Thickness(0, 0, 0, 0);
    public Alignment horizontalAlign = Alignment.STRETCH;
    public Alignment verticalAlign = Alignment.STRETCH;

    public Visibility visibility = Visibility.VISIBLE;

    public float maxWidth = Float.POSITIVE_INFINITY;
    public float maxHeight = Float.POSITIVE_INFINITY;
    public float minHeight = 0;
    public float minWidth = 0;
    public boolean isHittestVisible = false;
    private boolean isMouseInside;

    public Size getDesiredSize() {
        if (desiredSize == null)
            return null;
        return new Size(desiredSize.width, desiredSize.height);
    }

    public Size getActualSize() {
        if (actualSize == null)
            return null;
        return new Size(actualSize.width, actualSize.height);
    }

    public Size measure(Size rect) {
        if (visibility == Visibility.COLLAPSED)
            return new Size(0, 0);
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
        max = Math.max(min, max);
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
        if (visibility == Visibility.COLLAPSED)
            return;
        if (this.margin != null) {
            rect.x += this.margin.left;
            rect.y += this.margin.top;
            rect.width -= this.margin.left + this.margin.right;
            rect.height -= this.margin.top + this.margin.bottom;
        }

        float width = this.horizontalAlign == Alignment.STRETCH ? Float.POSITIVE_INFINITY : this.desiredSize.width;
        float height = this.verticalAlign == Alignment.STRETCH ? Float.POSITIVE_INFINITY : this.desiredSize.height;

        width = Math.min(width, rect.width);
        height = Math.min(height, rect.height);

        width = Math.round(width);
        height = Math.round(height);
        Size clamp = new Size(width, height);
        Size size = arrangeOverride(clamp);

        width = Math.min(size.width, rect.width);
        height = Math.min(size.height, rect.height);

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
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        width = Math.round(width);
        height = Math.round(height);
        this.actualSize = new Size(width, height);
    }

    protected abstract Size arrangeOverride(Size maxSize);

    private int color = hashCode() + 0xFF000000;
    private float mouseY;
    private float mouseX;
    private boolean hasToolTip;

    public void render(GuiRenderer renderer) {
        if (visibility == Visibility.VISIBLE) {
            if (this.actualSize != null && this.actualSize.width > 0 && this.actualSize.height > 0) {
                boolean debug = false;
                GL11.glPushMatrix();
                GL11.glTranslatef(x, y, 0.1f);
                absoluteX += x;
                absoluteY += y;
                Rect bounds = new Rect(0, 0, this.actualSize);
                if (debug) {
                    renderer.drawRectangle(bounds, 0xFFffffff);
                }
                renderOverride(bounds, renderer);
                absoluteX -= x;
                absoluteY -= y;
                if (debug) {
                    GL11.glTranslatef(0, 0, 1);
                    color = this.isMouseInside ? 0xffffff00 : 0xffff0000;
                    float lineThickness = 0.25f;
                    renderer.drawRectangle(new Rect(0, 0, lineThickness, this.actualSize.height), color);
                    renderer.drawRectangle(new Rect(this.actualSize.width - lineThickness, 0, lineThickness, this.actualSize.height), color);
                    renderer.drawRectangle(new Rect(0, 0, this.actualSize.width, lineThickness), color);
                    renderer.drawRectangle(new Rect(0, this.actualSize.height - lineThickness, this.actualSize.width, lineThickness), color);
                }
                GL11.glPopMatrix();
            }
        }
    }

    protected Rect getAbsoluteBounds(Rect relativeBounds) {
        return new Rect(absoluteX + relativeBounds.x, absoluteY + relativeBounds.y, relativeBounds.width, relativeBounds.height);
    }

    protected abstract void renderOverride(Rect size, GuiRenderer renderer);

    public void mouseDown(float mouseX, float mouseY, MouseButton button) {
        float relativeX = mouseX - this.x;
        float relativeY = mouseY - this.y;
        if (this.hitTest(mouseX, mouseY) || true) {
            mouseDownOverride(relativeX, relativeY, button);
        }
    }

    public void mouseUp(float mouseX, float mouseY, MouseButton button) {
        float relativeX = mouseX - this.x;
        float relativeY = mouseY - this.y;
        if (this.hitTest(mouseX, mouseY) || true) {
            mouseUpOverride(relativeX, relativeY, button);
        }
    }

    public void mouseMoved(float mouseX, float mouseY) {
        float relativeX = mouseX - this.x;
        float relativeY = mouseY - this.y;
        mouseMovedOverride(relativeX, relativeY);
        setMouseInside(this.hitTest(mouseX, mouseY), relativeX, relativeY);
    }

    private void setMouseInside(boolean hit, float mouseX, float mouseY) {
        if (this.isMouseInside != hit) {
            this.isMouseInside = hit;
            if (hit)
                mouseEnteredOverride(mouseX, mouseY);
            else
                mouseLeftOverride(mouseX, mouseY);
        }
    }

    public void mouseEntered(float mouseX, float mouseY) {
        float relativeX = mouseX - this.x;
        float relativeY = mouseY - this.y;
        boolean hit = this.hitTest(mouseX, mouseY);
        setMouseInside(hit, relativeX, relativeY);
    }

    public void mouseLeft(float mouseX, float mouseY) {
        float relativeX = mouseX - this.x;
        float relativeY = mouseY - this.y;
        boolean hit = this.hitTest(mouseX, mouseY);
        setMouseInside(hit, relativeX, relativeY);
    }

    protected abstract void mouseUpOverride(float mouseX, float mouseY, MouseButton button);

    protected abstract void mouseDownOverride(float mouseX, float mouseY, MouseButton button);

    protected abstract void mouseLeftOverride(float mouseX, float mouseY);

    protected abstract void mouseEnteredOverride(float mouseX, float mouseY);

    protected abstract void mouseMovedOverride(float mouseX, float mouseY);

    private boolean hitTest(float x, float y) {
        if (this.isHittestVisible && this.actualSize != null) {
            Rect rect = new Rect(this.x, this.y, this.actualSize);
            if (rect.contains(x, y))
                return true;
        }
        return false;
    }

    public boolean contains(float x, float y) {
        if (this.actualSize != null) {
            Rect rect = new Rect(this.x, this.y, this.actualSize);
            if (rect.contains(x, y))
                return true;
        }
        return false;
    }

    public ToolTip getTooltip(float mouseX, float mouseY) {
        this.hasToolTip = false;
        if (this.actualSize != null) {
            Rect rect = new Rect(this.x, this.y, this.actualSize);
            if (rect.contains(mouseX, mouseY)) {
                ToolTip tooltip = getTooltipOverride(mouseX - this.x, mouseY - this.y);
                if (tooltip != null) {
                    this.hasToolTip = true;
                    return tooltip;
                }
            }
        }
        return null;
    }

    protected abstract ToolTip getTooltipOverride(float mouseX, float mouseY);
}

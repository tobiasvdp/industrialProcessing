package ip.industrialProcessing.gui3.framework.panels;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class ScrollPanel extends UIElement {
    private static final TextureReference DEFAULT_SCROLLBAR_VERTICAL_TEXTURE = new TextureReference(new Size(14, 129f), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Scrollbar.png");
    private static final TextureReference DEFAULT_SCROLLBAR_HORIZONTAL_TEXTURE = new TextureReference(new Size(129f, 14), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/ScrollbarHorizontal.png");
    private static final Rect DEFAULT_SCROLLBAR_VERTICAL_BACKGROUND = new Rect(0, 0, 1, 112 / 129f);
    private static final Rect DEFAULT_SCROLLBAR_HORIZONTAL_BACKGROUND = new Rect(0, 0, 112 / 129f, 1);
    private static final Rect DEFAULT_SCROLLBAR_VERTICAL_GLYPH = new Rect(0, 112 / 129f, 1, 17 / 129f);
    private static final Rect DEFAULT_SCROLLBAR_HORIZONTAL_GLYPH = new Rect(112 / 129f, 0, 17 / 129f, 1);
    private static final Thickness DEFAULT_SCROLLBAR_BORDER_BACKGROUND = new Thickness(1, 1, 1, 1);
    private static final Thickness DEFAULT_SCROLLBAR_BORDER_GLYPH = new Thickness(4, 4, 4, 4);

    private static final Thickness DEFAULT_PADDING = new Thickness(1, 1, 1, 1);

    public UIElement content;
    public boolean allowHorizontalScroll = false;
    public boolean allowVerticalScroll = true;
    public Thickness padding = DEFAULT_PADDING;
    float scrollbarWidth = 14;
    float scrollbarHeight = 14;
    float scrollOffsetX = 0;
    float scrollOffsetY = 0;

    private float dragYoffset;
    private float dragXoffset;

    private boolean verticalDrag;

    private boolean horizontalDrag;

    public ScrollPanel() {
	this.isHittestVisible = true;
	this.padding = new Thickness(1, 1, 1, 1);
    }

    @Override
    protected Size measureOverride(Size maxSize) {
	float padHorizontal = padding.left + padding.right;
	float padVertical = padding.top + padding.bottom;
	float maxWidth = maxSize.width;
	float maxHeight = maxSize.height;
	if (allowHorizontalScroll)
	    maxWidth = Float.POSITIVE_INFINITY;
	if (allowVerticalScroll)
	    maxHeight = Float.POSITIVE_INFINITY;
	if (allowHorizontalScroll)
	    padVertical += scrollbarHeight;
	if (allowVerticalScroll)
	    padHorizontal += scrollbarWidth;
	if (content != null) {
	    float width;
	    float height;
	    Size contentSize = content.measure(new Size(maxWidth - padHorizontal, maxHeight - padVertical));
	    return new Size(contentSize.width + padHorizontal, contentSize.height + padVertical);
	}
	return new Size(0, 0);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	if (content != null) {

	    Size size = content.getDesiredSize();

	    float padHorizontal = padding.left + padding.right;
	    float padVertical = padding.top + padding.bottom;
	    float maxWidth = maxSize.width;
	    float maxHeight = maxSize.height;

	    if (allowVerticalScroll)
		padHorizontal += scrollbarWidth;
	    if (allowHorizontalScroll)
		padVertical += scrollbarHeight;

	    maxWidth -= padHorizontal;
	    maxHeight -= padVertical;

	    if (this.horizontalAlign != Alignment.STRETCH && size.width < maxWidth)
		maxWidth = size.width;
	    if (this.verticalAlign != Alignment.STRETCH && size.height < maxHeight)
		maxHeight = size.height;

	    if (allowVerticalScroll && size.height > maxHeight)
		maxHeight = size.height;

	    if (allowHorizontalScroll && size.width > maxWidth)
		maxWidth = size.width;

	    float left = padding.left;
	    float top = padding.top;

	    content.arrange(new Rect(left - scrollOffsetX, top - scrollOffsetY, maxWidth, maxHeight));

	    Rect clip = getInnerBounds();
	    this.scrollOffsetX = clamp(scrollOffsetX, 0, (maxWidth + padHorizontal - clip.width));
	    this.scrollOffsetY = clamp(scrollOffsetY, 0, (maxHeight + padVertical - clip.height));
	    return new Size(maxWidth + padHorizontal, maxHeight + padVertical);
	}
	return new Size(0, 0);
    }

    protected Rect getVerticalScrollbar(Rect bounds) {
	return new Rect(bounds.width + bounds.x, bounds.y, scrollbarWidth, bounds.height);
    }

    protected Rect getHorizontalScrollbar(Rect bounds) {
	return new Rect(bounds.x, bounds.y + bounds.height, bounds.width, scrollbarHeight);
    }

    protected Rect getOuterBounds() {
	Size size = getActualSize();
	if (size != null) {
	    float width = size.width;
	    float height = size.height;
	    if (allowVerticalScroll)
		width -= scrollbarWidth;
	    if (allowHorizontalScroll)
		height -= scrollbarHeight;
	    return new Rect(0, 0, width, height);
	}
	return new Rect(0, 0, 0, 0);
    }

    protected Rect getInnerBounds() {
	Rect clip = getOuterBounds();
	return new Rect(clip.x + padding.left, clip.y + padding.top, clip.width - padding.left - padding.right, clip.height - padding.top - padding.bottom);
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	Rect outerBounds = getOuterBounds();
	Rect innerBounds = getInnerBounds();
	if (content != null) {
	    Rect abs = getAbsoluteBounds(innerBounds);
	    renderer.drawNineGrid(outerBounds, padding, DEFAULT_SCROLLBAR_VERTICAL_BACKGROUND, DEFAULT_SCROLLBAR_VERTICAL_TEXTURE);

	    renderer.enableScissor(abs);
	    content.render(renderer);
	    renderer.disableScissor();
	    Rect scrollBar, scrollBlock;
	    // vertical
	    if (allowVerticalScroll) {
		scrollBar = getVerticalScrollbar(outerBounds);
		renderer.drawNineGrid(scrollBar, DEFAULT_SCROLLBAR_BORDER_BACKGROUND, DEFAULT_SCROLLBAR_VERTICAL_BACKGROUND, DEFAULT_SCROLLBAR_VERTICAL_TEXTURE);

		scrollBlock = getVerticalScrollBlock(innerBounds, scrollBar);
		renderer.drawNineGrid(scrollBlock, DEFAULT_SCROLLBAR_BORDER_GLYPH, DEFAULT_SCROLLBAR_VERTICAL_GLYPH, DEFAULT_SCROLLBAR_VERTICAL_TEXTURE);
	    }
	    // horizontal
	    if (allowHorizontalScroll) {
		scrollBar = getHorizontalScrollbar(outerBounds);
		renderer.drawNineGrid(scrollBar, DEFAULT_SCROLLBAR_BORDER_BACKGROUND, DEFAULT_SCROLLBAR_HORIZONTAL_BACKGROUND, DEFAULT_SCROLLBAR_HORIZONTAL_TEXTURE);

		scrollBlock = getHorizontalScrollBlock(outerBounds, scrollBar);
		renderer.drawNineGrid(scrollBlock, DEFAULT_SCROLLBAR_BORDER_GLYPH, DEFAULT_SCROLLBAR_HORIZONTAL_GLYPH, DEFAULT_SCROLLBAR_HORIZONTAL_TEXTURE);
	    }
	}
    }

    protected Rect getVerticalScrollBlock(Rect clipBounds, Rect scrollBar) {
	float childHeight = content.getActualSize().height + padding.top + padding.bottom;
	float height = (clipBounds.height) / childHeight * scrollBar.height;
	float y = (scrollOffsetY) / (childHeight - scrollBar.height) * (scrollBar.height - height);
	return new Rect(scrollBar.x, y, scrollBar.width, height);
    }

    protected Rect getHorizontalScrollBlock(Rect clipBounds, Rect scrollBar) {
	float childWidth = content.getActualSize().width + padding.left + padding.right;
	float width = (clipBounds.width) / childWidth * scrollBar.width;
	float x = (scrollOffsetX) / (childWidth - scrollBar.width) * (scrollBar.width - width);
	return new Rect(x + padding.left, scrollBar.y, width, scrollBar.height);
    }

    @Override
    protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
	this.verticalDrag = false;
	this.horizontalDrag = false;
	if (content != null) {
	    Rect outerBounds = getOuterBounds();
	    if (outerBounds.contains(mouseX, mouseY)) {
		content.mouseUp(mouseX, mouseY, button);
	    } else {
		Size contentSize = content.getActualSize();
		Rect scrollBar = getVerticalScrollbar(outerBounds);

		if (scrollBar.contains(mouseX, mouseY)) {
		    Rect block = getVerticalScrollBlock(outerBounds, scrollBar);
		    if (!block.contains(mouseX, mouseY)) {
			float y = mouseY > block.y + block.height ? mouseY - block.height : mouseY;
			scrollOffsetY = ((y - scrollBar.y) / (scrollBar.height - block.height)) * (contentSize.height - outerBounds.height);
		    }
		}
		scrollBar = getHorizontalScrollbar(outerBounds);
		if (scrollBar.contains(mouseX, mouseY)) {
		    Rect block = getHorizontalScrollBlock(outerBounds, scrollBar);
		    if (!block.contains(mouseX, mouseY)) {
			float x = mouseX > block.x + block.width ? mouseX - block.width : mouseX;
			scrollOffsetX = ((x - scrollBar.x) / (scrollBar.width - block.width)) * (contentSize.width - outerBounds.width);
		    }
		}
	    }
	}
    }

    @Override
    protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
	if (content != null) {
	    Rect clip = getOuterBounds();
	    if (clip.contains(mouseX, mouseY)) {
		content.mouseDown(mouseX, mouseY, button);
	    } else {
		Size contentSize = content.getActualSize();
		Rect scrollBar = getVerticalScrollbar(clip);

		if (scrollBar.contains(mouseX, mouseY)) {
		    Rect block = getVerticalScrollBlock(clip, scrollBar);
		    if (block.contains(mouseX, mouseY)) {
			verticalDrag = true;
			this.dragYoffset = mouseY - block.y;
		    }
		}
		scrollBar = getHorizontalScrollbar(clip);
		if (scrollBar.contains(mouseX, mouseY)) {
		    Rect block = getHorizontalScrollBlock(clip, scrollBar);
		    if (block.contains(mouseX, mouseY)) {
			this.dragXoffset = mouseX - block.x;
			horizontalDrag = true;
		    }
		}
	    }
	}
    }

    @Override
    protected void mouseLeftOverride(float mouseX, float mouseY) {
	if (content != null) {
	    Rect clip = getOuterBounds();
	    if (clip.contains(mouseX, mouseY)) {
		content.mouseLeft(mouseX, mouseY);
	    }
	}
    }

    @Override
    protected void mouseEnteredOverride(float mouseX, float mouseY) {
	if (content != null) {
	    Rect clip = getOuterBounds();
	    if (clip.contains(mouseX, mouseY)) {
		content.mouseEntered(mouseX, mouseY);
	    }
	}
    }

    @Override
    protected void mouseMovedOverride(float mouseX, float mouseY) {
	if (content != null) {
	    Rect clip = getOuterBounds();
	    if (clip.contains(mouseX, mouseY)) {
		content.mouseMoved(mouseX, mouseY);
	    }

	    Size contentSize = content.getActualSize();

	    contentSize = new Size(contentSize.width + padding.left + padding.right, contentSize.height + padding.top + padding.bottom);
	    if (verticalDrag) {
		Rect scrollBar = getVerticalScrollbar(clip);
		Rect block = getVerticalScrollBlock(clip, scrollBar);
		float offset = mouseY - block.y;
		float distance = offset - dragYoffset;
		this.scrollOffsetY += distance / (scrollBar.height - block.height) * (contentSize.height - clip.height);
		this.scrollOffsetY = clamp(scrollOffsetY, 0, (contentSize.height - clip.height));

	    }
	    if (horizontalDrag) {
		Rect scrollBar = getHorizontalScrollbar(clip);
		Rect block = getHorizontalScrollBlock(clip, scrollBar);
		float offset = mouseX - block.x;
		float distance = offset - this.dragXoffset;
		this.scrollOffsetX += distance / (scrollBar.width - block.width) * (contentSize.width - clip.width);
		this.scrollOffsetX = clamp(scrollOffsetX, 0, (contentSize.width - clip.width));

	    }
	}
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	if (content != null) {
	    Rect clip = getOuterBounds();
	    if (clip.contains(mouseX, mouseY)) {
		return content.getTooltip(mouseX, mouseY);
	    }
	}
	return null;
    }
}

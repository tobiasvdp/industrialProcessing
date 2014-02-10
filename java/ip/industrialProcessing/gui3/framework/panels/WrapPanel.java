package ip.industrialProcessing.gui3.framework.panels;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;

import java.util.List;

public class WrapPanel extends Panel {

    public Orientation orientation = Orientation.HORIZONTAL;

    @Override
    protected Size measureOverride(Size maxSize) {
	float left = 0;
	float top = 0;
	float columnWidth = 0;
	float rowHeight = 0;
	float maxWidth = 0;
	float maxHeight = 0;
	List<UIElement> children = getChildren();
	switch (orientation) {
	case HORIZONTAL:
	    for (UIElement child : children) {
		Size size = child.measure(maxSize);
		if (left + size.width > maxSize.width) {
		    // to big for current row, switch to next
		    if (left > maxWidth)
			maxWidth = left;
		    top += rowHeight;
		    left = 0;
		    rowHeight = 0;
		}
		left += size.width;
		if (size.height > rowHeight) {
		    rowHeight = size.height;
		}
	    }
	    maxHeight = top + rowHeight; 
	    if (left > maxWidth)
		maxWidth = left;
	    return new Size(maxWidth, maxHeight);
	default:
	case VERTICAL:
	    for (UIElement child : children) {
		Size size = child.measure(maxSize);
		if (top + size.height > maxSize.height) {
		    // measure element at next row
		    if (top > maxHeight)
			maxHeight = top;
		    left += columnWidth;
		    top = 0;
		    columnWidth = 0;
		}
		top += size.height;
		if (size.width > columnWidth) {
		    columnWidth = size.width;
		}
	    }
	    if (top > maxHeight)
		maxHeight = top;
	    maxWidth = left + columnWidth;
	    return new Size(maxWidth, maxHeight);
	}
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	float left = 0;
	float top = 0;
	float columnWidth = 0;
	float rowHeight = 0;
	float maxWidth = 0;
	float maxHeight = 0;
	List<UIElement> children = getChildren();
	switch (orientation) {
	case HORIZONTAL:
	    for (UIElement child : children) {
		Size size = child.getDesiredSize();
		if (left + size.width > maxSize.width) {
		    // to big for current row, switch to next
		    if (left > maxWidth)
			maxWidth = left;
		    top += rowHeight;
		    left = 0;
		    rowHeight = 0;
		}
		child.arrange(new Rect(left, top, size));
		left += size.width; 
		if (size.height > rowHeight) {
		    rowHeight = size.height;
		}
	    }
	    maxHeight = top + rowHeight;
	    if (left > maxWidth)
		maxWidth = left;
	    return new Size(maxWidth, maxHeight);
	default:
	case VERTICAL:
	    for (UIElement child : children) {
		Size size = child.getDesiredSize();
		if (top + size.height > maxSize.height) {
		    // measure element at next row
		    if (top > maxHeight)
			maxHeight = top;
		    left += columnWidth;
		    top = 0;
		    columnWidth = 0;
		}
		child.arrange(new Rect(left, top, size));
		top += size.height;
		if (size.width > columnWidth) {
		    columnWidth = size.width;
		}
	    }
	    if (top > maxHeight)
		maxHeight = top;
	    maxWidth = left + columnWidth;
	    return new Size(maxWidth, maxHeight);
	}
    }

}

package ip.industrialProcessing.gui3.framework.panels;

import java.util.List;

import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;

public class WrapGrid extends Panel {

    public Orientation orientation = Orientation.HORIZONTAL;

    @Override
    protected Size measureOverride(Size maxSize) {
	List<UIElement> children = getChildren();
	float maxWidth = 0;
	float maxHeight = 0;
	for (UIElement child : children) {
	    Size size = child.measure(maxSize);
	    if (size.width > maxWidth) {
		maxWidth = size.width;
	    }
	    if (size.width > maxHeight) {
		maxHeight = size.width;
	    }
	}
	int rows, columns;
	switch (orientation) {
	case HORIZONTAL:
	    columns = (int) (maxSize.width / maxWidth);
	    rows = (children.size() - 1 / columns) + 1;
	    return new Size(maxWidth * columns, maxHeight * rows);
	default:
	case VERTICAL:
	    rows = (int) (maxSize.height / maxHeight);
	    columns = (children.size() - 1 / rows) + 1;
	    return new Size(maxWidth * columns, maxHeight * rows);
	}
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	List<UIElement> children = getChildren();
	return null;
    }

}

package ip.industrialProcessing.gui3.framework.panels;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;

import java.util.ArrayList;
import java.util.List;

public class GridPanel extends Panel {
    public ArrayList<GridSize> sizes = new ArrayList<GridSize>();
    public Orientation orientation = Orientation.HORIZONTAL;
    public StackMode mode = StackMode.STRETCH;

    @Override
    protected Size measureOverride(Size maxSize) {
	if (getChildren().isEmpty())
	    return new Size(0, 0);
	switch (orientation) {
	case HORIZONTAL:
	default:
	    return measureHorizontal(maxSize);
	case VERTICAL:
	    return measureVertical(maxSize);
	}
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	if (getChildren().isEmpty())
	    return new Size(0, 0);

	switch (orientation) {
	case HORIZONTAL:
	default:
	    return arrangeHorizontal(maxSize);
	case VERTICAL:
	    return arrangeVertical(maxSize);
	}
    }

    private Size measureVertical(Size maxSize) {
	float[] rowSizes = getSizes(maxSize.height);
	int row = 0;
	float left = 0;
	float columnWidth = 0;
	float availableWidth = maxSize.width - left;
	float maxHeight = 0;
	float columnHeight = 0;
	for (UIElement child : getChildren()) {
	    float height = rowSizes[row++];
	    Size size = child.measure(new Size(availableWidth, height));
	    if (size.width > columnWidth)
		columnWidth = size.width;
	    if (size.height > columnHeight)
		columnHeight = size.height;
	    if (row >= rowSizes.length) {
		row = 0;
		left += columnWidth;
		columnWidth = 0;
		if (columnHeight > height)
		    height = columnHeight;
		columnHeight = 0;
	    }
	}
	return new Size(left + columnWidth, maxHeight);
    }

    private Size measureHorizontal(Size maxSize) {
	float[] columnSizes = getSizes(maxSize.width);
	int column = 0;
	float top = 0;
	float rowHeight = 0;
	float availableHeight = maxSize.height - top;
	float maxWidth = 0;
	float rowWidth = 0;
	for (UIElement child : getChildren()) {
	    float width = columnSizes[column++];
	    Size size = child.measure(new Size(width, availableHeight));
	    if (size.height > rowHeight)
		rowHeight = size.height;
	    if (size.width > rowWidth)
		rowWidth = size.width;
	    if (column >= columnSizes.length) {
		column = 0;
		top += rowHeight;
		rowHeight = 0;
		if (rowWidth > width)
		    width = rowWidth;
		rowWidth = 0;
	    }
	}
	return new Size(maxWidth, top + rowHeight);
    }

    private Size arrangeVertical(Size maxSize) {
	float[] rowSizes = getSizes(maxSize.height);

	List<UIElement> children = getChildren();

	int columns = (children.size() - 1) / rowSizes.length + 1;

	float[] columnSizes = new float[columns];

	float requiredWidth = 0;
	float requiredHeight = 0;
	for (int i = 0; i < rowSizes.length; i++) {
	    requiredHeight += rowSizes[i];
	}
	for (int i = 0; i < children.size(); i++) {
	    int column = i / rowSizes.length;
	    Size size = children.get(i).getDesiredSize();
	    if (size.width > columnSizes[column]) {
		requiredWidth += size.width - columnSizes[column];
		columnSizes[column] = size.width;
	    }
	}

	if (mode == StackMode.STRETCH) {
	    if (requiredWidth > 0) {
		float scale = maxSize.width / requiredWidth;
		for (int i = 0; i < columnSizes.length; i++) {
		    columnSizes[i] *= scale;
		}
	    } else {
		for (int i = 0; i < columnSizes.length; i++) {
		    columnSizes[i] = maxSize.width;
		}
	    }
	    requiredWidth = maxSize.width;
	}

	float left = 0;
	float top = 0;
	int row = 0;
	int column = 0;
	for (int i = 0; i < children.size(); i++) {
	    float height = rowSizes[row++];
	    float width = columnSizes[column];
	    Rect rect = new Rect(left, top, width, height);
	    children.get(i).arrange(rect);
	    top += height;
	    if (row >= rowSizes.length) {
		row = 0;
		top = 0;
		left += width;
		column++;
	    }
	}
	return new Size(requiredWidth, maxSize.height);
    }

    private Size arrangeHorizontal(Size maxSize) {
	float[] columnSizes = getSizes(maxSize.width);

	List<UIElement> children = getChildren();

	int rows = (children.size() - 1) / columnSizes.length + 1;

	float[] rowSizes = new float[rows];

	float requiredHeight = 0;
	float requiredWidth = 0;
	for (int i = 0; i < columnSizes.length; i++) {
	    requiredWidth += columnSizes[i];
	}
	for (int i = 0; i < children.size(); i++) {
	    int row = i / columnSizes.length;
	    Size size = children.get(i).getDesiredSize();
	    if (size.height > rowSizes[row]) {
		requiredHeight += size.height - rowSizes[row];
		rowSizes[row] = size.height;
	    }
	}

	if (mode == StackMode.STRETCH) {
	    float scale = maxSize.height / requiredHeight;
	    for (int i = 0; i < rowSizes.length; i++) {
		rowSizes[i] *= scale;
	    }
	    requiredHeight = maxSize.height;
	}

	float top = 0;
	float left = 0;
	int column = 0;
	int row = 0;
	for (int i = 0; i < children.size(); i++) {
	    float width = columnSizes[column++];
	    float height = rowSizes[row];
	    Rect rect = new Rect(left, top, width, height);
	    children.get(i).arrange(rect);
	    left += width;
	    if (column >= columnSizes.length) {
		column = 0;
		left = 0;
		top += height;
		row++;
	    }
	}
	return new Size(maxSize.width, requiredHeight);
    }

    private float[] getSizes(float maxSize) {
	if (sizes == null || sizes.isEmpty())
	    return new float[] { maxSize };

	if (Float.isInfinite(maxSize)) {
	    float[] result = new float[sizes.size()];
	    int i = 0;
	    for (GridSize size : sizes) {
		switch (size.mode) {
		case ABSOLUTE:
		    result[i++] = size.value;
		    break;
		case RELATIVE:
		default:
		    result[i++] = Float.POSITIVE_INFINITY;
		    break;
		}
	    }
	    return result;
	} else {
	    float totalAbsolute = 0;
	    float totalRelative = 0;
	    for (GridSize size : sizes) {
		switch (size.mode) {
		case ABSOLUTE:
		    totalAbsolute += size.value;
		    break;

		case RELATIVE:
		default:
		    totalRelative += size.value;
		    break;
		}
	    }
	    float relativeWidthAvailable = Math.max(maxSize - totalAbsolute, 0);

	    float[] result = new float[sizes.size()];
	    int i = 0;
	    float left = 0;
	    for (GridSize size : sizes) {
		switch (size.mode) {
		case ABSOLUTE:
		    float available = maxSize - left; // can't go past right
						      // boundary
		    float width = Math.min(available, size.value);
		    result[i++] = width;
		    left += width;
		    break;

		case RELATIVE:
		default:
		    float value = relativeWidthAvailable * size.value / totalRelative;
		    result[i++] = value;
		    left += value;
		    break;
		}
	    }
	    return result;
	}
    }
}

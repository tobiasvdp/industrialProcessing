package ip.industrialProcessing.gui3.framework.panels;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import cpw.mods.fml.common.asm.transformers.MarkerTransformer;

public class GridPanel extends UIElement {
    public ArrayList<GridSize> rows = new ArrayList<GridSize>();
    public ArrayList<GridSize> columns = new ArrayList<GridSize>();

    public ArrayList<GridCell> children = new ArrayList<GridCell>();

    @Override
    protected Size measureOverride(Size maxSize) {
	float[] columnHeights = new float[columns.size()];
	float[] rowWidths = new float[rows.size()];
	int widestRow = 0;
	int highestColumn = 0;
	float[] rowMaxSizes = makeAbsolute(maxSize.height, rows);
	float[] columnMaxSizes = makeAbsolute(maxSize.width, columns);
	float[] rowMinSizes = getAbsolute(rows);
	float[] columnMinSizes = getAbsolute(columns);

	boolean[][] usedCells = new boolean[rows.size()][columns.size()];
	for (GridCell child : children) {
	    if (child.content != null) {
		int row = clamp(child.row, 0, rows.size() - 1);
		int maxRow = clamp(child.row + child.rowSpan - 1, 0, rows.size() - 1);
		int column = clamp(child.column, 0, columns.size() - 1);
		int maxColumn = clamp(child.column + child.columnSpan - 1, 0, columns.size() - 1);

		float minWidth = 0;
		float minHeight = 0;
		float maxWidth = 0;
		float maxHeight = 0;
		for (int i = row; i <= maxRow; i++) {
		    maxHeight += rowMaxSizes[i];
		    minHeight += rowMinSizes[i];
		}
		for (int i = column; i <= maxColumn; i++) {
		    maxWidth += columnMaxSizes[i];
		    minWidth += columnMinSizes[i];
		}

		for (int i = row; i <= maxRow; i++) {
		    for (int j = column; j <= maxColumn; j++) {
			usedCells[i][j] = true;
		    }
		}
		Size size = new Size(maxWidth, maxHeight);
		size = child.content.measure(size);
		for (int i = row; i <= maxRow; i++) {
		    float width = (rowWidths[i] += Math.max(minWidth, size.width));
		    if (width > rowWidths[widestRow])
			widestRow = i;
		}
		for (int i = column; i <= maxColumn; i++) {
		    float height = columnHeights[i] += Math.max(minHeight, size.height);
		    if (height > columnHeights[highestColumn])
			highestColumn = i;
		}
	    }
	}

	for (int i = 0; i < rows.size(); i++) {
	    for (int j = 0; j < columns.size(); j++) {
		float cellWidth = columnMinSizes[j];
		float cellHeight = rowMinSizes[i];
		if (!usedCells[i][j]) {
		    if (cellWidth > 0) {
			float width = (rowWidths[i] += cellWidth);
			if (width > rowWidths[widestRow])
			    widestRow = i;
		    }
		    if (cellHeight > 0) {
			float height = columnHeights[i] += cellHeight;
			if (height > columnHeights[highestColumn])
			    highestColumn = i;
		    }
		}
	    }
	}

	return new Size(rowWidths[widestRow], columnHeights[highestColumn]);
    }

    private float[] getAbsolute(ArrayList<GridSize> references) { 
	float[] sizes = new float[references.size()]; 
	for (int i = 0; i < sizes.length; i++) {
	    GridSize size = references.get(i);
	    switch (size.mode) {
	    case ABSOLUTE:
		sizes[i] = size.value;
		break;
	    default:
	    case RELATIVE:
		// sizes[i] = 0;
		break;
	    }
	}
	return sizes;
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	float[] rowMaxSizes = makeAbsolute(maxSize.height, rows);
	float[] columnMaxSizes = makeAbsolute(maxSize.width, columns);
	float[] lefts = getSums(columnMaxSizes);
	float[] tops = getSums(rowMaxSizes);
	for (GridCell child : children) {
	    if (child.content != null) {
		int row = clamp(child.row, 0, rows.size() - 1);
		int maxRow = clamp(child.row + child.rowSpan - 1, 0, rows.size() - 1);
		int column = clamp(child.column, 0, columns.size() - 1);
		int maxColumn = clamp(child.column + child.columnSpan - 1, 0, columns.size() - 1);
		float maxWidth = 0;
		float maxHeight = 0;
		for (int i = row; i <= maxRow; i++) {
		    maxHeight += rowMaxSizes[i];
		}
		for (int i = column; i <= maxColumn; i++) {
		    maxWidth += columnMaxSizes[i];
		}
		float left = lefts[column];
		float top = tops[row];
		Rect rect = new Rect(left, top, maxWidth, maxHeight);
		child.content.arrange(rect);
	    }
	}

	return maxSize;
    }

    private float[] getSums(float[] sizes) {
	float[] sum = new float[sizes.length];
	sum[0] = 0;
	for (int i = 1; i < sum.length; i++) {
	    sum[i] = sum[i - 1] + sizes[i - 1];
	}
	return sum;
    }

    private float[] makeAbsolute(float maxSize, ArrayList<GridSize> references) {
	float[] sizes = new float[references.size()];

	float totalRelative = 0;
	float totalAbslute = 0;
	for (int i = 0; i < sizes.length; i++) {
	    GridSize size = references.get(i);
	    switch (size.mode) {
	    case ABSOLUTE:
		totalAbslute += size.value;
		break;
	    default:
	    case RELATIVE:
		totalRelative += size.value;
		break;
	    }
	}
	float maxAbsoluteRemaining = Math.max(0, maxSize - totalAbslute);
	float left = 0;
	for (int i = 0; i < sizes.length; i++) {
	    GridSize size = references.get(i);
	    switch (size.mode) {
	    case ABSOLUTE:
		left += sizes[i] = clamp(maxSize - left, 0, size.value);
		break;
	    default:
	    case RELATIVE:
		left += sizes[i] = size.value / totalRelative * maxAbsoluteRemaining;
		break;
	    }
	}
	return sizes;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	for (GridCell child : children) {
	    if (child.content != null)
		child.content.render(renderer);
	}
    }

    @Override
    public void mouseDown(float x, float y, MouseButton button) {
	for (GridCell child : children) {
	    if (child.content != null)
		child.content.mouseDown(x - child.content.getX(), y - child.content.getY(), button);
	}
    }

    @Override
    public void mouseUp(float x, float y, MouseButton button) {
	for (GridCell child : children) {
	    if (child.content != null)
		if (child.content.hitTest()) {
		    child.content.mouseUp(x - child.content.getX(), y - child.content.getY(), button);
		}
	}
    }

    @Override
    public void mouseMouseMove(float x, float y) {
	for (GridCell child : children) {
	    if (child.content != null)
		if (child.content.hitTest()) {
		    child.content.mouseMouseMove(x - child.content.getX(), y - child.content.getY());
		}
	}
    }

    @Override
    public void mouseEntered(float x, float y) {
	for (GridCell child : children) {
	    if (child.content != null)
		if (child.content.hitTest()) {
		    child.content.setMouseInside(true, x, y);
		} else
		    child.content.setMouseInside(false, x, y);
	}
    }

    @Override
    public void mouseLeft(float x, float y) {
	for (GridCell child : children) {
	    if (child.content != null)
		child.content.setMouseInside(false, x, y);
	}
    }
}

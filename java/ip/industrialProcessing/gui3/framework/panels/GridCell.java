package ip.industrialProcessing.gui3.framework.panels;

import ip.industrialProcessing.gui3.framework.UIElement;

public class GridCell {
    public GridCell(int row, int column, int rowSpan, int columnSpan, UIElement content) {
        this.row = row;
        this.column = column;
        this.rowSpan = rowSpan;
        this.columnSpan = columnSpan;
        this.content = content;
    }

    public GridCell(int row, int column, UIElement content) {
        this(row, column, 1, 1, content);
    }

    public int row;
    public int rowSpan;
    public int column;
    public int columnSpan;
    public UIElement content;
}

package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class ImageTile extends Control {

    private TextureReference texture;
    private int rows;
    private int columns;
    public int index;

    public ImageTile(TextureReference texture, int rows, int columns) {
	this(texture, rows, columns, 0);
    }

    public ImageTile(TextureReference texture, int rows, int columns, int index) {
	this.rows = rows;
	this.columns = columns;
	this.texture = texture;
	this.index = index;
	this.width = texture.size.width / columns;
	this.height = texture.size.height / rows;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {

	int row = index / rows;
	int column = index % rows;

	float u = 1f / rows;
	float v = 1f / columns;

	renderer.drawTexture(size, new Rect(u * column, v * row, u, v), this.texture);
    } 

}

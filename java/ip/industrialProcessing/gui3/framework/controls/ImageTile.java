package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class ImageTile extends Control {

    private TextureReference texture;
    private int rows;
    private int columns;
    public int index;
    private String[] names;

    public ImageTile(TextureReference texture, int rows, int columns, String[] names) {
	this(texture, rows, columns, 0, names);

    }

    public ImageTile(TextureReference texture, int rows, int columns, int index, String[] names) {
	this.rows = rows;
	this.columns = columns;
	this.texture = texture;
	this.index = index;
	this.width = texture.size.width / columns;
	this.height = texture.size.height / rows;
	this.names = names;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
	index %= rows * columns;

	int row = index / columns;
	int column = index % columns;

	float u = 1f / columns;
	float v = 1f / rows;

	Rect rect = new Rect(u * column, v * row, u, v);
	renderer.drawTexture(size, rect, this.texture.resource);
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
	if (names == null)
	    return null;
	return new ToolTip(names[index % names.length]);
    }
}

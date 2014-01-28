package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class StateButtonReference {
    public StateButtonReference(int slot, TextureReference texture, int rows, int columns) {
	this.slot = slot;
	this.texture = texture;
	this.rows = rows;
	this.columns = columns;
    }

    public int slot;
    public TextureReference texture;
    public int rows;
    public int columns;
}

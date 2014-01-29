package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class StateButtonReference {

    public StateButtonReference(int slot, TextureReference texture, int rows, int columns, String[] names) {
	this.slot = slot;
	this.texture = texture;
	this.rows = rows;
	this.columns = columns;
	this.names = names;
    }

    public int slot;
    public TextureReference texture;
    public int rows;
    public int columns;
    public String[] names;
    int handlerIndex;
}

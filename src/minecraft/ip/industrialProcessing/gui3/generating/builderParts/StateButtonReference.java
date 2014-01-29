package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.containers.handlers.StateHandler;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class StateButtonReference {

    public StateButtonReference(int index, TextureReference texture, int rows, int columns, String[] names) {
	this.index = index;
	this.texture = texture;
	this.rows = rows;
	this.columns = columns;
	this.names = names;
    }

    public int index;
    public TextureReference texture;
    public int rows;
    public int columns;
    public String[] names;
    StateHandler handler; 
}

package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.containers.handlers.StateHandler;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;

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

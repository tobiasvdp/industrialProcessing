package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.containers.handlers.StateHandler;

public class SpinnerReference {
    public SpinnerReference(int slot, String format, float scale, float width) {
	this.index = slot;
	this.format = format;
	this.scale = scale;
	this.width = width;
    }

    public SpinnerReference(int slot) {
	this(slot, "%.0f", 1f, 18f);
    }

    public int index;
    public String format;
    public float scale;
    public float width;
    StateHandler handler;
}

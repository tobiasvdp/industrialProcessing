package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.containers.handlers.ProgressHandler;

public class GaugeReference {
    public GaugeReference(String name, String format, int index, boolean showName) {
	this.name = name;
	this.format = format;
	this.slotIndex = index;
	this.showName = showName;
    }

    public String name;
    public boolean showName;
    public String format;
    public int slotIndex;
    public ProgressHandler handler;
}

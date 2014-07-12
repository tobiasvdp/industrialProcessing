package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.containers.handlers.ProgressHandler;

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

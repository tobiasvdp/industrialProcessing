package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.containers.handlers.PowerHandler;
import mod.industrialProcessing.gui.framework.slots.SlotBase;

public class PowerReference {

	public PowerReference(int batterySlot) {
		this.index = batterySlot;
	}

	public PowerReference() {
		this(-1);
	}

	public int index;
	SlotBase slot;
	PowerHandler powerHandler;

}

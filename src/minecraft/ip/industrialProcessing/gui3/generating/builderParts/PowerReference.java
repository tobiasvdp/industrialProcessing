package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.containers.handlers.PowerHandler;
import ip.industrialProcessing.slots.SlotBase;

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

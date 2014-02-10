package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.containers.handlers.BurnerHandler;
import net.minecraft.inventory.Slot;

public class BurnerReference {

    public int lighterSlotIndex;
    public int fuelSlotIndex;
    public int ashSlotIndex;
    BurnerHandler progressHandler;
    Slot ashSlot;
    Slot fuelSlot;
    Slot lighterSlot;

    public BurnerReference(int lighterSlot, int fuelSlot, int ashSlot) {
	this.lighterSlotIndex = lighterSlot;
	this.fuelSlotIndex = fuelSlot;
	this.ashSlotIndex = ashSlot;
    }

}

package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.framework.panels.Orientation;
import net.minecraft.inventory.Slot;

public class SlotClusterReference {

    public int startSlot;
    public int slotCount;
    public int size;
    public Orientation orientation;
    Slot[] slots;

    public SlotClusterReference(int startSlot, int slotCount, int size, Orientation orientation) {
	this.startSlot = startSlot;
	this.slotCount = slotCount;
	this.size = size;
	this.orientation = orientation;
    }

    public SlotClusterReference(int slot) {
	this(slot, 1, 0, null);
    }
}

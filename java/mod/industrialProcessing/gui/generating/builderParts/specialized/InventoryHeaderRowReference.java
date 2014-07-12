package mod.industrialProcessing.gui.generating.builderParts.specialized;

import net.minecraft.inventory.Slot;

public class InventoryHeaderRowReference {

    public int headerSlotIndex;
    public int firstSlotIndex;
    public int slotCount;
    public int size; 
    Slot headerSlot;
    Slot[] slots;

    public InventoryHeaderRowReference(int headerSlot, int firstSlot, int slotCount, int size) {
	this.headerSlotIndex = headerSlot;
	this.firstSlotIndex = firstSlot;
	this.slotCount = slotCount;
	this.size = size; 
    }

}

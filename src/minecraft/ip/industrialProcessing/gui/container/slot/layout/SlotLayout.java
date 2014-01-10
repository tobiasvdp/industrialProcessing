package ip.industrialProcessing.gui.container.slot.layout;

import java.awt.Rectangle;

import ip.industrialProcessing.slots.SlotBase;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotLayout {
	
	protected Rectangle rect;
	protected Slot[] slots;
	protected SlotLayoutType layout;

	public SlotBase[] getGuiContainerSlots(IInventory iinventory) {
		SlotBase[] slots = new SlotBase[this.slots.length];
		for(int i = 0;i<slots.length;i++){
			slots[i] = new SlotBase(iinventory, this.slots[i].getSlotIndex(), this.slots[i].xDisplayPosition + rect.x, this.slots[i].yDisplayPosition + rect.y);
		}
		return slots;
	}
	
	public Slot[] getGuiContainerLayout() {		
		return slots;
	}
}

package ip.industrialProcessing.gui.container.slot.layout;

import ip.industrialProcessing.slots.SlotBase;
import net.minecraft.inventory.IInventory;

public class SlotLayout {
	
	protected int offsetX;
	protected int offsetY;
	protected int sizeX;
	protected int sizeY;
	protected SlotBase[] slots;
	protected SlotLayoutType layout;

	public SlotBase[] getGuiContainerSlots(IInventory iinventory) {
		SlotBase[] slots = new SlotBase[this.slots.length];
		for(int i = 0;i<slots.length;i++){
			slots[i] = new SlotBase(iinventory, this.slots[i].getSlotIndex(), this.slots[i].xDisplayPosition + offsetX, this.slots[i].yDisplayPosition + offsetY);
		}
		return slots;
	}
	
	public SlotBase[] getGuiContainerLayout() {		
		return slots;
	}
}

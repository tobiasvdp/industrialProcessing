package ip.industrialProcessing.gui.container.slot.layout;

import ip.industrialProcessing.slots.SlotArmor;
import ip.industrialProcessing.slots.SlotBase;

import java.awt.Rectangle;

import net.minecraft.entity.Entity;
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

	public Slot[] getGuiContainerSlots(IInventory iinventory, Entity player) {
		SlotBase[] slots = new SlotBase[this.slots.length];
		for(int i = 0;i<slots.length;i++){
			if(this.slots[i] instanceof SlotArmor){
				slots[i] = new SlotArmor(player, iinventory,this.slots[i].getSlotIndex(), this.slots[i].xDisplayPosition + rect.x, this.slots[i].yDisplayPosition + rect.y,((SlotArmor)this.slots[i]).armorType);
			}else{
			     slots[i] = new SlotBase(iinventory, this.slots[i].getSlotIndex(), this.slots[i].xDisplayPosition + rect.x, this.slots[i].yDisplayPosition + rect.y);
			}
		}
		return slots;
	}
}

package ip.industrialProcessing.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBase extends Slot {

	public SlotBase(IInventory iinventory, int slotIndex, int posX, int posY) {
		super(iinventory, slotIndex, posX, posY);
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		return inventory.isItemValidForSlot(this.getSlotIndex(), par1ItemStack);
	}

}

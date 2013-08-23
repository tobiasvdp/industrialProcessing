package ip.industrialProcessing.machines;

import net.minecraft.item.ItemStack;

public interface IMachineSlots {
	boolean slotContains(int slot, int itemId, int amount);

	boolean slotHasRoomFor(int slot, ItemStack stack);
	boolean slotHasRoomFor(int slot, int itemId, int amount);
	
	boolean addToSlot(int index, int itemId, int maxAmount);
	boolean removeFromSlot(int index, int itemId, int maxAmount);
	boolean damageItem(int slot, int itemId);
}

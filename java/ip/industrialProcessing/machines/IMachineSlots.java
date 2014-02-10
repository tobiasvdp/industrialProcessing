package ip.industrialProcessing.machines;

import net.minecraft.item.ItemStack;

public interface IMachineSlots {
	boolean slotContains(int slot, int itemId, int amount);
	boolean slotContains(int slot, int itemId, int metadata,int amount);

	boolean slotHasRoomFor(int slot, ItemStack stack);
	boolean slotHasRoomFor(int slot, int itemId, int amount, int damage);
	
	boolean addToSlot(int index, int itemId, int maxAmount, int damage);
	boolean removeFromSlot(int index, int itemId, int maxAmount);
	boolean damageItem(int slot, int itemId);
	
	public MachineItemStack getMachineStack(int i);
	
	public int getSizeInventory();
}

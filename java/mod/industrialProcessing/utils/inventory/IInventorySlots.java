package mod.industrialProcessing.utils.inventory;

import mod.industrialProcessing.utils.inventory.itemstack.MachineItemStack;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface IInventorySlots extends ISidedInventory{
	boolean slotContains(int slot, Item item, int amount);
	boolean slotContains(int slot, Item item, int metadata,int amount);

	boolean slotHasRoomFor(int slot, ItemStack stack);
	boolean slotHasRoomFor(int slot, Item item, int amount, int damage);
	 
	//boolean addToSlot(int index, Item item, int maxAmount, int damage);
	boolean addToSlot(int index, ItemStack stack);
	
	boolean removeFromSlot(int index, int maxAmount);
	boolean damageItem(int slot);
	
	
	
	public MachineItemStack getMachineStack(int i);
	
	public int getSizeInventory();
}

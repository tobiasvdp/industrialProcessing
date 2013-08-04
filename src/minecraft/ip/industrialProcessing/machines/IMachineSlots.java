package ip.industrialProcessing.machines;

import net.minecraft.item.ItemStack;

public interface IMachineSlots {
	boolean slotContains(int slot, int itemId, int amount);

	boolean slotHasRoomFor(int slot, ItemStack stack);
}

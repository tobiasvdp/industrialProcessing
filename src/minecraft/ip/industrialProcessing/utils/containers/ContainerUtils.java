package ip.industrialProcessing.utils.containers;

import ip.industrialProcessing.machines.filter.ContainerFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public final class ContainerUtils {

	public static void BindPlayerInventory(InventoryPlayer inventoryPlayer,
			IContainerAdd container, int offset) {

		for (int i = 0; i < 9; i++) {
			container.containerAddSlot(new Slot(inventoryPlayer, i + offset,
					8 + i * 18, 142));
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int o = j + i * 9 + 9 + offset;
				container.containerAddSlot(new Slot(inventoryPlayer, o,
						8 + j * 18, 84 + i * 18));
			}
		}
	}

	public static ItemStack TransferStackInSlot(EntityPlayer player, int slot,
			IInventory tileEntity, IContainerTransfer container) {
		Slot slotObject = container.containerGetSlot(slot);
		ItemStack stack = null;

		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			if (slotObject.inventory.equals(player.inventory)) {
				// from EntityPlayer to TileEntity
				if (!container
						.containerMergeItemStack(stackInSlot, 0, 9, false)) {
					return null;
				}
			} else { 
				// from TileEntity to EntityPlayer
				if (!container
						.containerMergeItemStack(stackInSlot, 0, 35, true)) {
					return null;
				}
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}
}

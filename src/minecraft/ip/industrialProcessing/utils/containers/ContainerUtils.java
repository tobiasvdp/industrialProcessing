package ip.industrialProcessing.utils.containers;

import ip.industrialProcessing.machines.filter.ContainerFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public final class ContainerUtils {

	public static void BindPlayerInventory(InventoryPlayer inventoryPlayer, IContainerAdd container) {
 
		for (int i = 0; i < 9; i++) {
			container.containerAddSlot(new Slot(inventoryPlayer, i, 8 + i * 18,
					142));
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int o = j + i * 9 + 9;
				container.containerAddSlot(new Slot(inventoryPlayer, o,
						8 + j * 18, 84 + i * 18));
			}
		} 
	}

	public static ItemStack TransferStackInSlot(EntityPlayer player, int slot, IInventory tileEntity, IContainerTranster container) {
		Slot slotObject = container.containerGetSlot(slot);
        ItemStack stack = null;
        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
                ItemStack stackInSlot = slotObject.getStack();
                stack = stackInSlot.copy();

                //merges the item into player inventory since its in the tileEntity
                if (slotObject.slotNumber < 9) {
                        if (!container.containerMergeItemStack(stackInSlot, 0, 35, true)) {
                                return null;
                        }
                }
                //places it into the tileEntity is possible since its in the player inventory
                else if (!container.containerMergeItemStack(stackInSlot, 0, 9, false)) {
                        return null;
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

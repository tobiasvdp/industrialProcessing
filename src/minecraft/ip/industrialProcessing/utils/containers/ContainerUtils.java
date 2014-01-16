package ip.industrialProcessing.utils.containers;

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

	public static ItemStack TransferStackInSlot(EntityPlayer player, int slotId,IInventory tileEntity, IContainerTransfer container) {
		return null;

	}
}

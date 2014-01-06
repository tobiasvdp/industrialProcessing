package ip.industrialProcessing.multiblock.gui;

import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TileEntityMultiblockWeldingStation;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import ip.industrialProcessing.utils.containers.VerifyingContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class CTmultiblock extends VerifyingContainer {

	protected Slot[] slots;

	public CTmultiblock(InventoryPlayer inventory, TileEntityMultiblockCore entity) {

	}

	protected void BindPlayerInventory(InventoryPlayer inventoryPlayer, CTmultiblock container, int offset) {

		for (int i = 0; i < 9; i++) {
			container.addSlotToContainer(new Slot(inventoryPlayer, i + offset, 8 + i * 18, 142));
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int o = j + i * 9 + 9 + offset;
				container.addSlotToContainer(new Slot(inventoryPlayer, o, 8 + j * 18, 84 + i * 18));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	protected boolean canPutItemStackInSlot(ItemStack stack, Slot slot) {
		return true;
	}

	public void BindSlots(Slot[] slots, InventoryPlayer inventory, CTmultiblock me) {
		for(int i = 0;i<slots.length;i++){
			me.addSlotToContainer(slots[i]);
		}
		BindPlayerInventory(inventory, me, 0);
	}
}

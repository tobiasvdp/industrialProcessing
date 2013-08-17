package ip.industrialProcessing.multiblock.extended.inventory;

import ip.industrialProcessing.multiblock.machine.crusher.TileEntityMultiblockCrusher;
import ip.industrialProcessing.slots.SlotBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMultiblockBlockInv  extends Container{

	private TileEntityMultiblockBlockInv tileEntity;

	public ContainerMultiblockBlockInv(InventoryPlayer inventoryPlayer, TileEntityMultiblockBlockInv entity) {
		tileEntity = entity;
		BindPlayerInventory(inventoryPlayer, this, 0);
	}

	public void BindPlayerInventory(InventoryPlayer inventoryPlayer, Container container, int offset) {

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i + offset, 8 + i * 18, 142));
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int o = j + i * 9 + 9 + offset;
				addSlotToContainer(new Slot(inventoryPlayer, o, 8 + j * 18, 84 + i * 18));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		Slot slot = (Slot) this.inventorySlots.get(par2);
		return slot != null ? slot.getStack() : null;
	}

}
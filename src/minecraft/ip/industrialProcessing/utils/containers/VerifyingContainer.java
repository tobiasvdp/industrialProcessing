package ip.industrialProcessing.utils.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class VerifyingContainer extends Container {

	protected abstract boolean canPutItemStackInSlot(ItemStack stack, Slot slot);

	@Override
	protected boolean mergeItemStack(ItemStack par1ItemStack, int par2,
			int par3, boolean par4) {
		boolean flag1 = false;

		int k = par2;

		if (par4) {
			k = par3 - 1;
		}
		Slot slot;
		ItemStack itemstack1;

		if (par1ItemStack.isStackable()) {
			while (par1ItemStack.stackSize > 0
					&& (!par4 && k < par3 || par4 && k >= par2)) {
				slot = (Slot) this.inventorySlots.get(k);
				itemstack1 = slot.getStack();
				boolean toPlayerSlot = par4
						&& slot.inventory instanceof InventoryPlayer;
				if (itemstack1 != null
						&& itemstack1.itemID == par1ItemStack.itemID
						&& (!par1ItemStack.getHasSubtypes() || par1ItemStack
								.getItemDamage() == itemstack1.getItemDamage())
						&& ItemStack.areItemStackTagsEqual(par1ItemStack,
								itemstack1)) {
					int l = itemstack1.stackSize + par1ItemStack.stackSize;

					if (toPlayerSlot
							|| canPutItemStackInSlot(par1ItemStack, slot)) {
						if (l <= par1ItemStack.getMaxStackSize()) {
							par1ItemStack.stackSize = 0;
							itemstack1.stackSize = l;
							slot.onSlotChanged();
							flag1 = true;
						} else if (itemstack1.stackSize < par1ItemStack
								.getMaxStackSize()) {
							par1ItemStack.stackSize -= par1ItemStack
									.getMaxStackSize() - itemstack1.stackSize;
							itemstack1.stackSize = par1ItemStack
									.getMaxStackSize();
							slot.onSlotChanged();
							flag1 = true;
						}
					}
				}

				if (par4) {
					--k;
				} else {
					++k;
				}
			}
		}

		if (par1ItemStack.stackSize > 0) {
			if (par4) {
				k = par3 - 1;
			} else {
				k = par2;
			}

			while (!par4 && k < par3 || par4 && k >= par2) {
				slot = (Slot) this.inventorySlots.get(k);
				itemstack1 = slot.getStack();
				boolean toPlayerSlot = par4
						&& slot.inventory instanceof InventoryPlayer;

				if (itemstack1 == null
						&& (toPlayerSlot || canPutItemStackInSlot(
								par1ItemStack, slot))) {
					slot.putStack(par1ItemStack.copy());
					slot.onSlotChanged();
					par1ItemStack.stackSize = 0;
					flag1 = true;
					break;
				}

				if (par4) {
					--k;
				} else {
					++k;
				}
			}
		}

		return flag1;
	}

}

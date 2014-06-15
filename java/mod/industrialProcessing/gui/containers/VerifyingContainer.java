package mod.industrialProcessing.gui.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class VerifyingContainer extends Container {

    protected abstract boolean canPutItemStackInSlot(ItemStack stack, Slot slot);

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack originalStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);
        int numSlots = inventorySlots.size();
        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            originalStack = stackInSlot.copy();
            if (slotIndex >= numSlots - 9 * 4 && tryShiftItem(stackInSlot, numSlots)) {
                // NOOP
            } else if (slotIndex >= numSlots - 9 * 4 && slotIndex < numSlots - 9) {
                if (!shiftItemStack(stackInSlot, numSlots - 9, numSlots)) {
                    return null;
                }
            } else if (slotIndex >= numSlots - 9 && slotIndex < numSlots) {
                if (!shiftItemStack(stackInSlot, numSlots - 9 * 4, numSlots - 9)) {
                    return null;
                }
            } else if (!shiftItemStack(stackInSlot, numSlots - 9 * 4, numSlots)) {
                return null;
            }
            slot.onSlotChange(stackInSlot, originalStack);
            if (stackInSlot.stackSize <= 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (stackInSlot.stackSize == originalStack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(player, stackInSlot);
        }
        return originalStack;
    }

    private boolean tryShiftItem(ItemStack stackToShift, int numSlots) {
        for (int machineIndex = 0; machineIndex < numSlots - 9 * 4; machineIndex++) {
            Slot slot = (Slot) inventorySlots.get(machineIndex);
            if (!slot.isItemValid(stackToShift)) {
                continue;
            }
            if (shiftItemStack(stackToShift, slot.slotNumber, slot.slotNumber + 1)) {
                return true;
            }
        }
        return false;
    }

    protected boolean shiftItemStack(ItemStack stackToShift, int start, int end) {
        boolean changed = false;
        if (stackToShift.isStackable()) {
            for (int slotIndex = start; stackToShift.stackSize > 0 && slotIndex < end; slotIndex++) {
                Slot slot = (Slot) inventorySlots.get(slotIndex);
                ItemStack stackInSlot = slot.getStack();
                if (stackInSlot != null && canStacksMerge(stackInSlot, stackToShift)) {
                    if (slot.inventory.isItemValidForSlot(slotIndex, stackToShift)) {
                        int resultingStackSize = stackInSlot.stackSize + stackToShift.stackSize;
                        int max = Math.min(stackToShift.getMaxStackSize(), slot.getSlotStackLimit());
                        if (resultingStackSize <= max) {
                            stackToShift.stackSize = 0;
                            stackInSlot.stackSize = resultingStackSize;
                            slot.onSlotChanged();
                            changed = true;
                        } else if (stackInSlot.stackSize < max) {
                            stackToShift.stackSize -= max - stackInSlot.stackSize;
                            stackInSlot.stackSize = max;
                            slot.onSlotChanged();
                            changed = true;
                        }
                    }
                }
            }
        }
        if (stackToShift.stackSize > 0) {
            for (int slotIndex = start; stackToShift.stackSize > 0 && slotIndex < end; slotIndex++) {
                Slot slot = (Slot) inventorySlots.get(slotIndex);
                ItemStack stackInSlot = slot.getStack();
                if (stackInSlot == null) {
                    if (slot.inventory.isItemValidForSlot(slotIndex, stackToShift)) {
                        int max = Math.min(stackToShift.getMaxStackSize(), slot.getSlotStackLimit());
                        stackInSlot = stackToShift.copy();
                        stackInSlot.stackSize = Math.min(stackToShift.stackSize, max);
                        stackToShift.stackSize -= stackInSlot.stackSize;
                        slot.putStack(stackInSlot);
                        slot.onSlotChanged();
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }

    private boolean canStacksMerge(ItemStack stackInSlot, ItemStack stackToShift) {
        if (stackInSlot == null || stackToShift == null)
            return false;
        if (!stackInSlot.isItemEqual(stackToShift))
            return false;
        if (!ItemStack.areItemStackTagsEqual(stackInSlot, stackToShift))
            return false;
        return true;
    }

    public int getSizeInventory() {
        return 0;
    }

    @Override
    protected boolean mergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4) {
        {
            boolean flag1 = false;
            int k = par2;

            if (par4) {
                k = par3 - 1;
            }

            Slot slot;
            ItemStack itemstack1;

            if (par1ItemStack.isStackable()) {
                while (par1ItemStack.stackSize > 0 && (!par4 && k < par3 || par4 && k >= par2)) {
                    slot = (Slot) this.inventorySlots.get(k);
                    itemstack1 = slot.getStack();

                    if (itemstack1 != null && itemstack1.getItem().equals(par1ItemStack.getItem()) && (!par1ItemStack.getHasSubtypes() || par1ItemStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(par1ItemStack, itemstack1)) {
                        int l = itemstack1.stackSize + par1ItemStack.stackSize;

                        if (l <= par1ItemStack.getMaxStackSize()) {
                            par1ItemStack.stackSize = 0;
                            itemstack1.stackSize = l;
                            slot.onSlotChanged();
                            flag1 = true;
                        } else if (itemstack1.stackSize < par1ItemStack.getMaxStackSize()) {
                            par1ItemStack.stackSize -= par1ItemStack.getMaxStackSize() - itemstack1.stackSize;
                            itemstack1.stackSize = par1ItemStack.getMaxStackSize();
                            slot.onSlotChanged();
                            flag1 = true;
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

                    if (itemstack1 == null) {
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
}

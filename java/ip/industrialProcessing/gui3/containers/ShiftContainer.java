package ip.industrialProcessing.gui3.containers;

import ip.industrialProcessing.utils.ItemTransfers;
import ip.industrialProcessing.utils.containers.VerifyingContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class ShiftContainer extends VerifyingContainer {

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        Slot slot = (Slot) this.inventorySlots.get(slotIndex);
        IInventory inventory = slot.inventory;
        ItemStack stack = slot.getStack();
        if (inventory.equals(player.inventory)) {

            System.out.println("// move from inventory to machine");
            stack = transfer(stack, true);
        } else {

            System.out.println("// move from machine to inventory");
            stack = transfer(stack, false);
        }

        slot.putStack(stack);
        return null; 
    }

    private ItemStack transfer(ItemStack stack, boolean b) {
        if (b) {
            for (int i = 0; i < this.inventorySlots.size(); i++) {
                stack = transfer(stack, (Slot) this.inventorySlots.get(i));
            }
        } else {
            for (int i = this.inventorySlots.size() - 1; i >= 0; i--) {
                stack = transfer(stack, (Slot) this.inventorySlots.get(i));
            }
        }
        return stack;
    }

    private ItemStack transfer(ItemStack stack, Slot slot) {
        return ItemTransfers.transfer(stack, slot);
    }
}

package ip.industrialProcessing.machines.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public interface IMachineContainerEntity extends IInventory {
    boolean canInsertItem(int index, ItemStack stack, int size);
}

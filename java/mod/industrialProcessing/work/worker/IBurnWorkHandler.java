package mod.industrialProcessing.work.worker;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;

public interface IBurnWorkHandler extends IWorkHandler, IInventory {

    int getFuelSlot();

    int getAshSlot();

    void addToSlot(int slot, Item item, int i);

}

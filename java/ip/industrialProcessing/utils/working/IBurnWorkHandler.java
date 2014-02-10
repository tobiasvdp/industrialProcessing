package ip.industrialProcessing.utils.working;

import net.minecraft.inventory.IInventory;

public interface IBurnWorkHandler extends IWorkHandler, IInventory {

    int getFuelSlot();

    int getAshSlot();

    void addToSlot(int slot, int itemID, int i);

}

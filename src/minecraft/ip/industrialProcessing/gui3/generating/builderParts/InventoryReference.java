package ip.industrialProcessing.gui3.generating.builderParts;

import net.minecraft.inventory.Slot;

public class InventoryReference {

    public InventoryReference(boolean showArmor) {
	this.showArmor = showArmor;
    }

    Slot[] inventorySlots;
    Slot[] hotbarSlots;
    Slot[] armorSlots;
    Slot[] craftingSlots;
    public boolean showArmor;

}

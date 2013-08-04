package ip.industrialProcessing.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotOutput extends SlotBase {

	public SlotOutput(IInventory iinventory, int slotIndex, int posX, int posY) {
		super(iinventory, slotIndex, posX, posY);
	}

	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		return false;
	}
}

package ip.industrialProcessing.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotLiquidOutput extends SlotLiquid {

	public SlotLiquidOutput(IInventory iinventory, int slotIndex, int posX,
			int posY) {
		super(iinventory, slotIndex, posX, posY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		return false;
	}
}

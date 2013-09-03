package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.gui.CTmultiblock;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;

public class CTWeldingStation extends CTmultiblock {

	public CTWeldingStation(InventoryPlayer inventory, TEmultiblockCoreInv entity) {
		super(inventory, entity);

		slots = new Slot[2];
		slots[0] = new SlotBase(entity, 0, 44, 33);
		slots[1] = new SlotOutput(entity, 1, 104, 33);

		BindSlots(slots, inventory, this);
	}
}

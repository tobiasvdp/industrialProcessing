package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.CTmultiblock;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;

public class CTWeldingStation extends CTmultiblock {

	public CTWeldingStation(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered entity) {
		super(inventory, entity);

		slots = new Slot[14];
		slots[0] = new SlotBase(entity, 0, 33, 15);
		slots[1] = new SlotBase(entity, 1, 51, 15);
		slots[2] = new SlotBase(entity, 2, 69, 15);
		slots[3] = new SlotBase(entity, 3, 33, 33);
		slots[4] = new SlotBase(entity, 4, 51, 33);
		slots[5] = new SlotBase(entity, 5, 69, 33);
		slots[6] = new SlotBase(entity, 6, 33, 51);
		slots[7] = new SlotBase(entity, 7, 51, 51);
		slots[8] = new SlotBase(entity, 8, 69, 51);
		slots[9] = new SlotBase(entity, 9, 176, 6);
		slots[10] = new SlotBase(entity, 10, 176, 25);
		slots[11] = new SlotBase(entity, 11, 176, 44);
		slots[12] = new SlotBase(entity, 12, 176, 63);
		slots[13] = new SlotOutput(entity, 13, 143, 33);

		BindSlots(slots, inventory, this);
	}
}

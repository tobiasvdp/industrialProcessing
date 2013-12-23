package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;

public class ContainerWeldingStation extends ContainerMultiblockTankWorkerPowered {
	private Slot[] slots;

	public ContainerWeldingStation(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered core) {
		super(inventory, core);

		slots = new SlotBase[15];
		slots[0] = new SlotBase(core, 0, 58, 15);
		slots[1] = new SlotBase(core, 1, 76, 15);
		slots[2] = new SlotBase(core, 2, 94, 15);
		slots[3] = new SlotBase(core, 3, 58, 33);
		slots[4] = new SlotBase(core, 4, 76, 33);
		slots[5] = new SlotBase(core, 5, 94, 33);
		slots[6] = new SlotBase(core, 6, 58, 51);
		slots[7] = new SlotBase(core, 7, 76, 51);
		slots[8] = new SlotBase(core, 8, 94, 51);
		slots[9] = new SlotBase(core, 9, 176, 6);
		slots[10] = new SlotBase(core, 10, 176, 25);
		slots[11] = new SlotBase(core, 11, 176, 44);
		slots[12] = new SlotBase(core, 12, 176, 63);
		slots[13] = new SlotOutput(core, 13, 152, 33);
		slots[14] = new SlotBase(core, 14, 26, 51);

		BindSlots(slots, inventory, this);

		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}

}

package ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorker;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerBloomery extends ContainerMultiblockTankWorker {
	private Slot[] slots;

	public ContainerBloomery(InventoryPlayer inventory, TEmultiblockCoreTankWorker core) {
		super(inventory, core);

		slots = new SlotBase[3];
		slots[0] = new SlotBase(core, 0, 78, 33);
		slots[1] = new SlotOutput(core, 1, 136, 33);
		slots[2] = new SlotBase(core, 2, 26, 51);
		

		BindSlots(slots, inventory, this);

		addWorkerToContainer(core.getWorker());
	}

}

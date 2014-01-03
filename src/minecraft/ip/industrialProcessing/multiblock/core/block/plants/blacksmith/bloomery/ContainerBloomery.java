package ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorker;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerBloomery extends ContainerMultiblockTankWorker {
	private Slot[] slots;

	public ContainerBloomery(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorker core) {
		super(inventory, core);

		if (core.getTier() == Tiers.Tier0) {
			slots = new SlotBase[3];
			slots[0] = new SlotBase(core, 0, 78, 33);
			slots[1] = new SlotOutput(core, 1, 136, 33);
			slots[2] = new SlotBase(core, 2, 26, 51);
		} else if (core.getTier() == Tiers.Tier1){
			slots = new SlotBase[5];
			slots[0] = new SlotBase(core, 0, 69, 42);
			slots[1] = new SlotOutput(core, 1, 136, 33);
			slots[2] = new SlotBase(core, 2, 26, 51);
			slots[3] = new SlotBase(core, 3, 60, 24);
			slots[4] = new SlotBase(core, 4, 78, 24);
		}

		BindSlots(slots, inventory, this);

		addWorkerToContainer(core.getWorker());
	}

}

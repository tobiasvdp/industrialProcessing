package ip.industrialProcessing.multiblock.core.block.plants.storage.container;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockInv;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorker;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerContainer extends ContainerMultiblockInv {
	private Slot[] slots;

	public ContainerContainer(InventoryPlayer inventory, TileEntityMultiblockCoreInv core) {
		super(inventory, core);

		slots = new SlotBase[117];
		int count = 0;
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 13; i++) {
				slots[count] = new SlotBase(core, count++, 13 + i*18, 8+ j*18);
			}
		}

		BindSlots(slots, inventory, this, 41, 91);
	}
}

package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;

public class ContainerMultiblockBlastFurnace extends ContainerMultiblockTankWorkerPowered {
	public ContainerMultiblockBlastFurnace(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered core){
		super(inventory, core);
		
		Slot[] slots = new Slot[2];		
		slots[0] = new SlotBase(core, 0, 35, 22);
		slots[1] = new SlotOutput(core, 1, 35, 49);
		
		addSlotToContainer(slots[0]);
		addSlotToContainer(slots[1]);
		
		BindPlayerInventory(inventory, this, 0);
		
		addTankToContainer(0);
		addTankToContainer(1);
		addTankToContainer(2);
		addTankToContainer(3);
		
		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
}

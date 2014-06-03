package mod.industrialProcessing.plants.todo.core.blastFurnace;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.slots.SlotBase;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerMultiblockBlastFurnace extends ContainerMultiblockTankWorkerPowered {
	public ContainerMultiblockBlastFurnace(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core);
		
		Slot[] slots = new Slot[2];		
		slots[0] = new SlotBase(core, 0, 35, 22);
		slots[1] = new SlotBase(core, 1, 35, 49);
		
		addSlotToContainer(slots[0]);
		addSlotToContainer(slots[1]);
		
		BindPlayerInventory(inventory, this, 0,0,0);
		
		addTankToContainer(0);
		addTankToContainer(1);
		addTankToContainer(2);
		addTankToContainer(3);
		
		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
}

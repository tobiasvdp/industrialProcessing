package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.slots.SlotBase;

public class ContainerMultiblockWeldingStation extends ContainerMultiblockCoreInv {

	public ContainerMultiblockWeldingStation(InventoryPlayer inventoryPlayer, TileEntityMultiblockWeldingStation tileEntity) {
		super(inventoryPlayer, tileEntity);
		slots = new Slot[5];
		slots[0] = new SlotBase(tileEntity, 0, 44, 35);
		slots[1] = new SlotBase(tileEntity, 1, 20, 35);
		slots[2] = new SlotBase(tileEntity, 2, 135, 35);


		addSlotToContainer(slots[0]);
		addSlotToContainer(slots[1]);
		addSlotToContainer(slots[2]);
		
		BindPlayerInventory(inventoryPlayer, this, 0);
	}

}

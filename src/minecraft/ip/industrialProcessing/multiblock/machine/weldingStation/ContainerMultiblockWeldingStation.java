package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.slots.SlotBase;

public class ContainerMultiblockWeldingStation extends ContainerMultiblockCoreInv {

	public ContainerMultiblockWeldingStation(InventoryPlayer inventoryPlayer, TileEntityMultiblockWeldingStation tileEntity) {
		super(inventoryPlayer, tileEntity);
		slots = new Slot[12];
		slots[0] = new SlotBase(tileEntity, 0, 8, 19);
		slots[1] = new SlotBase(tileEntity, 1, 8, 53);
		slots[2] = new SlotBase(tileEntity, 2, 33, 18);
		slots[3] = new SlotBase(tileEntity, 3, 33, 36);
		slots[4] = new SlotBase(tileEntity, 3, 33, 54);
		slots[5] = new SlotBase(tileEntity, 3, 51, 18);
		slots[6] = new SlotBase(tileEntity, 3, 51, 36);
		slots[7] = new SlotBase(tileEntity, 3, 51, 54);
		slots[8] = new SlotBase(tileEntity, 3, 69, 18);
		slots[9] = new SlotBase(tileEntity, 3, 69, 36);
		slots[10] = new SlotBase(tileEntity, 3, 69, 54);
		slots[11] = new SlotBase(tileEntity, 11, 152, 34);


		addSlotToContainer(slots[0]);
		addSlotToContainer(slots[1]);
		addSlotToContainer(slots[2]);
		addSlotToContainer(slots[3]);
		addSlotToContainer(slots[4]);
		addSlotToContainer(slots[5]);
		addSlotToContainer(slots[6]);
		addSlotToContainer(slots[7]);
		addSlotToContainer(slots[8]);
		addSlotToContainer(slots[9]);
		addSlotToContainer(slots[10]);
		addSlotToContainer(slots[11]);
		
		BindPlayerInventory(inventoryPlayer, this, 0);
	}

}

package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.slots.SlotBase;

public class ContainerMultiblockWeldingStation extends ContainerMultiblockCoreInv {

	public ContainerMultiblockWeldingStation(InventoryPlayer inventoryPlayer, TileEntityMultiblockWeldingStation tileEntity) {
		super(inventoryPlayer, tileEntity);
		int offset = -11;
		slots = new Slot[16];
		slots[0] = new SlotBase(tileEntity, 0, 8+offset, 19);
		slots[1] = new SlotBase(tileEntity, 1, 8+offset, 53);
		slots[2] = new SlotBase(tileEntity, 2, 33+offset, 15);
		slots[3] = new SlotBase(tileEntity, 3, 33+offset, 33);
		slots[4] = new SlotBase(tileEntity, 4, 33+offset, 51);
		slots[5] = new SlotBase(tileEntity, 5, 51+offset, 15);
		slots[6] = new SlotBase(tileEntity, 6, 51+offset, 33);
		slots[7] = new SlotBase(tileEntity, 7, 51+offset, 51);
		slots[8] = new SlotBase(tileEntity, 8, 69+offset, 15);
		slots[9] = new SlotBase(tileEntity, 9, 69+offset, 33);
		slots[10] = new SlotBase(tileEntity, 10, 69+offset, 51);
		slots[11] = new SlotBase(tileEntity, 11, 143+offset, 33);
		
		slots[12] = new SlotBase(tileEntity, 12, 176+offset, 6);
		slots[13] = new SlotBase(tileEntity, 13, 176+offset, 25);
		slots[14] = new SlotBase(tileEntity, 14, 176+offset, 44);
		slots[15] = new SlotBase(tileEntity, 15, 176+offset, 63);


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
		
		addSlotToContainer(slots[12]);
		addSlotToContainer(slots[13]);
		addSlotToContainer(slots[14]);
		addSlotToContainer(slots[15]);
		
		BindPlayerInventory(inventoryPlayer, this, offset,0);
	}

}

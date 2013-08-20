package ip.industrialProcessing.multiblock.machine.mixer;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.slots.SlotBase;

public class ContainerMultiblockMixer extends ContainerMultiblockCoreInv{

	public ContainerMultiblockMixer(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv tileEntity) {
		super(inventoryPlayer, tileEntity);
		
		slots = new Slot[5];
		slots[0] = new SlotBase(tileEntity, 0, 44, 35);
		slots[1] = new SlotBase(tileEntity, 1, 8, 19);
		slots[2] = new SlotBase(tileEntity, 2, 8, 53);
		slots[3] = new SlotBase(tileEntity, 3, 152, 19);
		slots[4] = new SlotBase(tileEntity, 4, 152, 53);


		addSlotToContainer(slots[0]);
		addSlotToContainer(slots[1]);
		addSlotToContainer(slots[2]);
		addSlotToContainer(slots[3]);
		addSlotToContainer(slots[4]);
		
		BindPlayerInventory(inventoryPlayer, this, 0);
	}


}
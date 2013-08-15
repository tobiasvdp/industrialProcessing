package ip.industrialProcessing.multiblock.machine.crusher;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.slots.SlotBase;

public class ContainerMultiblockCrusher extends ContainerMultiblockInv{

	public ContainerMultiblockCrusher(InventoryPlayer inventoryPlayer, TileEntityMultiblockCrusher entity) {
		super(inventoryPlayer, ((TileEntityMultiblockCoreInv)entity));
		slots = new Slot[1];
		slots[0] = new SlotBase(tileEntity, 0, 44, 33);

		addSlotToContainer(slots[0]);

		BindPlayerInventory(inventoryPlayer, this, 0);
	}

}

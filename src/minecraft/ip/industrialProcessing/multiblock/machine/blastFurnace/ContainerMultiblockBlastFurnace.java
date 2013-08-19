package ip.industrialProcessing.multiblock.machine.blastFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.machine.crusher.TileEntityMultiblockCrusher;
import ip.industrialProcessing.slots.SlotBase;

public class ContainerMultiblockBlastFurnace extends ContainerMultiblockCoreInv{

	public ContainerMultiblockBlastFurnace(InventoryPlayer inventoryPlayer, TileEntityMultiblockBlastFurnace entity) {
		super(inventoryPlayer, ((TileEntityMultiblockCoreInv)entity));
		slots = new Slot[2];
		slots[0] = new SlotBase(tileEntity, 0, 44, 33);
		slots[1] = new SlotBase(tileEntity, 1, 104, 33);

		addSlotToContainer(slots[0]);
		addSlotToContainer(slots[1]);

		BindPlayerInventory(inventoryPlayer, this, 0);
	}

}

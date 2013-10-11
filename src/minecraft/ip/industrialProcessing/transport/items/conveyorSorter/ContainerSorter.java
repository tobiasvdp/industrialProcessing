package ip.industrialProcessing.transport.items.conveyorSorter;

import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerSorter extends ContainerMachine<TileEntityConveyorSorter> {

    public ContainerSorter(InventoryPlayer inventoryPlayer, TileEntityConveyorSorter tileEntity) {
	super(inventoryPlayer, tileEntity);
	int slot = 0;
	for (int x = 0; x < 3; x++) {
	    for (int y = 0; y < 3; y++) {
		addSlotToContainer(new SlotBase(tileEntity, slot++, 8 + x * 18, 16 + y * 18));
	    }
	}
	for (int x = 0; x < 3; x++) {
	    for (int y = 0; y < 3; y++) {
		addSlotToContainer(new SlotBase(tileEntity, slot++, 116 + x * 18, 16 + y * 18));
	    }
	}
	ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
    }

}

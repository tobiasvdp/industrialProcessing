package ip.industrialProcessing.transport.items.conveyorSorter;

import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;
import buildcraft.core.gui.slots.SlotPhantom;

public class ContainerSorter extends ContainerMachine<TileEntityConveyorSorter> {

    public ContainerSorter(InventoryPlayer inventoryPlayer, TileEntityConveyorSorter tileEntity) {
	super(inventoryPlayer, tileEntity);
	int slot = 0;
	for (int x = 0; x < 3; x++) {
	    for (int y = 0; y < 3; y++) {
		addSlotToContainer(new SlotPhantom(tileEntity, slot++, 8 + x * 18, 16 + x * 18));
	    }
	}
	for (int x = 0; x < 3; x++) {
	    for (int y = 0; y < 3; y++) {
		addSlotToContainer(new SlotPhantom(tileEntity, slot++, 115 + x * 18, 16 + x * 18));
	    }
	}
	ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
    }

}

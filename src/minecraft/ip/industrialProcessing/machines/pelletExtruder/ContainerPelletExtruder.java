package ip.industrialProcessing.machines.pelletExtruder;

import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.kiln.TileEntityKiln;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerPelletExtruder extends ContainerPoweredWorkerMachine {

    protected Slot[] slots;

    protected TileEntityPelletExtruder tileEntityPE;

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
	return tileEntityPE.isUseableByPlayer(entityplayer);
    }

    public ContainerPelletExtruder(InventoryPlayer inventoryPlayer, TileEntityPelletExtruder tileEntityPE) {
	super(inventoryPlayer, tileEntityPE);
	this.tileEntityPE = tileEntityPE;

	slots = new Slot[2];
	slots[0] = new SlotBase(tileEntityPE, 0, 50, 31);
	slots[1] = new SlotOutput(tileEntityPE, 1, 110, 31);

	addSlotToContainer(slots[0]);
	addSlotToContainer(slots[1]);

	ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);

	addWorkerToContainer(tileEntityPE.getWorker());
	addPowerToContainer(tileEntityPE.getMainPowerStorage());
    }

    @Override
    public int getSizeInventory() {
	return slots.length;
    }

}

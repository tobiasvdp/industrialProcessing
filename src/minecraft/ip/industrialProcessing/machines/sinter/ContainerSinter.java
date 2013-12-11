package ip.industrialProcessing.machines.sinter;

import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerSinter  extends ContainerPoweredWorkerMachine {

	protected Slot[] slots;
	
	protected TileEntitySinter tileEntitySinter;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntitySinter.isUseableByPlayer(entityplayer);
	}
	
	public ContainerSinter(InventoryPlayer inventoryPlayer, TileEntitySinter tileEntitySinter) {
		super(inventoryPlayer, tileEntitySinter);
		this.tileEntitySinter = tileEntitySinter;
		
		slots = new Slot[3];		
		slots[0] = new SlotBase(tileEntitySinter, 0, 44, 15);
		slots[1] = new SlotBase(tileEntitySinter, 1, 44, 51);
		slots[2] = new SlotOutput(tileEntitySinter, 2, 104, 33);
		
        addSlotToContainer(slots[0]);
        addSlotToContainer(slots[1]);
        addSlotToContainer(slots[2]);
        
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
        
        addWorkerToContainer(tileEntitySinter.getWorker());
        addPowerToContainer(tileEntitySinter.getMainPowerStorage());
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}

}

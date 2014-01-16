package ip.industrialProcessing.machines.kiln;

import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerKiln  extends ContainerPoweredWorkerMachine {

	protected Slot[] slots;
	
	protected TileEntityKiln tileEntityKiln;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntityKiln.isUseableByPlayer(entityplayer);
	}
	
	public ContainerKiln(InventoryPlayer inventoryPlayer, TileEntityKiln tileEntityKiln) {
		super(inventoryPlayer, tileEntityKiln);
		this.tileEntityKiln = tileEntityKiln;
		
		slots = new Slot[2];		
		slots[0] = new SlotBase(tileEntityKiln, 0, 44, 33);
		slots[1] = new SlotOutput(tileEntityKiln, 1, 104, 33);
		
        addSlotToContainer(slots[0]);
        addSlotToContainer(slots[1]);	
        
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
        
        addWorkerToContainer(tileEntityKiln.getWorker());
        addPowerToContainer(tileEntityKiln.getMainPowerStorage());
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}

}

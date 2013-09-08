package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerCrusher extends ContainerPoweredWorkerMachine {

	protected Slot[] slots;
	
	protected TileEntityCrusher tileEntityCrusher;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntityCrusher.isUseableByPlayer(entityplayer);
	}
	
	public ContainerCrusher(InventoryPlayer inventoryPlayer, TileEntityCrusher tileEntityCrusher) {
		super(inventoryPlayer, tileEntityCrusher);
		this.tileEntityCrusher = tileEntityCrusher;
		
		slots = new Slot[2];		
		slots[0] = new SlotBase(tileEntityCrusher, 0, 44, 33);
		slots[1] = new SlotOutput(tileEntityCrusher, 1, 104, 33);
		
        addSlotToContainer(slots[0]);
        addSlotToContainer(slots[1]);	
        
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
        
        addWorker(tileEntityCrusher.getWorker());
        addPower(tileEntityCrusher.getMainPowerStorage());
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}
}

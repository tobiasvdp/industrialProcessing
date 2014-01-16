package ip.industrialProcessing.machines.spoolWindingMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerSpoolWindingMachine extends ContainerPoweredWorkerMachine{
	protected Slot[] slots;
	protected TileEntitySpoolWindingMachine tileEntity;
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}
	public ContainerSpoolWindingMachine(InventoryPlayer inventoryPlayer, TileEntitySpoolWindingMachine tileEntity){
		super(inventoryPlayer, tileEntity);
		this.tileEntity = tileEntity;
		
		slots = new Slot[3];		
		slots[0] = new SlotBase(tileEntity, 0, 44, 23);
		slots[1] = new SlotBase(tileEntity, 1, 44, 43);
		slots[2] = new SlotOutput(tileEntity, 2, 104, 33);
		
        addSlotToContainer(slots[0]);
        addSlotToContainer(slots[1]);
        addSlotToContainer(slots[2]);
        
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
        
        addWorkerToContainer(tileEntity.getWorker());
        addPowerToContainer(tileEntity.getMainPowerStorage());
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}
}

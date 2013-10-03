package ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerIncubator extends ContainerPoweredWorkerMachine{
	protected Slot[] slots;
	
	protected TileEntityPoweredWorkerMachine tileEntity;
	
	public ContainerIncubator(InventoryPlayer inventoryPlayer, TileEntityPoweredWorkerMachine tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntity = tileEntity;
		
		slots = new Slot[2];		
		slots[0] = new SlotBase(this.tileEntity, 0, 44, 33);
		slots[1] = new SlotOutput(this.tileEntity, 1, 104, 33);
		
        addSlotToContainer(slots[0]);
        addSlotToContainer(slots[1]);	
        
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
        
        addWorkerToContainer(this.tileEntity.getWorker());
        addPowerToContainer(this.tileEntity.getMainPowerStorage());
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}
}

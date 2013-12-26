package ip.industrialProcessing.machines.plants.blacksmith.grindingStone;

import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerGrindingStone extends ContainerWorkerMachine {

	protected Slot[] slots;
	
	protected TileEntityWorkerMachine tileEntity;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}
	
	public ContainerGrindingStone(InventoryPlayer inventoryPlayer, TileEntityWorkerMachine tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntity = tileEntity;
		
		slots = new Slot[2];		
		slots[0] = new SlotBase(tileEntity, 0, 44, 33);
		slots[1] = new SlotOutput(tileEntity, 1, 104, 33);
		
        addSlotToContainer(slots[0]);
        addSlotToContainer(slots[1]);	
        
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
        
        addWorkerToContainer(tileEntity.getWorker());
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}

}

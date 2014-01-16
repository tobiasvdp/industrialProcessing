package ip.industrialProcessing.machines.treetap;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.containers.ContainerWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerManualTreeTap extends ContainerWorkerMachine {

    public ContainerManualTreeTap(InventoryPlayer inventoryPlayer, TileEntityManualTreeTap tileEntity) {
        super(inventoryPlayer, tileEntity);        
        
        addSlotToContainer(new SlotBase(tileEntity, 0, 50, 31));
        addSlotToContainer(new SlotBase(tileEntity, 1, 110, 31));
        
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);


        addWorkerToContainer(tileEntity.getWorker());
    }

}

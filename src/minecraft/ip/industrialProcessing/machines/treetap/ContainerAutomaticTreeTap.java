package ip.industrialProcessing.machines.treetap;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerAutomaticTreeTap extends ContainerFluidMachine {

    private ProgressBarHandlerInfo progressInfo;
    
    public ProgressBarHandlerInfo getProgressInfo() {
        return progressInfo;
    }

    public ContainerAutomaticTreeTap(InventoryPlayer inventoryPlayer, TileEntityAutomaticTreeTap tileEntity) {
        super(inventoryPlayer, tileEntity);
        addSlotToContainer(new Slot(tileEntity, 0, 152, 19));
        addSlotToContainer(new Slot(tileEntity, 1, 152, 53));
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
        addTankToContainer(0);
        
        
        this.progressInfo = addProgressBar(new AutomaticTreetapHandler(tileEntity));
    }
}

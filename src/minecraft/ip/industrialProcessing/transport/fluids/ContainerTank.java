package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerTank extends ContainerFluidMachine {

    public ContainerTank(InventoryPlayer inventoryPlayer, TileEntityTank tileEntity) {
	super(inventoryPlayer, tileEntity);
	addTankToContainer(0);
	ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
    }

}

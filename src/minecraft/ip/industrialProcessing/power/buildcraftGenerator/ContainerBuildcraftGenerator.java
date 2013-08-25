package ip.industrialProcessing.power.buildcraftGenerator;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerBuildcraftGenerator extends ContainerMachine {

    public ContainerBuildcraftGenerator(InventoryPlayer inventoryPlayer, TileEntityMachine tileEntity) {
	super(inventoryPlayer, tileEntity);
	ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
    }

}

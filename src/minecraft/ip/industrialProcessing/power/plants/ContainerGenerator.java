package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerGenerator extends ContainerMachine {

	public ContainerGenerator(InventoryPlayer inventoryPlayer, TileEntityGenerator tileEntity) {
		super(inventoryPlayer, tileEntity);
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

}

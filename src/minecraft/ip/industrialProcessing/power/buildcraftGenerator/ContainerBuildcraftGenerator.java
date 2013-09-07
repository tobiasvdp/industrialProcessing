package ip.industrialProcessing.power.buildcraftGenerator;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerBuildcraftGenerator extends ContainerMachine {

	public ContainerBuildcraftGenerator(InventoryPlayer inventoryPlayer, TileEntityMachine tileEntity) {
		super(inventoryPlayer, tileEntity);
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

}

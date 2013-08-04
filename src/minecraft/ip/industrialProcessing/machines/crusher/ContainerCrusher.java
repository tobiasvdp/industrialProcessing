package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrusher extends ContainerMachine{
	
	Slot inputSlot;
	Slot outputSlot;

	public ContainerCrusher(InventoryPlayer inventoryPlayer,TileEntityCrusher tileEntity) {super(inventoryPlayer, tileEntity);
		inputSlot = new Slot(tileEntity, 0, 16, 16);
		outputSlot = new Slot(tileEntity, 1, 48, 16);

		addSlotToContainer(inputSlot);
		addSlotToContainer(outputSlot);
	}
}

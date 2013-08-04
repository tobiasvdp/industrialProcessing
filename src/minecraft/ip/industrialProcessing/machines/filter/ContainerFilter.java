package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import ip.industrialProcessing.utils.containers.IContainerTransfer;
import ip.industrialProcessing.utils.containers.VerifyingContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFilter extends ContainerMachine {
	Slot inputSlot;
	Slot outputSmallSlot;
	Slot outputBigSlot;

	public ContainerFilter(InventoryPlayer inventoryPlayer,
			TileEntityFilter tileEntity) {
		super(inventoryPlayer, tileEntity);
		
		inputSlot = new SlotBase(tileEntity, 0, 16, 16);
		outputSmallSlot = new SlotOutput(tileEntity, 1, 48, 16);
		outputBigSlot = new SlotOutput(tileEntity, 2, 32, 32);

		addSlotToContainer(inputSlot);
		addSlotToContainer(outputSmallSlot);
		addSlotToContainer(outputBigSlot);
	}
}

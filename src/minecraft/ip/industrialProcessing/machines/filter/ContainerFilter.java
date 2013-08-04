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
	
	protected Slot[] slots;

	public ContainerFilter(InventoryPlayer inventoryPlayer,
			TileEntityFilter tileEntity) {
		super(inventoryPlayer, tileEntity);

		slots = new Slot[3];		
		slots[0] = new Slot(tileEntity, 0, 44, 33);
		slots[1] = new Slot(tileEntity, 1, 104, 33);
		slots[2] = new Slot(tileEntity, 2, 104, 56);

		addSlotToContainer(slots[0]);
		addSlotToContainer(slots[1]);
		addSlotToContainer(slots[2]);
		
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}
}

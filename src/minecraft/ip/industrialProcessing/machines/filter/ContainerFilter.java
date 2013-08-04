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
		
<<<<<<< HEAD
		slots = new Slot[3];		
		slots[0] = new Slot(tileEntity, 0, 16, 16);
		slots[1] = new Slot(tileEntity, 1, 48, 16);
		slots[2] = new Slot(tileEntity, 2, 32, 32);
=======
		inputSlot = new SlotBase(tileEntity, 0, 16, 16);
		outputSmallSlot = new SlotOutput(tileEntity, 1, 48, 16);
		outputBigSlot = new SlotOutput(tileEntity, 2, 32, 32);
>>>>>>> branch 'master' of https://github.com/tobiasvdp/industrialProcessing.git

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

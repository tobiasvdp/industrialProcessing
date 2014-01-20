package ip.industrialProcessing.transport.items.conveyorPacker;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.containers.IMachineContainerEntity;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityConveyorPacker extends TileEntityConveyorInventoryBase implements IMachineContainerEntity {

    ItemStack[] slots = new ItemStack[10];

    // 0: box slot
    // 1-9: Config

    @Override
    public int getSizeInventory() {
	return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
	if (i >= slots.length)
	    return null;
	return slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {

	if (i >= slots.length)
	    return null;

	ItemStack stack = slots[i];
	if (stack == null)
	    return null;

	if (stack.stackSize > j) {
	    stack = stack.splitStack(j);
	    onInventoryChanged();
	    return stack;
	}
	slots[i] = null;
	onInventoryChanged();
	return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
	return getStackInSlot(i);
    }

    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack stack) {
	if (slotIndex > getSizeInventory())
	    return;
	if (slotIndex > 0) {
	    if (stack != null && stack.stackSize > getInventoryStackLimit()) {
		stack.stackSize = getInventoryStackLimit();
	    } 
	} else {
	    if (stack != null && stack.stackSize > getInventoryStackLimit()) {
		stack.stackSize = getInventoryStackLimit();
	    }
	}
	slots[slotIndex] = stack;
	onInventoryChanged();
    }

    @Override
    public String getInvName() { 
	return "packer";
    }

    @Override
    public boolean isInvNameLocalized() { 
	return false;
    }

    @Override
    public int getInventoryStackLimit() { 
	return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) { 
	return true;
    }

    @Override
    public void openChest() { 
    }

    @Override
    public void closeChest() { 
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) { 
	return (i == 0) ^ (itemstack != null && itemstack.itemID == IndustrialProcessing.blockStorageBox.blockID);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, int size) { 
	return false;
    }
}

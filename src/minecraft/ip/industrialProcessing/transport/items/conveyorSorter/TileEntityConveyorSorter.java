package ip.industrialProcessing.transport.items.conveyorSorter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.containers.IMachineContainerEntity;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;

public class TileEntityConveyorSorter extends TileEntityConveyorInventoryBase implements IMachineContainerEntity {

    public TileEntityConveyorSorter() {
	setConnectionMode(LocalDirection.LEFT, ConnectionMode.OUTPUT);
	setConnectionMode(LocalDirection.RIGHT, ConnectionMode.OUTPUT);
	setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
    }

    @Override
    public int getSizeInventory() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getInvName() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isInvNameLocalized() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public int getInventoryStackLimit() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void openChest() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void closeChest() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, int size) {
	// TODO Auto-generated method stub
	return false;
    }

}

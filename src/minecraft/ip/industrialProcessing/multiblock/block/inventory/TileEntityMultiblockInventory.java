package ip.industrialProcessing.multiblock.block.inventory;

import ip.industrialProcessing.multiblock.block.frame.TileEntityMachineFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

abstract class TileEntityMultiblockInventory extends TileEntityMachineFrame implements ISidedInventory {

    // TODO: fill in the ID when the core is known
    private int frameID;
   

    private IMultiblockInventory getCoreInventory() {
	// TODO return the core inventory
	return null;
    }
    
    @Override
    public int getSizeInventory() {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return 0;
	return core.getSizeInventory(frameID);
    }


    @Override
    public ItemStack getStackInSlot(int i) {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return null;
	return core.getStackInSlot(frameID, i);
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return null;
	return core.decrStackSize(frameID, i, j);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return null;
	return core.getStackInSlotOnClosing(frameID, i);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack) {
	IMultiblockInventory core = getCoreInventory();
	if(core != null)
	core.setInventorySlotContents(frameID, slot, itemstack);
    }

    @Override
    public String getInvName() {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return null;
	return core.getInvName(frameID);
    }

    @Override
    public boolean isInvNameLocalized() {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return false;
	return core.isInvNameLocalized(frameID);
    }

    @Override
    public int getInventoryStackLimit() {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return 0;
	return core.getInventoryStackLimit(frameID);
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return false;
	return core.isUseableByPlayer(frameID, entityplayer);
    }

    @Override
    public void openChest() {
	IMultiblockInventory core = getCoreInventory();
	if(core != null)
	core.openChest(frameID);
    }

    @Override
    public void closeChest() {
	IMultiblockInventory core = getCoreInventory();
	if(core != null)
	core.closeChest(frameID);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return false;
	return core.isItemValidForSlot(frameID, slot, itemstack);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return new int[0];
	return core.getAccessibleSlotsFromSide(frameID, side);
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return false;
	return core.canInsertItem(frameID, slot, itemstack, side);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
	IMultiblockInventory core = getCoreInventory();
	if(core == null) return false;
	return core.canExtractItem(frameID, slot, itemstack, side);
    }

}

package ip.industrialProcessing.multiblock.extended.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.IMultiblockInventoryBlock;
import ip.industrialProcessing.multiblock.utils.MultiblockLayout;

public abstract class TileEntityMultiblockBlockInv extends TileEntityMultiblockBlock
		implements IMultiblockInventoryBlock {
	protected int inventoryID = 1;
	public TileEntityMultiblockBlockInv() {
		super();
	}
	@Override
	public TileEntityMultiblockCoreInv getCore(){
			return (TileEntityMultiblockCoreInv) worldObj.getBlockTileEntity(xCore, yCore, zCore);
	}

	@Override
	public int getSizeInventory() {
		if (hasCore)
			return getCore().getSizeInventory();
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		if (hasCore)
			return getCore().getStackInSlot(i);
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (hasCore)
			return getCore().decrStackSize(i, j);
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		if (hasCore)
			 getCore().setInventorySlotContents(i, itemstack);
	}

	@Override
	public String getInvName() {
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		if (hasCore)
			return getCore().getInventoryStackLimit();
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		if(hasCore)
			return getCore().getAccessibleSlotsForID(this.inventoryID);
		return null;
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
	
		if(hasCore)
			return getCore().isItemValidForSlot(i, itemstack);
		return false;
	
	}
	@Override
	public void openChest(){}

	@Override
	public void closeChest(){}
}

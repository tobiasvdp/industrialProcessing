package ip.industrialProcessing.multiblock.dummy.extend;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTank;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;

public class TileEntityMultiblockDummyInv extends TileEntityMultiblockDummy implements ISidedInventory{

	@Override
	public TileEntityMultiblockCoreInv getCore() {
		if (loadedFromNBT) {
			core = (TileEntityMultiblockCore) worldObj.getBlockTileEntity(coreDataFromNBT[0], coreDataFromNBT[1], coreDataFromNBT[2]);
			loadedFromNBT = false;
		}
		return (TileEntityMultiblockCoreInv) core;
	}
	
	@Override
	public int getSizeInventory() {
		if (this.getCore() != null)
			return getCore().getSizeInventory();
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		if (this.getCore() != null)
			return getCore().getStackInSlot(i);
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.getCore() != null)
			return getCore().decrStackSize(i, j);
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.getCore() != null)
			return getCore().getStackInSlotOnClosing(i);
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		if (this.getCore() != null)
			getCore().setInventorySlotContents(i, itemstack);
	}

	@Override
	public String getInvName() {
		return "Dummy";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
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
		if (this.getCore() != null)
			return getCore().isItemValidForSlot(i, itemstack);
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		if (this.getCore() != null)
			return getCore().getAccessibleSlotsFromSide(getGroup(), var1);
		return new int[]{};
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		if (this.getCore() != null)
			return getCore().canInsertItem(getGroup(), i, itemstack, j);
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		if (this.getCore() != null)
			return getCore().canInsertItem(getGroup(), i, itemstack, j);
		return false;
	}

}

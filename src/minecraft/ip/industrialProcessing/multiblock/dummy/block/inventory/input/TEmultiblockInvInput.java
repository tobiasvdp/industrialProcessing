package ip.industrialProcessing.multiblock.dummy.block.inventory.input;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;

public class TEmultiblockInvInput extends TileEntityMultiblockDummy implements ISidedInventory {

	@Override
	public TileEntityMultiblockCoreInv getCore() {
		TileEntityMultiblockCore te = super.getCore();
		return (TileEntityMultiblockCoreInv) te;
	}

	public TEmultiblockInvInput() {
		super();
	}

	@Override
	public int getSizeInventory() {
		if (getCore() != null)
			return getCore().getSizeInventory();
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		if (getCore() != null)
			return getCore().getStackInSlot(i);
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (getCore() != null)
			return getCore().decrStackSize(i, j);
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (getCore() != null)
			return getCore().getStackInSlotOnClosing(i);
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		if (getCore() != null)
			getCore().setInventorySlotContents(i, itemstack);

	}

	@Override
	public String getInvName() {
		if (getCore() != null)
			return getCore().getInvName();
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		if (getCore() != null)
			return getCore().isInvNameLocalized();
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		if (getCore() != null)
			return getCore().getInventoryStackLimit();
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		if (getCore() != null)
			return getCore().isUseableByPlayer(entityplayer);
		return false;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if (getCore() != null)
			return getCore().isItemValidForSlot(i, itemstack);
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		//if (getCore() != null)
			//return getCore().getAccessibleSlotsFromSide(this.ID, var1);
		return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		//if (getCore() != null)
			//return getCore().canInsertItem(i, itemstack, this.ID, j);
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		//if (getCore() != null)
			//return getCore().canExtractItem(i, itemstack, this.ID, j);
		return false;
	}

}

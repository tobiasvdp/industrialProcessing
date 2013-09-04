package ip.industrialProcessing.multiblock.dummy.block.inventory.output;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;

public class TEmultiblockInvOutput extends TEmultiblockDummy implements ISidedInventory{

	public TEmultiblockInvOutput() {
		super();
	}

	@Override
	public TEmultiblockCoreInv getCore() {
		TEmultiblockCore te = super.getCore();
		return (TEmultiblockCoreInv) te;
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
		if (getCore() != null)
			return getCore().getAccessibleSlotsFromSide(this.ID, var1);
		return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		if (getCore() != null)
			return getCore().canInsertItem(i, itemstack, this.ID, j);
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		if (getCore() != null)
			return getCore().canExtractItem(i, itemstack, this.ID, j);
		return false;
	}

}

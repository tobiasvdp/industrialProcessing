package ip.industrialProcessing.multiblock.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public abstract interface IMultiblockInventoryCore extends IInventory {

	@Override
	public int getSizeInventory();

	@Override
	public ItemStack getStackInSlot(int i);

	@Override
	public ItemStack decrStackSize(int i, int j);

	@Override
	public ItemStack getStackInSlotOnClosing(int i);

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack);

	@Override
	public String getInvName();

	@Override
	public boolean isInvNameLocalized();

	@Override
	public int getInventoryStackLimit();

	@Override
	public void onInventoryChanged();

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer);

	@Override
	public void openChest();
	@Override
	public void closeChest();

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack);

	public int[] getAccessibleSlotsForID(int var1);

	public boolean canInsertItemForID(int i, ItemStack itemstack, int j);

	public boolean canExtractItemForID(int i, ItemStack itemstack, int j);

}

package ip.industrialProcessing.multiblock.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

public interface IMultiblockInventory extends ISidedInventory {

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

	@Override
	public int[] getAccessibleSlotsFromSide(int var1);

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j);

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j);

}

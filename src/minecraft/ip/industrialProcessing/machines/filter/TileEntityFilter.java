package ip.industrialProcessing.machines.filter;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityFilter extends TileEntity implements ISidedInventory {

	private ItemStack[] stacks = new ItemStack[3];

	@Override
	public int getSizeInventory() {
		return 3;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		if (i < stacks.length)
			return stacks[i];
		else
			return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {

		ItemStack stack = stacks[i];
		if (stack == null)
			return null;

		if (stack.stackSize > j) {
			return stack.splitStack(j);
		} else {
			stacks[i] = null;
			return stack;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		stacks[i] = itemstack;
	}

	@Override
	public String getInvName() {
		return "Filter";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
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
		if (i > 0)
			return false; // nothing in output

		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		int up = ForgeDirection.UP.ordinal();
		int down = ForgeDirection.DOWN.ordinal();

		if (side == up) {
			return new int[] { 0 };
		} else if (side == down) {
			return new int[] { 1 };
		} else {
			return new int[] { 2 };
		}
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		if(i != 0)	return false; // only insert in input slot!
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		ItemStack sourceStack = stacks[i];
		if(sourceStack == null) return false;
		if(sourceStack.itemID == itemstack.itemID) return true;
		if(sourceStack.stackSize >= itemstack.stackSize) return true;
		return false;
	}

}

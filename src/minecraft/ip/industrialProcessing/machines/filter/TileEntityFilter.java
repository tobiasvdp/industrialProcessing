package ip.industrialProcessing.machines.filter;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import ip.industrialProcessing.utils.inventories.IItemStacksInventory;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.Worker;

public class TileEntityFilter extends TileEntity implements ISidedInventory,
		IItemStacksInventory, IWorkHandler {

	private ItemStack[] stacks = new ItemStack[3];
	private Worker worker;

	public TileEntityFilter() {
		worker = new Worker(this, 10);
	}

	@Override
	public void beginWork() {
		// decide on what to make here
	}

	@Override
	public void workDone() {
		// and do it here
		System.out.println("Hey, this thingy has it's work done!");

		ItemStack outputSmall = this.stacks[1];
		ItemStack outputBig = this.stacks[2];

		if (outputSmall == null)
			outputSmall = new ItemStack(Block.sand, 1);
		else
			outputSmall.stackSize++;

		if (outputBig == null)
			outputBig = new ItemStack(Block.gravel, 1);
		else
			outputBig.stackSize++;
		
		this.stacks[1] = outputSmall;
		this.stacks[2] = outputBig;
		onInventoryChanged();
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void updateEntity() {
		worker.doWork(1);
	}

	@Override
	public boolean hasWork() {
		ItemStack input = this.stacks[0];
		return input != null && input.stackSize > 0
				&& canAcceptInputId(input.itemID);
	}

	@Override
	public boolean canWork() {
		ItemStack outputSmall = this.stacks[1];
		ItemStack outputBig = this.stacks[2];

		return !((outputSmall != null && outputSmall.stackSize >= getInventoryStackLimit()) || (outputBig != null && outputBig.stackSize >= getInventoryStackLimit()));
	}

	private boolean canAcceptInputId(int itemID) {

		if (itemID == Block.dirt.blockID)
			return true;
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		// par1.setShort("workTime", (short) this.workTime);
		// par1.setShort("workingTime", (short) this.workingTime);
		InventoryUtils.WriteInventory(this, par1);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		InventoryUtils.ReadInventory(this, par1);
	}

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
		ItemStack result = InventoryUtils.decrStackSize(stacks, i, j);
		onInventoryChanged();
		return result;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotId) {
		if (this.stacks[slotId] == null)
			return null;

		ItemStack stackToTake = this.stacks[slotId];
		this.stacks[slotId] = null;
		return stackToTake;
	}

	@Override
	public void setInventorySlotContents(int slotId, ItemStack itemstack) {
		if (slotId >= getSizeInventory()) {
			return;
		}
		this.stacks[slotId] = itemstack;

		if (itemstack != null
				&& itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
		onInventoryChanged();
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
		if (i != 0) // no inserts in output
			return false;
		if (itemstack != null && !canAcceptInputId(itemstack.itemID)) // check
																		// if
																		// the
																		// itemstack
																		// can
																		// be
																		// accepted
			return false;
		return true;
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
		if (i == 0)
			return true; // only insert in input slot!
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		ItemStack sourceStack = stacks[i];
		if (sourceStack == null)
			return false;
		if (sourceStack.itemID == itemstack.itemID)
			return true;
		if (sourceStack.stackSize >= itemstack.stackSize)
			return true;
		return false;
	}

	@Override
	public void setStacks(ItemStack[] stacks) {
		this.stacks = stacks;
	}

	@Override
	public ItemStack[] getStacks() {
		return this.stacks;
	}

	@Override
	public int getStackCount() {
		return 3;
	}

}

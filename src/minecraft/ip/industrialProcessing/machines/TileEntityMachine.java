package ip.industrialProcessing.machines;

import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.Worker;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMachine extends TileEntity implements
		ISidedInventory, IWorkHandler, IMachineSlots {

	private ArrayList<MachineItemStack> itemStacks = new ArrayList<MachineItemStack>();
	private int[][] itemStackSideSlots = new int[6][0];

	private Worker worker;

	@Override
	public void updateEntity() {
		work();
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	protected void work() {
		worker.doWork(1);
	}

	@Override
	public boolean slotContains(int slot, int itemId, int amount) {
		MachineItemStack machineStack = itemStacks.get(slot);
		return machineStack != null && machineStack.stack != null
				&& machineStack.stack.itemID == itemId
				&& machineStack.stack.stackSize >= amount;
	}

	@Override
	public boolean slotHasRoomFor(int slot, ItemStack stack) {
		if (stack == null || stack.stackSize == 0)
			return true;
		MachineItemStack machineStack = itemStacks.get(slot);
		return machineStack != null
				&& (machineStack.stack == null || (machineStack.stack.itemID == stack.itemID && (machineStack.stack.stackSize
						+ stack.stackSize < getInventoryStackLimit())));
	}

	protected void addStack(ItemStack stack, ForgeDirection side,
			boolean input, boolean output) {
		int index = itemStacks.size();

		itemStacks.add(new MachineItemStack(stack,
				new int[] { side.ordinal() }, input, output));

		int sideIndex = side.ordinal();
		int[] slots = itemStackSideSlots[sideIndex];
		int[] newSlots = new int[slots.length + 1];
		System.arraycopy(slots, 0, newSlots, 0, slots.length);
		newSlots[slots.length] = index;
		itemStackSideSlots[sideIndex] = newSlots;
	}

	protected void addStack(ItemStack stack, ForgeDirection[] sides,
			boolean input, boolean output) {
		int index = itemStacks.size();

		int[] sideIndices = new int[sides.length];
		for (int i = 0; i < sideIndices.length; i++)
			sideIndices[i] = sides[i].ordinal();

		itemStacks.add(new MachineItemStack(stack, sideIndices, input, output));

		for (int i = 0; i < sideIndices.length; i++) {
			int sideIndex = sideIndices[i];
			int[] slots = itemStackSideSlots[sideIndex];
			int[] newSlots = new int[slots.length + 1];
			System.arraycopy(slots, 0, newSlots, 0, slots.length);
			newSlots[slots.length] = index;
			itemStackSideSlots[sideIndex] = newSlots;
		}
	}

	@Override
	public int getSizeInventory() {
		return itemStacks.size();
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		MachineItemStack machineStack = getMachineStack(i);
		if (machineStack == null)
			return null;
		return machineStack.stack;
	}

	private MachineItemStack getMachineStack(int i) {
		if (i < 0 || i >= this.itemStacks.size())
			return null;
		return this.itemStacks.get(i);
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int amount) {

		ItemStack stack = getStackInSlot(slotIndex);
		if (stack != null) {
			if (stack.stackSize <= amount) {
				setInventorySlotContents(slotIndex, null);
			} else {
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slotIndex, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack stack) {
		MachineItemStack machineStack = getMachineStack(slotIndex);
		if (machineStack != null) {
			machineStack.stack = stack;
			if (stack != null && stack.stackSize > getInventoryStackLimit()) {
				stack.stackSize = getInventoryStackLimit();
			}
			onInventoryChanged();
		}
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
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this
				&& entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5,
						zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public abstract boolean isItemValidForSlot(int i, ItemStack itemstack);

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return itemStackSideSlots[var1];
	}

	@Override
	public boolean canInsertItem(int slotIndex, ItemStack itemstack, int amount) {
		MachineItemStack machineStack = getMachineStack(slotIndex);
		if (machineStack != null && machineStack.input) {
			return isItemValidForSlot(slotIndex, itemstack);
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slotIndex, ItemStack itemstack, int amount) {
		MachineItemStack machineStack = getMachineStack(slotIndex);
		if (machineStack != null && machineStack.output) {
			return isItemValidForSlot(slotIndex, itemstack);
		}
		return false;
	}

	public void setWorker(Worker recipeWorker) {
		this.worker = recipeWorker;
	}

}

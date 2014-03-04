package mod.industrialProcessing.blockContainer.machine;

import java.util.ArrayList;

import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.utils.inventory.itemstack.MachineItemStack;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public abstract class TileEntityMachineInv extends TileEntityBlockContainerIP implements ISidedInventory {

	private ArrayList<MachineItemStack> itemStacks = new ArrayList<MachineItemStack>();
	private int[][] itemStackSideSlots = new int[6][0];

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeInventory(nbt);
	}

	private void writeInventory(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.itemStacks.size(); ++i) {
			MachineItemStack machineStack = this.itemStacks.get(i);
			if (machineStack.stack != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				machineStack.stack.writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readInventory(nbt);
	};

	private void readInventory(NBTTagCompound nbt) {
		if (!nbt.hasKey("Items"))
			return;
		NBTTagList nbttaglist = nbt.getTagList("Items", 0);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < itemStacks.size()) {
				MachineItemStack machineStack = this.itemStacks.get(b0);
				machineStack.stack = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}
	
	protected int addStack(ItemStack stack, LocalDirection side, boolean input, boolean output) {
        if (side == null)
            return addStack(stack, new LocalDirection[0], input, output);
        else
            return addStack(stack, new LocalDirection[] { side }, input, output);
    }

    protected int addStack(ItemStack stack, LocalDirection[] sides, boolean input, boolean output) {
        int index = itemStacks.size();
        int[] sideIndices = new int[sides.length];
        for (int i = 0; i < sideIndices.length; i++) {
            sideIndices[i] = sides[i].ordinal();
        } 
        itemStacks.add(new MachineItemStack(stack, sideIndices, input, output));

        for (int i = 0; i < sideIndices.length; i++) {
            int sideIndex = sideIndices[i];
            int[] slots = itemStackSideSlots[sideIndex];
            int[] newSlots = new int[slots.length + 1];
            System.arraycopy(slots, 0, newSlots, 0, slots.length);
            newSlots[slots.length] = index;
            itemStackSideSlots[sideIndex] = newSlots;
        }
        return index;
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

	public MachineItemStack getMachineStack(int i) {
		if (i < 0 || i >= this.itemStacks.size())
			return null;
		return this.itemStacks.get(i);
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		MachineItemStack machineStack = getMachineStack(i);
		if (machineStack == null)
			return null;

		ItemStack stack = machineStack.stack;
		if (stack == null)
			return null;

		if (stack.stackSize > j) {
			stack = stack.splitStack(j);
			onInventoryChanged();
			return stack;
		}
		machineStack.stack = null;
		onInventoryChanged();
		return stack;
	}

	private void onInventoryChanged() {
		markDirty();
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
		if (slotIndex > getSizeInventory())
			return;

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
	public String getInventoryName() {
		return "";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		MachineItemStack stack = getMachineStack(slot);
		if (stack == null || itemstack == null)
			return false;
		return stack.input && isValidInput(slot, itemstack.getItem());
	}

	protected abstract boolean isValidInput(int slot, Item item);

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		LocalDirection dir = getLocalDirection(var1);
		return itemStackSideSlots[dir.ordinal()];
	}

	@Override
	public boolean canInsertItem(int slotIndex, ItemStack itemstack, int amount) {
		MachineItemStack machineStack = getMachineStack(slotIndex);
		if (machineStack != null && machineStack.input) {
			if (machineStack.stack == null) {
				return isItemValidForSlot(slotIndex, itemstack);
			} else if (machineStack.stack.stackSize + amount <= 64) {
				return isItemValidForSlot(slotIndex, itemstack);
			}
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slotIndex, ItemStack itemstack, int amount) {
		MachineItemStack machineStack = getMachineStack(slotIndex);
		if (machineStack != null && machineStack.output) {
			return true;
		}
		return false;
	}

}

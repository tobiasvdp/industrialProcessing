package mod.industrialProcessing.plants.transport.items.conveyorSorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorPowerTranslation;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConnectionMode;
import mod.industrialProcessing.transport.items.conveyorBelt.util.MovingItemStack;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityConveyorSorter extends TileEntityConveyorPowerTranslation implements IMachineContainerEntity {

	static Random rnd = new Random();
	ItemStack[] slots = new ItemStack[3 * 3 * 2];

	public TileEntityConveyorSorter() {
		setConnectionMode(LocalDirection.LEFT, ConnectionMode.OUTPUT);
		setConnectionMode(LocalDirection.RIGHT, ConnectionMode.OUTPUT);
		setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
	}

	@Override
	public int getSizeInventory() {
		return 3 * 3 * 2;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		if (i >= slots.length)
			return null;
		return slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {

		if (i >= slots.length)
			return null;

		ItemStack stack = slots[i];
		if (stack == null)
			return null;

		if (stack.stackSize > j) {
			stack = stack.splitStack(j);
			onInventoryChanged();
			return stack;
		}
		slots[i] = null;
		onInventoryChanged();
		return stack;
	}

	@Override
	protected LocalDirection findOutput(ItemStack stack, LocalDirection source) {
		if (source == LocalDirection.FRONT) {
			int emptySlots = 0;
			if (stack != null) {
				for (int i = 0; i < 3 * 3 * 2; i++) {
					if (slots[i] == null)
						emptySlots++;
					if (slots[i] != null && slots[i].itemID == stack.itemID) {
						if (i < 9) {
							ForgeDirection right = DirectionUtils.getWorldDirection(LocalDirection.RIGHT, this.forwardDirection);
							if (states[right.ordinal()].isConnected())
								return LocalDirection.RIGHT;
						} else {
							ForgeDirection left = DirectionUtils.getWorldDirection(LocalDirection.LEFT, this.forwardDirection);
							if (states[left.ordinal()].isConnected())
								return LocalDirection.LEFT;
						}
					}
				}
			}
			if (emptySlots == 3 * 3 * 2) {
				ArrayList<LocalDirection> outputs = new ArrayList<LocalDirection>();
				outputs.add(LocalDirection.BACK);

				ForgeDirection right = DirectionUtils.getWorldDirection(LocalDirection.RIGHT, this.forwardDirection);
				if (states[right.ordinal()].isConnected())
					outputs.add(LocalDirection.RIGHT);
				ForgeDirection left = DirectionUtils.getWorldDirection(LocalDirection.LEFT, this.forwardDirection);
				if (states[left.ordinal()].isConnected())
					outputs.add(LocalDirection.LEFT);
				return outputs.get(rnd.nextInt(outputs.size()));
			} else
				return LocalDirection.BACK;
		}
		return super.findOutput(stack, source);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return getStackInSlot(i);
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack stack) {
		if (slotIndex > getSizeInventory())
			return;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) { // only
																			// ghosts!
			stack.stackSize = getInventoryStackLimit();
		}
		slots[slotIndex] = stack;
		onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return "Sorter";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
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
		return true;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack stack, int size) {
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeInventory(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readInventory(nbt);
	}

	private void writeInventory(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.slots.length; ++i) {
			ItemStack stack = this.slots[i];
			if (stack != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				stack.writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
	}

	private void readInventory(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Items");
		Arrays.fill(slots, null);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < slots.length) {
				slots[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
	protected ItemStack outputToTileEntity(MovingItemStack stack, TileEntity neighbor, ForgeDirection direction) {
		return stack.stack;
	}

}

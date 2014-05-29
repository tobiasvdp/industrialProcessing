package mod.industrialProcessing.plants.transport.conveyorInput;

import java.util.Arrays;

import mod.industrialProcessing.blockContainer.transport.TransportConnectionState;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorInventoryBase;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConnectionMode;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import mod.industrialProcessing.utils.handlers.numbers.IStateConfig;
import mod.industrialProcessing.utils.inventory.ExtractOrder;
import mod.industrialProcessing.utils.inventory.IExtractFilter;
import mod.industrialProcessing.utils.inventory.ItemTransfers;
import mod.industrialProcessing.utils.inventory.itemstack.MachineItemStack;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityConveyorInput extends TileEntityConveyorInventoryBase implements IStateConfig, ISidedInventory {

	private IExtractFilter filter;
	private ExtractOrder operationMode = ExtractOrder.RANDOM;

	ItemStack[] slots = new ItemStack[9];
	private int extractStackSize = 1;

	public TileEntityConveyorInput() {
		super();
		Arrays.fill(this.connections, ConnectionMode.INVENTORYINPUT);
		setConnectionMode(LocalDirection.UP, ConnectionMode.ANYINPUT);
		setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
		this.filter = new ConveyorImportFilter(this.slots);
	}

	@Override
	public void toggleSlope(EntityPlayer player) {
		int index = operationMode.ordinal();
		index++;
		while (index >= 3) {
			index -= 3;
		}
		operationMode = ExtractOrder.values()[index];

		String mode;
		switch (operationMode) {
		case ASCENDING:
			mode = "First slot first";
			break;
		case DESCENDING:
			mode = "Last slot first";
			break;
		case RANDOM:
		default:
			mode = "Random slot";
			break;
		}

		int i2 = 1 + index;

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (operationMode != null)
			nbt.setInteger("Mode", operationMode.ordinal());
		nbt.setInteger("maxSize", this.extractStackSize);
		writeInventory(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Mode"))
			operationMode = ExtractOrder.values()[nbt.getInteger("Mode")];
		if (nbt.hasKey("maxSize"))
			this.extractStackSize = nbt.getInteger("maxSize");
		readInventory(nbt);
	}

	private void writeInventory(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.itemStacks.size(); ++i) {
			ItemStack machineStack = this.slots[i];
			if (machineStack != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				machineStack.writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
	}

	private void readInventory(NBTTagCompound nbt) {
		if (!nbt.hasKey("Items"))
			return;
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < itemStacks.size()) {
				ItemStack machineStack = this.slots[b0];
				machineStack = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
	protected TransportConnectionState handleInventoryState(IInventory inventory, ForgeDirection direction, ConnectionMode mode) {
		return TransportConnectionState.INPUT;
	}

	protected ItemStack pullFromSide(ForgeDirection direction) {

		TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction);
		if (neighbor instanceof IInventory) {
			IInventory inventory = (IInventory) neighbor;
			ForgeDirection opposite = direction.getOpposite();
			return ItemTransfers.extract(opposite, inventory, operationMode, filter, this.extractStackSize);
		}
		return null;
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
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
	public ItemStack getStackInSlotOnClosing(int i) {
		return getStackInSlot(i);
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack stack) {
		if (slotIndex > getSizeInventory())
			return;
		if (slotIndex > 0) {
			if (stack != null && stack.stackSize > getInventoryStackLimit()) {
				stack.stackSize = getInventoryStackLimit();
			}
		} else {
			if (stack != null && stack.stackSize > getInventoryStackLimit()) {
				stack.stackSize = getInventoryStackLimit();
			}
		}
		slots[slotIndex] = stack;
		onInventoryChanged();
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
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack stack, int size) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return new int[0];
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public int getStateValue(int index) {
		return extractStackSize;
	}

	@Override
	public void setStateValue(int index, int value) {
		if (index == 0)
			extractStackSize = value;

	}

	@Override
	public int getMaxStateValue(int index) {
		if (index == 0)
			return 64;
		return 0;
	}

	@Override
	public int getMinStateValue(int index) {
		if (index == 0)
			return 1;
		return 0;
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
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	public void onInventoryChanged() {
		this.markDirty();
	}
}

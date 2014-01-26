package ip.industrialProcessing.transport.items.conveyorInput;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.containers.IMachineContainerEntity;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import ip.industrialProcessing.transport.items.conveyorPacker.PackerOperationMode;
import ip.industrialProcessing.utils.ExtractOrder;
import ip.industrialProcessing.utils.IExtractFilter;
import ip.industrialProcessing.utils.ItemTransfers;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;
import ip.industrialProcessing.utils.nbt.NbtHelper;

public class TileEntityConveyorInput extends TileEntityConveyorInventoryBase implements IStateConfig, IMachineContainerEntity, ISidedInventory {

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
		setDataViewState(0, 1);
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
		if (!worldObj.isRemote)
			player.sendChatToPlayer(ChatMessageComponent.func_111066_d(i2 + "/3: " + mode + "."));
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (operationMode != null)
			nbt.setInteger("Mode", operationMode.ordinal());
		nbt.setInteger("maxSize", this.extractStackSize);
		NbtHelper.writeInventory(this.slots, nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Mode"))
			operationMode = ExtractOrder.values()[nbt.getInteger("Mode")];
		if (nbt.hasKey("maxSize"))
			this.extractStackSize = nbt.getInteger("maxSize");
		NbtHelper.readInventory(this.slots, nbt);
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
	public String getInvName() {
		return "packer";
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
	public int[] getAccessibleSlotsFromSide(int var1) {
		return new int[0];
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public int getStateValue(int index) {
		if (index == 0)
			return this.getButtonState(0);
		if (index == 1)
			return this.getButtonState(1);
		return 0;
	}

	@Override
	public void setStateValue(int index, int value) {
		if (index == 0)
			if (extractStackSize >= 64) {
				setButtonState(0, 0);
				setDataViewState(0, 1);
				extractStackSize= getDataViewState(0);
			} else {
				setButtonState(0, 0);
				setDataViewState(0, getDataViewState(0) + 1);
				extractStackSize= getDataViewState(0);
			}

		if (index == 1)
			if (extractStackSize <= 1) {
				setButtonState(1, 0);
				setDataViewState(0, 64);
				extractStackSize= getDataViewState(0);
			} else {
				setButtonState(1, 0);
				setDataViewState(0, getDataViewState(0) - 1);
				extractStackSize= getDataViewState(0);
			}

	}

	@Override
	public int getMaxStateValue(int index) {
		if (index == 0)
			return 0;
		if (index == 1)
			return 0;
		return 0;
	}

	@Override
	public int getMinStateValue(int index) {
		if (index == 0)
			return 0;
		if (index == 1)
			return 0;
		return 0;
	}
}

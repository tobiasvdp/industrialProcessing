package ip.industrialProcessing.transport.items.conveyorPacker;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.containers.IMachineContainerEntity;
import ip.industrialProcessing.machines.plants.storage.storageBox.BlockStorageBox;
import ip.industrialProcessing.machines.plants.storage.storageRack.TileEntityStorageRack;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInteractionBase;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorPowerTranslation;
import ip.industrialProcessing.utils.DirectionUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityConveyorPacker extends TileEntityConveyorPowerTranslation implements IMachineContainerEntity {

    private static int tickOffset;
    ItemStack[] slots = new ItemStack[1 + BlockStorageBox.STORAGE_SIZE];
    private PackerOperationMode operationMode = PackerOperationMode.PACK_FULL;
    private int updateCycle = 20;
    private int ticks = 0;
    private LocalDirection boxInput = LocalDirection.LEFT;
    private LocalDirection boxOutput = LocalDirection.RIGHT;

    // 0: box slot
    // 1-9: Config

    public TileEntityConveyorPacker() {
	this.setConnectionMode(LocalDirection.LEFT, ConnectionMode.NONE);
	this.setConnectionMode(LocalDirection.RIGHT, ConnectionMode.NONE);
	this.setConnectionMode(LocalDirection.UP, ConnectionMode.NONE);
	this.setConnectionMode(LocalDirection.DOWN, ConnectionMode.NONE);
	this.ticks = (tickOffset++ % updateCycle);
    }

    @Override
    public void toggleSlope() {
	int index = operationMode.ordinal();
	index++;
	index %= 3;
	operationMode = PackerOperationMode.values()[index];
	System.out.println(operationMode);
    }

    public PackerOperationMode getOperationMode() {
	return operationMode;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (ticks++ > updateCycle) {
	    ticks = 0;
	    if (operationMode == PackerOperationMode.UNPACK) {
		extractFromBox();
	    } else
		checkBox();
	}
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	if (operationMode != null)
	    nbt.setInteger("Mode", operationMode.ordinal());
	NBTTagList list = new NBTTagList();
	for (int i = 0; i < slots.length; i++) {
	    if (slots[i] != null) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("Slot", i);
		slots[i].writeToNBT(compound);
		list.appendTag(compound);
	    }
	}
	nbt.setTag("Slots", list);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	if (nbt.hasKey("Mode"))
	    operationMode = PackerOperationMode.values()[nbt.getInteger("Mode")];
	if (nbt.hasKey("Slots")) {
	    NBTTagList list = nbt.getTagList("Slots");
	    for (int i = 0; i < list.tagCount(); i++) {
		NBTTagCompound compound = (NBTTagCompound) list.tagAt(i);
		int index = compound.getInteger("Slot");
		ItemStack stack = ItemStack.loadItemStackFromNBT(compound);
		if (index >= 0 && index < slots.length)
		    slots[index] = stack;
	    }
	}
    }

    private void checkBox() {
	if (this.slots[0] == null)
	    fetchBox();
    }

    private void extractFromBox() {
	ItemStack box = slots[0];
	if (box != null && box.itemID == IndustrialProcessing.blockStorageBox.blockID) {
	    boolean hasExtracted = false;
	    for (int i = 0; i < BlockStorageBox.STORAGE_SIZE; i++) {
		ItemStack stack = IndustrialProcessing.blockStorageBox.peekStackFromBox(box, i);
		if (stack != null) {
		    ItemStack configStack = slots[i + 1];
		    if (configStack == null || configStack.isItemEqual(stack)) { // only fetch configged items!
			stack = IndustrialProcessing.blockStorageBox.getStackFromBox(box, i, 8);
			this.addItemStack(stack, null);
			hasExtracted = true;
			onInventoryChanged();
			break;
		    }
		}
	    }
	    if (!hasExtracted) {
		ejectBox();
	    }
	} else {
	    fetchBox();
	}
    }

    private void fetchBox() {
	if (slots[0] == null) {
	    ForgeDirection left = DirectionUtils.getWorldDirection(boxInput, this.forwardDirection);
	    TileEntity te = this.worldObj.getBlockTileEntity(xCoord + left.offsetX, yCoord + left.offsetY, zCoord + left.offsetZ);
	    if (te instanceof TileEntityStorageRack) {
		TileEntityStorageRack rack = (TileEntityStorageRack) te;
		ItemStack box = rack.popBox();
		if (box != null) {
		    slots[0] = box;
		    onInventoryChanged();
		}
	    }
	}
    }

    private void ejectBox() {
	if (slots[0] != null) {
	    ForgeDirection left = DirectionUtils.getWorldDirection(boxOutput, this.forwardDirection);
	    TileEntity te = this.worldObj.getBlockTileEntity(xCoord + left.offsetX, yCoord + left.offsetY, zCoord + left.offsetZ);
	    if (te instanceof TileEntityStorageRack) {
		TileEntityStorageRack rack = (TileEntityStorageRack) te;
		if (rack.pushBox(slots[0])) {
		    slots[0] = null;
		    onInventoryChanged();
		}
	    }
	}
    }

    @Override
    protected void rerouteStack(MovingItemStack stack) {
	if (operationMode == PackerOperationMode.PACK_ANY || operationMode == operationMode.PACK_FULL) {
	    ItemStack box = slots[0];
	    if (box != null && box.itemID == IndustrialProcessing.blockStorageBox.blockID && stack.stack != null) {
		boolean packed = false;
		boolean accepted = false;
		for (int cI = 1; cI < slots.length; cI++) {
		    int bI = cI - 1;
		    ItemStack configSlot = slots[cI];
		    if (configSlot == null || configSlot.isItemEqual(stack.stack)) {
			accepted = true;
			ItemStack rest = putItemInBox(stack.stack, box, bI);
			if (rest == null || rest.stackSize <= 0) {
			    packed = true;
			    if (this.itemStacks.remove(stack)) {
				this.syncConveyor();
				break;
			    }
			} else {
			    if (rest.stackSize != stack.stack.stackSize) {
				packed = true;
				stack.stack = rest;
				this.syncConveyor();
			    }
			}
			onInventoryChanged();
		    }
		}
		if (accepted && !packed) {
		    // box might be full?!
		    if (operationMode == PackerOperationMode.PACK_ANY)
			ejectBox();
		    else if (operationMode == PackerOperationMode.PACK_FULL)
			if (isBoxFull())
			    ejectBox();
		}
	    }
	}
	stack.routed = true;
    }

    private boolean isBoxFull() {
	ItemStack box = slots[0];
	if (box == null) {
	    return false;
	}

	for (int i = 0; i < 9; i++) {
	    ItemStack peek = IndustrialProcessing.blockStorageBox.peekStackFromBox(box, i);
	    if (peek.stackSize < peek.getMaxStackSize())
		// stack can still grow, GO FOR IT
		return false;
	}
	return true;
    }

    private ItemStack putItemInBox(ItemStack stack, ItemStack box, int slot) {
	return IndustrialProcessing.blockStorageBox.putStackInBox(stack, box, slot);
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
	return !((i == 0) ^ (itemstack != null && itemstack.itemID == IndustrialProcessing.blockStorageBox.blockID));
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, int size) {
	return false;
    }

    // shouldn't get called, outputs are disabled.
    @Override
    protected ItemStack outputToTileEntity(MovingItemStack stack, TileEntity neighbor, ForgeDirection direction) {
	return stack.stack;
    }
}

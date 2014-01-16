package ip.industrialProcessing.machines;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.containers.IMachineContainerEntity;
import ip.industrialProcessing.subMod.logic.api.network.interfaces.IMachineInterface;
import ip.industrialProcessing.subMod.logic.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.subMod.logic.api.network.interfaces.StatusType;
import ip.industrialProcessing.utils.DirectionUtils;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMachine extends TileEntitySynced implements ISidedInventory, IMachineSlots, IRotateableEntity, IMachineContainerEntity, IMachineInterface {

    private String name;
    protected StatusType status = StatusType.active;
    private boolean enabled = true;
    private ArrayList<MachineItemStack> itemStacks = new ArrayList<MachineItemStack>();
    private int[][] itemStackSideSlots = new int[6][0];
    public boolean isDummyBlock = false;
    private ForgeDirection forwardDirection;

    @Override
    public boolean canUpdate() {
	return enabled;
    }

    @Override
    public ForgeDirection getForwardDirection() {
	return forwardDirection;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	writeInventory(nbt);
	if (this.forwardDirection != null)
	    nbt.setByte("ForwardDirection", (byte) this.forwardDirection.ordinal());
	if (this.name != null && this.name != "")
	    nbt.setString("Name", this.name);
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
	if (nbt.hasKey("ForwardDirection"))
	    this.forwardDirection = ForgeDirection.VALID_DIRECTIONS[nbt.getByte("ForwardDirection")];
	if (nbt.hasKey("Name"))
	    this.name = nbt.getString("Name");
    };

    private void readInventory(NBTTagCompound nbt) {
	if (!nbt.hasKey("Items"))
	    return;
	NBTTagList nbttaglist = nbt.getTagList("Items");
	for (int i = 0; i < nbttaglist.tagCount(); ++i) {
	    NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
	    byte b0 = nbttagcompound1.getByte("Slot");

	    if (b0 >= 0 && b0 < itemStacks.size()) {
		MachineItemStack machineStack = this.itemStacks.get(b0);
		machineStack.stack = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	    }
	}
    }

    @Override
    public boolean removeFromSlot(int slot, int itemId, int amount) {
	if (slotContains(slot, itemId, amount)) {
	    MachineItemStack machineStack = itemStacks.get(slot);
	    machineStack.stack.stackSize -= amount;
	    if (machineStack.stack.stackSize == 0)
		machineStack.stack = null;
	    onInventoryChanged();
	    return true;
	}
	return false;
    }

    @Override
    public boolean addToSlot(int slot, int itemId, int amount, int damage) {
	if (slotHasRoomFor(slot, itemId, amount, damage)) {
	    MachineItemStack machineStack = itemStacks.get(slot);
	    if (machineStack.stack == null)
		machineStack.stack = new ItemStack(itemId, amount, damage);
	    else
		machineStack.stack.stackSize += amount;
	    onInventoryChanged();
	    return true;
	}
	return false;
    }

    @Override
    public boolean slotContains(int slot, int itemId, int amount) {
	MachineItemStack machineStack = itemStacks.get(slot);
	return machineStack != null && machineStack.stack != null && machineStack.stack.itemID == itemId && machineStack.stack.stackSize >= amount;
    }

    @Override
    public boolean slotContains(int slot, int itemId, int metadata, int amount) {
	MachineItemStack machineStack = itemStacks.get(slot);
	return machineStack != null && machineStack.stack != null && machineStack.stack.itemID == itemId && machineStack.stack.stackSize >= amount;
    }

    @Override
    public boolean slotHasRoomFor(int slot, ItemStack stack) {
	if (stack == null || stack.stackSize == 0)
	    return true;
	MachineItemStack machineStack = itemStacks.get(slot);
	return machineStack != null && (machineStack.stack == null || (machineStack.stack.itemID == stack.itemID && (machineStack.stack.stackSize + stack.stackSize < stack.getMaxStackSize())));
    }

    @Override
    public boolean slotHasRoomFor(int slot, int itemId, int amount, int damage) {
	if (amount == 0)
	    return true;
	MachineItemStack machineStack = itemStacks.get(slot);
	return machineStack != null && (machineStack.stack == null || (machineStack.stack.itemID == itemId && machineStack.stack.getItemDamage() == damage && (machineStack.stack.stackSize + amount < machineStack.stack.getMaxStackSize())));
    }

    protected void addStack(ItemStack stack, LocalDirection side, boolean input, boolean output) {
	if (side == null)
	    addStack(stack, new LocalDirection[0], input, output);
	else
	    addStack(stack, new LocalDirection[] { side }, input, output);
    }

    protected void addStack(ItemStack stack, LocalDirection[] sides, boolean input, boolean output) {
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

    @Override
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

    public int getInventoryStackLimit(int slot) {
	return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
	return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
	MachineItemStack stack = getMachineStack(i);
	if (stack == null || itemstack == null)
	    return false;
	return stack.input && isValidInput(i, itemstack.itemID);
    }

    protected abstract boolean isValidInput(int slot, int itemID);

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
	LocalDirection localFrom = DirectionUtils.getLocalDirection(var1, getForwardDirection());
	return itemStackSideSlots[localFrom.ordinal()];
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

    @Override
    public boolean damageItem(int slot, int itemId) {
	itemStacks.get(slot).stack.setItemDamage(itemStacks.get(slot).stack.getItemDamage() + 1);
	return itemStacks.get(slot).stack.getItemDamage() >= itemStacks.get(slot).stack.getMaxDamage();
    }

    @Override
    public void setForwardDirection(ForgeDirection forwardFromMetadata) {
	this.forwardDirection = forwardFromMetadata;
	if (this.worldObj != null)
	    this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType().blockID);
    }

    @Override
    public boolean canWrenchRotate() {
	return true;
    }

    @Override
    public InterfaceType[] getConnectionTypes() {
	return new InterfaceType[] { InterfaceType.single, InterfaceType.inventory };
    };

    @Override
	public String getName() {
	return this.name;
    }

    public String setName(String name) {
	this.name = name;
	return name;
    }

    @Override
	public StatusType getStatus() {
	if (enabled)
	    return status;
	return StatusType.disabled;
    }

}

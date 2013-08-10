package ip.industrialProcessing.machines;

import ic2.api.Direction;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.packetHandlers.TileSyncHandler;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import ip.industrialProcessing.utils.working.ClientWorker;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import ip.industrialProcessing.utils.working.ServerWorker;
import ip.industrialProcessing.utils.working.WorkUtils;

import java.util.ArrayList;
import java.util.Stack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMachine extends TileEntity implements ISidedInventory, IWorkHandler, IMachineSlots, IRecipeWorkHandler, IWorkingEntity {

    private ArrayList<MachineItemStack> itemStacks = new ArrayList<MachineItemStack>();
    private int[][] itemStackSideSlots = new int[6][0]; 

     protected ForgeDirection getForwardDirection(){
	 int meta = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
	 return BlockMachine.getForwardFromMetadata(meta);
     }
    
    public TileEntityMachine() {
	this.serverWorker = createServerSideWorker();
	this.clientWorker = new ClientWorker();  
    }

    protected ServerWorker createServerSideWorker() {
	return new RecipeWorker(this);
    }

    protected ServerWorker serverWorker;
    protected ClientWorker clientWorker;

    public IWorker getWorker() {
	if (this.worldObj.isRemote)
	    return clientWorker;
	else
	    return serverWorker;
    }

    @Override
    public void updateEntity() {
	work(1);
    }

    @Override
    public boolean canUpdate() {
	return true;
    }

    protected int work(int amount) {
	return this.getWorker().doWork(amount);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	writeInventory(nbt);
	writeWorker(nbt);
    };

    private void writeWorker(NBTTagCompound nbt) {
	if (this.worldObj.isRemote) {
	    WorkUtils.writeToNBT(clientWorker, nbt);
	} else {
	    WorkUtils.writeToNBT(serverWorker, nbt);
	}
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
	readWorker(nbt);
    };

    private void readWorker(NBTTagCompound nbt) {
	WorkUtils.readFromNBT(clientWorker, nbt);
	WorkUtils.readFromNBT(serverWorker, nbt);
    }

    private void readInventory(NBTTagCompound nbt) {
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
    public boolean addToSlot(int slot, int itemId, int amount) {
	if (slotHasRoomFor(slot, itemId, amount)) {
	    MachineItemStack machineStack = itemStacks.get(slot);
	    if (machineStack.stack == null)
		machineStack.stack = new ItemStack(itemId, amount, 0);
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
    public boolean slotHasRoomFor(int slot, ItemStack stack) {
	if (stack == null || stack.stackSize == 0)
	    return true;
	MachineItemStack machineStack = itemStacks.get(slot);
	return machineStack != null && (machineStack.stack == null || (machineStack.stack.itemID == stack.itemID && (machineStack.stack.stackSize + stack.stackSize < getInventoryStackLimit())));
    }

    @Override
    public boolean slotHasRoomFor(int slot, int itemId, int amount) {
	if (amount == 0)
	    return true;
	MachineItemStack machineStack = itemStacks.get(slot);
	return machineStack != null && (machineStack.stack == null || (machineStack.stack.itemID == itemId && (machineStack.stack.stackSize + amount < getInventoryStackLimit())));
    }

    protected void addStack(ItemStack stack, LocalDirection side, boolean input, boolean output) {
	int index = itemStacks.size();
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

    private MachineItemStack getMachineStack(int i) {
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
	LocalDirection localFrom = DirectionUtils.GetLocalDirection(var1, getForwardDirection());
	return itemStackSideSlots[localFrom.ordinal()];
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
	    return true;
	}
	return false;
    }

    @Override
    public Packet getDescriptionPacket() {
	System.out.println("Sending " + this + "'s NBT data");
	NBTTagCompound nbtTag = new NBTTagCompound();
	this.writeToNBT(nbtTag);
	return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
	readFromNBT(packet.customParam1);
    }

    @Override
    public void workProgressed(int amount) {
    }

    @Override
    public void workCancelled() {
	notifyBlockChange();
    }

    @Override
    public void prepareWork() {
    }

    @Override
    public void beginWork() {
	notifyBlockChange();
    }

    @Override
    public void workDone() {
	notifyBlockChange();
    }

    protected void notifyBlockChange() {
	if (!this.worldObj.isRemote)
	    this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public boolean hasWork() {
	return true;
    }

    @Override
    public boolean canWork() {
	return true;
    }

    @Override
    public TileEntity getTileEntity() {
	return this;
    }
}

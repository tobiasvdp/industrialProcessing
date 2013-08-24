package ip.industrialProcessing.multiblock.extended.inventory;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import ip.industrialProcessing.machines.IMachineSlots;
import ip.industrialProcessing.machines.MachineItemStack;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.interfaces.IMultiblockInventoryBlock;
import ip.industrialProcessing.multiblock.interfaces.IMultiblockInventoryCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;

public abstract class TileEntityMultiblockCoreInv extends TileEntityMultiblockCore implements IMultiblockInventoryCore, IMachineSlots {

	protected ArrayList<MultiblockItemStack> itemStacks = new ArrayList<MultiblockItemStack>();

	public TileEntityMultiblockCoreInv(MultiblockLayout structure) {
		super(structure);
	}

	@Override
	public int getSizeInventory() {
		return itemStacks.size();
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return itemStacks.get(i).getItemStack();
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack stack = itemStacks.get(i).decrStack(itemStacks.get(i).getItemStack().itemID, j, true);
		onInventoryChanged();
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		itemStacks.get(i).setStack(itemstack);
		onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return null;
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
	public int[] getAccessibleSlotsForID(int ID) {
		ArrayList<Integer> validSlots = new ArrayList<Integer>();
		for (int i = 0; i < itemStacks.size(); i++) {
			if (itemStacks.get(i).hasID(ID))
				validSlots.add(i);
		}
		return ArrayUtils.toPrimitive(validSlots.toArray(new Integer[validSlots.size()]));
	}

	@Override
	public boolean canInsertItemForSlot(int i, ItemStack itemstack) {
		if (state != MultiblockState.COMPLETED)
			return false;
		if (itemStacks.get(i).getIsInput() && itemStacks.get(i).incStack(itemstack.itemID, itemstack.stackSize, false))
			return isItemValidForSlot(i,itemstack);
		return false;
	}

	@Override
	public boolean canExtractItemForSlot(int i, ItemStack itemstack) {
		if (state != MultiblockState.COMPLETED)
			return false;
		if (!itemStacks.get(i).getIsInput() && itemStacks.get(i).getItemStack().stackSize >= itemstack.stackSize) {
			return isItemValidForSlot(i,itemstack);
		}
		return false;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	public int getSlotforID(int ID) {
		for (int i = 0; i < itemStacks.size(); i++) {
			if (itemStacks.get(i).hasID(ID)) {
				return i;
			}
		}
		return -1;
	}

	public int prevValidID(int inventoryID) {
		boolean isInput = itemStacks.get(inventoryID).getIsInput();

		for (int i = inventoryID - 1; i >= 0; i--) {
			if (itemStacks.get(i).getIsInput() == isInput) {
				return i;
			}
		}
		return inventoryID;
	}

	public int nextValidID(int inventoryID) {
		boolean isInput = itemStacks.get(inventoryID).getIsInput();

		for (int i = inventoryID + 1; i < itemStacks.size(); i++) {
			if (itemStacks.get(i).getIsInput() == isInput) {
				return i;
			}
		}
		return inventoryID;
	}

	public int firstValidID(boolean isInput) {
		for (int i = 0; i < itemStacks.size(); i++) {
			if (itemStacks.get(i).getIsInput() == isInput) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.customParam1);
	}

	protected void notifyBlockChange() {
		if (!this.worldObj.isRemote)
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		writeInventory(par1nbtTagCompound);
	}

	private void writeInventory(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.itemStacks.size(); ++i) {
			MultiblockItemStack stack = this.itemStacks.get(i);
			if (stack.getItemStack() != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				stack.getItemStack().writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		readInventory(par1nbtTagCompound);
	};

	private void readInventory(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Items");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < itemStacks.size()) {
				MultiblockItemStack stack = this.itemStacks.get(b0);
				stack.setStack(ItemStack.loadItemStackFromNBT(nbttagcompound1));
			}
		}
	}

	@Override
	public boolean slotContains(int slot, int itemId, int amount) {
		MultiblockItemStack machineStack = itemStacks.get(slot);
		return machineStack != null && machineStack.getItemStack() != null && machineStack.getItemStack().itemID == itemId && machineStack.getItemStack().stackSize >= amount;
	}
	@Override
	public boolean slotContains(int slot, int itemId,int metadata, int amount) {
		MultiblockItemStack machineStack = itemStacks.get(slot);
		return machineStack != null && machineStack.getItemStack() != null && machineStack.getItemStack().itemID == itemId && machineStack.getItemStack().stackSize >= amount && machineStack.getItemStack().getItemDamage() == metadata;
	}

	@Override
	public boolean slotHasRoomFor(int slot, ItemStack stack) {
		if (stack == null || stack.stackSize == 0)
			return true;
		MultiblockItemStack machineStack = itemStacks.get(slot);
		return machineStack != null && (machineStack.getItemStack() == null || (machineStack.getItemStack().itemID == stack.itemID && (machineStack.getItemStack().stackSize + stack.stackSize < getInventoryStackLimit())));
	}

	@Override
	public boolean slotHasRoomFor(int slot, int itemId, int amount) {
		if (amount == 0)
			return true;
		MultiblockItemStack machineStack = itemStacks.get(slot);
		return machineStack != null && (machineStack.getItemStack() == null || (machineStack.getItemStack().itemID == itemId && (machineStack.getItemStack().stackSize + amount < getInventoryStackLimit())));
	}

	@Override
	public boolean addToSlot(int slot, int itemId, int maxAmount) {
		if (slotHasRoomFor(slot, itemId, maxAmount)) {
			MultiblockItemStack machineStack = itemStacks.get(slot);
			if (machineStack.getItemStack() == null)
				machineStack.setStack(itemId, maxAmount);
			else
				machineStack.getItemStack().stackSize += maxAmount;
			onInventoryChanged();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeFromSlot(int slot, int itemId, int maxAmount) {
		if (slotContains(slot, itemId, maxAmount)) {
			MultiblockItemStack machineStack = itemStacks.get(slot);
			machineStack.getItemStack().stackSize -= maxAmount;
			if (machineStack.getItemStack().stackSize == 0)
				machineStack.setStack(null);
			onInventoryChanged();
			return true;
		}
		return false;
	}
	@Override
	public boolean damageItem(int slot, int itemId) {
		return itemStacks.get(slot).damageItem();
	}

	public boolean canInsertItem(int index, ItemStack stack, int stackSize) {
		return canInsertItemForSlot(index,stack);
	}
}

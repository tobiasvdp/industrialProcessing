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
import ip.industrialProcessing.machines.MachineItemStack;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.interfaces.IMultiblockInventoryBlock;
import ip.industrialProcessing.multiblock.interfaces.IMultiblockInventoryCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;

public class TileEntityMultiblockCoreInv extends TileEntityMultiblockCore implements IMultiblockInventoryCore {

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
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO recipe dependent
		return true;
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
			return true;
		return false;
	}

	@Override
	public boolean canExtractItemForSlot(int i, ItemStack itemstack) {
		if (state != MultiblockState.COMPLETED)
			return false;
		if (!itemStacks.get(i).getIsInput() && itemStacks.get(i).getItemStack().stackSize >= itemstack.stackSize) {
			System.out.println(worldObj);
			return true;
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

}

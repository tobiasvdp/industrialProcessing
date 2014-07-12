package mod.industrialProcessing.blockContainer.multiblock.core.extend;

import java.util.ArrayList;

import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.utils.inventory.IMultiblockInventories;
import mod.industrialProcessing.blockContainer.multiblock.utils.inventory.MultiblockItemStack;
import mod.industrialProcessing.utils.inventory.IInventorySlots;
import mod.industrialProcessing.utils.inventory.itemstack.MachineItemStack;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public abstract class TileEntityMultiblockCoreInv extends TileEntityMultiblockCore implements ISidedInventory, IInventorySlots,IMultiblockInventories {

	protected RecipesMultiblock recipes;
	protected ArrayList<MultiblockItemStack> itemStacks = new ArrayList<MultiblockItemStack>();
	protected int[][][] itemStackSideSlots;
	public boolean isDummyBlock = false;
	
	public void setInventoryGroupArray(int i){
		itemStackSideSlots = new int[i][6][0];
	}

	public TileEntityMultiblockCoreInv(StructureMultiblock structure, TierCollection tierRequirments, RecipesMultiblock recipes2) {
		super(structure, tierRequirments);
		this.recipes = recipes2;
	}

	// inventory core handler
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeInventory(nbt);
	}

	public void writeInventory(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.itemStacks.size(); ++i) {
			MultiblockItemStack machineStack = this.itemStacks.get(i);
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

	public void readInventory(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Items",10);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < itemStacks.size()) {
				MultiblockItemStack machineStack = this.itemStacks.get(b0);
				machineStack.stack = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	} 

	@Override
	public boolean removeFromSlot(int slot, int amount) {
		if (slot >= itemStacks.size())
			return false;
		MachineItemStack machineStack = itemStacks.get(slot);
		if (machineStack.stack == null)
			return false;
		if (machineStack.stack.stackSize < amount)
			return false;

		machineStack.stack.stackSize -= amount;
		if (machineStack.stack.stackSize == 0)
			machineStack.stack = null;
		onInventoryChanged();
		return true;
	}
	
	protected void onInventoryChanged() {
		this.markDirty();
	}
 
	public boolean addToSlot(int slot, Item item, int amount, int damage) {
		return addToSlot(slot, new ItemStack(item, amount, damage));
	}
	
	@Override
	public boolean addToSlot(int slot, ItemStack stack) {
		if (slotHasRoomFor(slot, stack)) {
			MachineItemStack machineStack = getMachineStack(slot);
			if (machineStack.stack == null)
				machineStack.stack = stack.copy();
			else
				machineStack.stack.stackSize += stack.stackSize;
			onInventoryChanged();
			return true;
		}
		return false;
	}

	@Override
	public boolean slotContains(int slot, Item itemId, int amount) {
		MachineItemStack machineStack = getMachineStack(slot);
		return machineStack != null && machineStack.stack != null && machineStack.stack.getItem().equals(itemId) && machineStack.stack.stackSize >= amount;
	}

	@Override
	public boolean slotContains(int slot, Item itemId, int metadata, int amount) {
		MachineItemStack machineStack = getMachineStack(slot);
		return machineStack != null && machineStack.stack != null && machineStack.stack.getItem().equals(itemId)  && machineStack.stack.stackSize >= amount && machineStack.stack.getItemDamage() == metadata;
	}

	@Override
	public boolean slotHasRoomFor(int slot, ItemStack stack) {
		if (stack == null || stack.stackSize == 0)
			return true;
		MachineItemStack machineStack = getMachineStack(slot);
		return machineStack != null && (machineStack.stack == null || (machineStack.stack.getItem().equals(stack.getItem()) && (machineStack.stack.stackSize + stack.stackSize < stack.getMaxStackSize())));
	}

	@Override
	public boolean slotHasRoomFor(int slot, Item itemId, int amount, int damage) {
		if (amount == 0)
			return true;
		MachineItemStack machineStack = getMachineStack(slot);
		return machineStack != null && (machineStack.stack == null || (machineStack.stack.getItem().equals(itemId) && machineStack.stack.getItemDamage() == damage && (machineStack.stack.stackSize + amount < machineStack.stack.getMaxStackSize())));
	}

	protected void addStack(ItemStack stack, LocalDirection side, boolean input, boolean output) {
		int index = itemStacks.size();
		addStack(stack, new LocalDirection[] { side }, input, output);
	}
	
	protected void addStack(ItemStack stack,int multiblockID, LocalDirection side, boolean input, boolean output) {
		int index = itemStacks.size();
		addStack(stack, multiblockID,new LocalDirection[] { side }, input, output);
	}

	protected void addStack(ItemStack stack, LocalDirection[] sides, boolean input, boolean output) {
		addStack(stack, 0, sides, input, output);
	}
	
	protected void addStack(ItemStack stack,int multiblockID, LocalDirection[] sides, boolean input, boolean output) {
		int index = itemStacks.size();
		int[] sideIndices = new int[sides.length];
		for (int i = 0; i < sideIndices.length; i++) {
			sideIndices[i] = sides[i].ordinal();
		}

		itemStacks.add(new MultiblockItemStack(stack,multiblockID, sideIndices, input, output));

		for (int i = 0; i < sideIndices.length; i++) {
			int sideIndex = sideIndices[i];
			int[] slots = itemStackSideSlots[multiblockID][sideIndex];
			int[] newSlots = new int[slots.length + 1];
			System.arraycopy(slots, 0, newSlots, 0, slots.length);
			newSlots[slots.length] = index;
			itemStackSideSlots[multiblockID][sideIndex] = newSlots;
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
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public int getInventoryStackLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}


	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		MachineItemStack stack = getMachineStack(i);
		if (stack == null || itemstack == null)
			return false;
		return stack.input && isValidInput(i, itemstack.getItem());
	}

	protected abstract boolean isValidInput(int slot, Item itemID);

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return getAccessibleSlotsFromSide(0, var1);
	}

	@Override
	public boolean canInsertItem(int slotIndex, ItemStack itemstack, int amount) {
		return canInsertItem(0, slotIndex, itemstack, amount);
	}

	@Override
	public boolean canExtractItem(int slotIndex, ItemStack itemstack, int amount) {
		return canExtractItem(0, slotIndex, itemstack, amount);
	}

	@Override
	public boolean damageItem(int slot) {
		getMachineStack(slot).stack.setItemDamage(getMachineStack(slot).stack.getItemDamage()+1);
		return getMachineStack(slot).stack.getItemDamage()>=getMachineStack(slot).stack.getMaxDamage();
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int multiblockID,int var1){
		LocalDirection localFrom = DirectionUtils.getLocalDirection(var1, getForwardDirection());
		return itemStackSideSlots[multiblockID][localFrom.ordinal()];
	 }
	 @Override
	public boolean canInsertItem(int multiblockID,int i, ItemStack itemstack, int j){
		 MultiblockItemStack machineStack = getMultiblockStack(i);
			if (machineStack != null && machineStack.input && machineStack.getMultiblockID() == multiblockID) {
				if (machineStack.stack == null) {
					return isItemValidForSlot(i, itemstack);
				} else if (machineStack.stack.stackSize + j <= 64) {
					return isItemValidForSlot(i, itemstack);
				}
			}
			return false;
	 }

	@Override
	public boolean canExtractItem(int multiblockID,int i, ItemStack itemstack, int j){
		MultiblockItemStack machineStack = getMultiblockStack(i);
		if (machineStack != null && machineStack.output && machineStack.getMultiblockID() == multiblockID) {
			return true;
		}
		return false;
	}

	@Override
	public MultiblockItemStack getMultiblockStack(int i) {
		if (i < 0 || i >= this.itemStacks.size())
			return null;
		return this.itemStacks.get(i);
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



}

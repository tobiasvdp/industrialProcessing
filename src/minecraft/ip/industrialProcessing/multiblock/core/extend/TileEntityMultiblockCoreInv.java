package ip.industrialProcessing.multiblock.core.extend;

import java.util.ArrayList;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.MachineItemStack;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.utils.inventory.IMultiblockInventories;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.inventories.IInventories;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public abstract class TileEntityMultiblockCoreInv extends TileEntityMultiblockCore implements IInventories,IMultiblockInventories {

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
		NBTTagList nbttaglist = nbt.getTagList("Items");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < itemStacks.size()) {
				MultiblockItemStack machineStack = this.itemStacks.get(b0);
				machineStack.stack = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
	public boolean removeFromSlot(int slot, int itemId, int amount) {
		if (slotContains(slot, itemId, amount)) {
			MachineItemStack machineStack = getMachineStack(slot);
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
			MachineItemStack machineStack = getMachineStack(slot);
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
		MachineItemStack machineStack = getMachineStack(slot);
		return machineStack != null && machineStack.stack != null && machineStack.stack.itemID == itemId && machineStack.stack.stackSize >= amount;
	}

	@Override
	public boolean slotContains(int slot, int itemId, int metadata, int amount) {
		MachineItemStack machineStack = getMachineStack(slot);
		return machineStack != null && machineStack.stack != null && machineStack.stack.itemID == itemId && machineStack.stack.stackSize >= amount && machineStack.stack.getItemDamage() == metadata;
	}

	@Override
	public boolean slotHasRoomFor(int slot, ItemStack stack) {
		if (stack == null || stack.stackSize == 0)
			return true;
		MachineItemStack machineStack = getMachineStack(slot);
		return machineStack != null && (machineStack.stack == null || (machineStack.stack.itemID == stack.itemID && (machineStack.stack.stackSize + stack.stackSize < stack.getMaxStackSize())));
	}

	@Override
	public boolean slotHasRoomFor(int slot, int itemId, int amount, int damage) {
		if (amount == 0)
			return true;
		MachineItemStack machineStack = getMachineStack(slot);
		return machineStack != null && (machineStack.stack == null || (machineStack.stack.itemID == itemId && machineStack.stack.getItemDamage() == damage && (machineStack.stack.stackSize + amount < machineStack.stack.getMaxStackSize())));
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
		MachineItemStack stack = getMachineStack(i);
		if (stack == null || itemstack == null)
			return false;
		return stack.input && isValidInput(i, itemstack.itemID);
	}

	protected abstract boolean isValidInput(int slot, int itemID);

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
	public boolean damageItem(int slot, int itemId) {
		getMachineStack(slot).stack.setItemDamage(getMachineStack(slot).stack.getItemDamage()+1);
		return getMachineStack(slot).stack.getItemDamage()>=getMachineStack(slot).stack.getMaxDamage();
	}
	
	
	public int transformSideToLayoutSide(int side) {
		switch (this.side) {

		case North:
			break;
		case East:
			switch (side) {
			case 2:
				side = 4;
				break;
			case 3:
				side = 5;
				break;
			case 4:
				side =3;
				break;
			case 5:
				side =2;
				break;
			}
			break;
		case South:
			switch (side) {
			case 2:
				side = 3;
				break;
			case 3:
				side = 2;
				break;
			case 4:
				side =5;
				break;
			case 5:
				side =4;
				break;
			}
			break;
		case West:
			switch (side) {
			case 2:
				side = 5;
				break;
			case 3:
				side = 4;
				break;
			case 4:
				side =2;
				break;
			case 5:
				side =3;
				break;
			}
			break;
		case Invalid:
			break;
		default:
			break;

		}
		return side;
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



}

package ip.industrialProcessing.multiblock.utils;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class MultiblockItemStack {
	private ArrayList<Integer> validIDs = new ArrayList<Integer>();
	private ItemStack itemStack;
	public MultiblockItemStack(int... ID) {
		for (int i = 0; i < ID.length; i++) {
			addID(ID[i]);
		}
	}

	public void addID(int ID) {
		validIDs.add(ID);
	}

	public boolean removeID(int ID) {
		for (int i = 0; i < validIDs.size(); i++) {
			if (validIDs.get(i) == ID) {
				validIDs.remove(i);
				return true;
			}
		}
		return false;
	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public ItemStack decrStack(int ID, int amount, boolean doIt) {
		ItemStack prevStack = itemStack.copy();
		if (itemStack != null && itemStack.itemID == ID) {
			if (amount < itemStack.stackSize) {

				if (doIt)
					prevStack = itemStack.splitStack(amount);
				return prevStack;
			} else if (amount == itemStack.stackSize) {
				if (doIt)
					itemStack = null;
				return prevStack;
			}
		}
		return prevStack;
	}

	public boolean incStack(int ID, int amount, boolean doIt) {
		if (itemStack == null) {
			if (doIt)
				itemStack = new ItemStack(ID, amount, 0);
			return true;
		} else if (ID == itemStack.itemID && amount <= itemStack.getMaxStackSize() - itemStack.stackSize) {
			if (doIt)
				itemStack.stackSize = itemStack.stackSize - amount;
			return true;
		}
		return false;
	}

	public boolean setStack(int ID, int amount) {
		if (amount <= itemStack.getMaxStackSize()) {
			itemStack = new ItemStack(ID, amount, 0);
			return true;
		}
		return false;
	}

	public boolean hasID(int ID) {
		for (int i = 0; i < validIDs.size(); i++) {
			if (validIDs.get(i) == ID) {
				return true;
			}
		}
		return false;
	}

	public void setStack(ItemStack itemstack2) {
		if (itemstack2 != null) {
			itemStack = new ItemStack(itemstack2.itemID, itemstack2.stackSize, itemstack2.getItemDamage());
		}
	}

}

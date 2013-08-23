package ip.industrialProcessing.multiblock.utils.inventory;

import ip.industrialProcessing.items.ItemDamage;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public class MultiblockItemStack {
	private ArrayList<Integer> validIDs = new ArrayList<Integer>();
	private ItemStack itemStack;
	private boolean input;
	private boolean output;
	public MultiblockItemStack(boolean input,boolean output,int... ID) {
		this.input = input;
		this.output = output;
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
		if (itemStack == null)
			return null;

		ItemStack stack = itemStack;
		if (stack == null)
			return null;

		if (stack.stackSize > amount) {
			stack = stack.splitStack(amount);
			return stack;
		}
		itemStack = null;
		return stack;
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
		if (amount <= (new ItemStack(ID,amount,0).getMaxStackSize())) {
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
	public boolean getIsInput(){
		return input;
	}
	public boolean damageItem(){
		if (itemStack.getItem() != null && itemStack.getItem() instanceof ItemDamage){
			ItemStack damagedStack = new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage() + 1);

			if (damagedStack.getItemDamage() >= damagedStack.getMaxDamage()) {
				damagedStack.stackSize--;
			}
			if (damagedStack.stackSize != 0)
				itemStack = damagedStack;
			else
				itemStack = null;
			return true;
			
		}
		return false;
	}

}

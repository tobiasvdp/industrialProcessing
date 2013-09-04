package ip.industrialProcessing.multiblock.utils;

import ip.industrialProcessing.items.ItemDamage;
import ip.industrialProcessing.machines.MachineItemStack;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public class MultiblockItemStack {
	private ArrayList<MultiblockItemStackID> validIO = new ArrayList<MultiblockItemStackID>();
	private ItemStack itemStack;
	private TEmultiblockItemStackType type;

	public MultiblockItemStack(TEmultiblockItemStackType type) {
		this.type = type;
	}

	public MultiblockItemStack addIdSide(int ID, blockSide... sides) {
		validIO.add(new MultiblockItemStackID(ID, sides));
		return this;
	}

	public boolean removeID(int ID) {
		return false;
	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public ItemStack decrStack(int i, int j, boolean doIt) {
		if (this.itemStack == null)
			return null;
		ItemStack stack = this.itemStack;
		if (stack == null)
			return null;

		if (stack.stackSize > j) {
			stack = stack.splitStack(j);
			if (itemStack.stackSize == 0)
				itemStack = null;
			return stack;
		}
		this.itemStack = null;
		if (stack.stackSize == 0)
			stack = null;
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
		if (amount <= (new ItemStack(ID, amount, 0).getMaxStackSize())) {
			itemStack = new ItemStack(ID, amount, 0);
			return true;
		}
		return false;
	}

	public void setStack(ItemStack itemstack2) {
		if (itemstack2 != null) {
			itemStack = new ItemStack(itemstack2.itemID, itemstack2.stackSize, itemstack2.getItemDamage());
		} else
			itemStack = null;
	}

	public boolean getIsInput() {
		return type == TEmultiblockItemStackType.input || type == TEmultiblockItemStackType.inout;
	}

	public boolean getIsOutput() {
		return type == TEmultiblockItemStackType.output || type == TEmultiblockItemStackType.inout;
	}

	public boolean damageItem() {
		if (itemStack.getItem() != null && itemStack.getItem() instanceof ItemDamage) {
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

	public boolean hasIDandSide(int id, int side) {
		for (MultiblockItemStackID idAndSide : validIO) {
			if (idAndSide.isValid(id, side))
				return true;
		}
		return false;
	}

}

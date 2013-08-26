package ip.industrialProcessing.utils.inventories;

import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.BlockForward;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public final class Inventories{

	public static int getSizeInventory(ArrayList<MultiblockItemStack> itemStacks) {
		return itemStacks.size();
	}


	public static ItemStack getStackInSlot(int i,ArrayList<MultiblockItemStack> itemStacks) {
		return itemStacks.get(i).getItemStack();
	}


	public static ItemStack decrStackSize(int i, int j,TileEntity te,ArrayList<MultiblockItemStack> itemStacks) {
		ItemStack stack = itemStacks.get(i).decrStack(itemStacks.get(i).getItemStack().itemID, j, true);
		onInventoryChanged(te);
		return stack;
	}


	public static ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}


	public static void setInventorySlotContents(int i, ItemStack itemstack,TileEntity te,ArrayList<MultiblockItemStack> itemStacks) {
		itemStacks.get(i).setStack(itemstack);
		onInventoryChanged(te);
	}


	public static String getInvName() {
		return null;
	}


	public static boolean isInvNameLocalized() {
		return false;
	}


	public static int getInventoryStackLimit() {
		return 64;
	}


	public static void onInventoryChanged(TileEntity te) {
		te.onInventoryChanged();
	}


	public static boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	public static boolean isItemValidForSlot(int slot, ItemStack itemstack,RecipesMachine recipes,ArrayList<MultiblockItemStack> itemStacks) {
		int itemID = itemstack.itemID;
		if (slot > 1||slot > 11 || slot < 11)
			return recipes.isValidInput(slot, itemID);
		if (slot == 0) {
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
			if (fluid == null)
				return false;
			return recipes.isValidFluidInput(0, fluid.fluidID);
		}
		return false;
	}


	public static int[] getAccessibleSlotsFromSide(int ID,int side,ArrayList<MultiblockItemStack> itemStacks) {
		ArrayList<Integer> validSlots = new ArrayList<Integer>();
		for (int i = 0; i < itemStacks.size(); i++) {
			if (itemStacks.get(i).hasID(ID))
				if(itemStacks.get(i).hasSide(side))
					validSlots.add(i);
		}
		return ArrayUtils.toPrimitive(validSlots.toArray(new Integer[validSlots.size()]));
	}


	public static boolean canInsertItem(int i, ItemStack itemstack, int ID,int side,MultiblockState state,RecipesMachine recipes,ArrayList<MultiblockItemStack> itemStacks) {
		if (state != MultiblockState.COMPLETED)
			return false;
		if (itemStacks.get(i).getIsInput() && itemStacks.get(i).incStack(itemstack.itemID, itemstack.stackSize, false))
			return isItemValidForSlot(i,itemstack,recipes,itemStacks);
		return false;
	}


	public static boolean canExtractItem(int i, ItemStack itemstack, int ID,int side,MultiblockState state,RecipesMachine recipes,ArrayList<MultiblockItemStack> itemStacks) {
		if (state != MultiblockState.COMPLETED)
			return false;
		if (!itemStacks.get(i).getIsInput() && itemStacks.get(i).getItemStack().stackSize >= itemstack.stackSize) {
			return isItemValidForSlot(i,itemstack,recipes,itemStacks);
		}
		return false;
	}

	public static void writeInventory(NBTTagCompound nbt,ArrayList<MultiblockItemStack> itemStacks) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < itemStacks.size(); ++i) {
			MultiblockItemStack stack = itemStacks.get(i);
			if (stack.getItemStack() != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				stack.getItemStack().writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
	}

	public static void readInventory(NBTTagCompound nbt,ArrayList<MultiblockItemStack> itemStacks) {
		NBTTagList nbttaglist = nbt.getTagList("Items");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < itemStacks.size()) {
				MultiblockItemStack stack = itemStacks.get(b0);
				stack.setStack(ItemStack.loadItemStackFromNBT(nbttagcompound1));
			}
		}
	}

}

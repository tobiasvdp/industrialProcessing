package ip.industrialProcessing.multiblock.extended.inventory;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.inventory.IMultiblockInventoryBlock;
import ip.industrialProcessing.multiblock.utils.inventory.IMultiblockInventoryCore;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;

public class TileEntityMultiblockCoreInv extends TileEntityMultiblockCore
		implements IMultiblockInventoryCore {
	
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
		ArrayList<Integer> validSlots =  new ArrayList<Integer>();
		for (int i = 0;i<itemStacks.size();i++){
			if (itemStacks.get(i).hasID(ID))
				validSlots.add(i);
		}
		return ArrayUtils.toPrimitive(validSlots.toArray(new Integer[validSlots.size()]));
	}

	@Override
	public boolean canInsertItemForID(int i, ItemStack itemstack, int j) {
		if(state != MultiblockState.COMPLETED)
			return false;
		if(itemStacks.get(i).hasID(j)){
			if(itemStacks.get(i).incStack(itemstack.itemID, itemstack.stackSize, false))
				return true;
		}
		return false;
	}

	@Override
	public boolean canExtractItemForID(int i, ItemStack itemstack, int j) {
		if(state != MultiblockState.COMPLETED)
			return false;
		if(itemStacks.get(i).hasID(j)){
			if(itemStacks.get(j).getItemStack().stackSize != itemStacks.get(j).decrStack(itemstack.itemID, itemstack.stackSize, false).stackSize)
				return true;
		}
		return false;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}
	public int getSlotforID(int ID){
		for(int i = 0;i<itemStacks.size();i++){
			if (itemStacks.get(i).hasID(ID)){
				return i;
			}
		}
		return -1;
	}

	public int prevValidID(int inventoryID) {
		boolean isInput = itemStacks.get(inventoryID).getIsInput();
		
		for(int i = inventoryID-1;i>=0;i--){
			if (itemStacks.get(i).getIsInput()==isInput){
				return i;
			}
		}
		return inventoryID;
	}

	public int nextValidID(int inventoryID) {
		boolean isInput = itemStacks.get(inventoryID).getIsInput();
		
		for(int i = inventoryID+1;i<itemStacks.size();i++){
			if (itemStacks.get(i).getIsInput()==isInput){
				return i;
			}
		}
		return inventoryID;
	}

	public int firstValidID(boolean isInput) {
		for(int i = 0;i<itemStacks.size();i++){
			if (itemStacks.get(i).getIsInput()==isInput){
				return i;
			}
		}
		return 0;
	}
	
}

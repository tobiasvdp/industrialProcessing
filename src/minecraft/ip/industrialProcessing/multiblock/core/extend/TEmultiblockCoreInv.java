package ip.industrialProcessing.multiblock.core.extend;

import java.util.ArrayList;

import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.utils.inventories.IInventories;
import ip.industrialProcessing.utils.inventories.Inventories;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TEmultiblockCoreInv extends TEmultiblockCore implements IInventories{

	protected ArrayList<MultiblockItemStack> itemStacks = new ArrayList<MultiblockItemStack>();
	protected RecipesMachine recipes;
	protected MultiblockState state;
	
	public TEmultiblockCoreInv(StructureMultiblock structure) {
		super(structure);
	}

	//Inventory handler
	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return this.getAccessibleSlotsFromSide(0, side);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int side) {
		return this.canInsertItem(i, itemstack, 0, side);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int side) {
		return this.canExtractItem(i, itemstack, 0, side);
	}

	@Override
	public int getSizeInventory() {
		return Inventories.getSizeInventory(itemStacks);
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return Inventories.getStackInSlot(i, itemStacks);
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return Inventories.decrStackSize(i, j, this, itemStacks);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return Inventories.getStackInSlotOnClosing(i);
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		Inventories.setInventorySlotContents(i, itemstack, this, itemStacks);
	}

	@Override
	public String getInvName() {
		return Inventories.getInvName();
	}

	@Override
	public boolean isInvNameLocalized() {
		return Inventories.isInvNameLocalized();
	}

	@Override
	public int getInventoryStackLimit() {
		return Inventories.getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return Inventories.isUseableByPlayer(entityplayer);
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return Inventories.isItemValidForSlot(slot, itemstack, recipes, itemStacks);
	}

	//inventory core handler
	@Override
	public int[] getAccessibleSlotsFromSide(int ID, int side) {
		return Inventories.getAccessibleSlotsFromSide(ID, side, itemStacks);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int ID, int side) {
		return Inventories.canInsertItem(i, itemstack, ID, side, state, recipes, itemStacks);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int ID, int side) {
		return Inventories.canInsertItem(i, itemstack, ID, side, state, recipes, itemStacks);
	}

	@Override
	public void writeInventory(NBTTagCompound nbt) {
		Inventories.writeInventory(nbt, itemStacks);
	}

	@Override
	public void readInventory(NBTTagCompound nbt) {
		Inventories.readInventory(nbt, itemStacks);
	}

}

package ip.industrialProcessing.machines.crusher;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCrusher extends TileEntity implements ISidedInventory{
	private ItemStack[] itemStacks = new ItemStack[2];
	public int workTime = 0;
	public int workingTime = 0;
	public boolean isWorking = false;
	private String field_94130_e;
	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setShort("workTime", (short) this.workTime);
		par1.setShort("workingTime", (short) this.workingTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.itemStacks.length; ++i) {
			if (this.itemStacks[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}	
		par1.setTag("Items", nbttaglist);

		if (this.isInvNameLocalized()) {
			par1.setString("Crusher", this.field_94130_e);
		}
	}
	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		NBTTagList nbttaglist = par1.getTagList("Items");
		this.itemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist
					.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.itemStacks.length) {
				this.itemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}
		
	public TileEntityCrusher() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSizeInventory() {
		return itemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.itemStacks[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (this.itemStacks[slot] != null) {
			ItemStack itemstack;

			if (this.itemStacks[slot].stackSize <= amount) {
				itemstack = this.itemStacks[slot];
				this.itemStacks[slot] = null;
				return itemstack;
			} else {
				itemstack = this.itemStacks[slot].splitStack(amount);

				if (this.itemStacks[slot].stackSize == 0) {
					this.itemStacks[slot] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInvName() {
		return this.isInvNameLocalized() ? this.field_94130_e: "container.seperator";
	}

	@Override
	public boolean isInvNameLocalized() {
		return this.field_94130_e != null && this.field_94130_e.length() > 0;
	}
	
	public void func_94129_a(String par1Str) {
		this.field_94130_e = par1Str;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord,
				this.zCoord) != this ? false : entityplayer.getDistanceSq(
				(double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
				(double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		switch (i) {
		case 0:
			if (itemstack.itemID == Block.gravel.blockID) {
				return true;
			}
			break;
		case 1:
			return false;
		default:
			return false;
		}
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean canUpdate() {
		return true;
	}
	
	@Override
	public void updateEntity() {
		
	}
	public int getScaledProgress(int size) {
		if (workingTime != 0) {
			return (workTime * size / workingTime);
		} else {
			return 1;
		}
	}

}

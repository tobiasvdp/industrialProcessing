package ip.industrialProcessing.utils.inventories;

import ip.industrialProcessing.machines.MachineItemStack;
import ip.industrialProcessing.machines.filter.TileEntityFilter;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public final class InventoryUtils {
	public static void DropInventoryContents(World world, int x, int y, int z)
	{
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (!(tileEntity instanceof IInventory)) {
                return;
        }
        IInventory inventory = (IInventory) tileEntity;

        Random rand = new Random();
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack item = inventory.getStackInSlot(i);
                if (item != null && item.stackSize > 0) {
                		inventory.setInventorySlotContents(i, null);
                        float rx = rand.nextFloat() * 0.8F + 0.1F;
                        float ry = rand.nextFloat() * 0.8F + 0.1F;
                        float rz = rand.nextFloat() * 0.8F + 0.1F;

                        EntityItem entityItem = new EntityItem(world,
                                        x + rx, y + ry, z + rz,
                                        new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                        if (item.hasTagCompound()) {
                                entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                        }

                        float factor = 0.05F;
                        entityItem.motionX = rand.nextGaussian() * factor;
                        entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                        entityItem.motionZ = rand.nextGaussian() * factor;
                        world.spawnEntityInWorld(entityItem);
                        item.stackSize = 0;
                }
        }
	}

	public static void WriteInventory(IItemStacksInventory inventory, NBTTagCompound  nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		ItemStack[] itemStacks = inventory.getStacks();
		for (int i = 0; i < itemStacks.length; ++i) {
			if (itemStacks[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				itemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			} 
 
		}	
		nbt.setTag("Items", nbttaglist);		
	}
	public static void ReadInventory(IItemStacksInventory inventory, NBTTagCompound  nbt) {

		ItemStack[] itemStacks = new ItemStack[inventory.getStackCount()];
		NBTTagList nbttaglist = nbt.getTagList("Items");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist
					.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < itemStacks.length) {
				itemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
		inventory.setStacks(itemStacks);
	}

	public static ItemStack decrStackSize(ItemStack[] stacks, int i, int j) {
		ItemStack stack = stacks[i];
		if (stack == null)
			return null;

		if (stack.stackSize > j) {
			return stack.splitStack(j);
		} else {
			stacks[i] = null;
			return stack;
		}
	}
}

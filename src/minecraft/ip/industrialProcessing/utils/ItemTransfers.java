package ip.industrialProcessing.utils;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ItemTransfers {
	public static ItemStack transfer(ItemStack stack, IInventory inventory, int slot) {
		if (stack == null)
			return null;

		int maxAmount = Math.min(stack.stackSize, inventory.getInventoryStackLimit());
		stack = stack.copy();

		if (!inventory.isItemValidForSlot(slot, stack))
			return stack;

		ItemStack originalStack = inventory.getStackInSlot(slot);
		if (originalStack == null) {
			ItemStack splitted = stack.splitStack(maxAmount);
			inventory.setInventorySlotContents(slot, splitted);
			if (stack.stackSize <= 0)
				return null;
			return stack;
		}

		if (!originalStack.isItemEqual(stack))
			return stack;

		if (!originalStack.isStackable())
			return stack;

		int increment = inventory.getInventoryStackLimit() - originalStack.stackSize;
		increment = Math.min(increment, stack.stackSize);
		increment = Math.max(increment, 0);

		stack.splitStack(increment);

		originalStack.stackSize += increment;
		return stack;
	}

	public static ItemStack transfer(ItemStack stack, IInventory inventory, ForgeDirection direction) {
		if (inventory instanceof ISidedInventory) {
			return transfer(stack, (ISidedInventory) inventory, direction);
		}
		return transfer(stack, inventory);
	}

	public static ItemStack transfer(ItemStack stack, IInventory inventory) {
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			stack = transfer(stack, inventory, i);
			if (stack == null)
				return null;
			if (stack.stackSize <= 0)
				return null;
		}
		return stack;
	}

	public static ItemStack transfer(ItemStack stack, IInventory inventory, int[] validSlots) {
		for (int i = 0; i < validSlots.length; i++) {
			stack = transfer(stack, inventory, validSlots[i]);
			if (stack == null)
				return null;
			if (stack.stackSize <= 0)
				return null;
		}
		return stack;
	}

	public static ItemStack transfer(ItemStack stack, ISidedInventory inventory, ForgeDirection side) {
		int[] slots = inventory.getAccessibleSlotsFromSide(side.ordinal());
		return transfer(stack, inventory, slots);
	}

	public static EntityItem launch(ItemStack stack, World world, float x, float y, float z, float dx, float dy, float dz) {
		EntityItem entityItem = new EntityItem(world, x + dx, y + dy, z + dz, stack.copy());

		if (stack.hasTagCompound()) {
			entityItem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
		}

		entityItem.motionX = dx;
		entityItem.motionY = dy;
		entityItem.motionZ = dz;
		world.spawnEntityInWorld(entityItem);
		return entityItem;
	}

	public static boolean canInsert(ItemStack stack, IInventory inventory) {
		if (inventory == null)
			return false;
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			if (canInsert(stack, inventory, i))
				return true;
		}
		return false;
	}

	public static boolean canInsert(ItemStack stack, IInventory inventory, int slot) {
		if (inventory == null)
			return false;
		if (inventory.isItemValidForSlot(slot, stack)) {
			ItemStack inhabitingStack = inventory.getStackInSlot(slot);
			if (inhabitingStack == null)
				return true;
			if (!inhabitingStack.isStackable())
				return false;
			if (inhabitingStack.stackSize >= inventory.getInventoryStackLimit())
				return false;
			if (inhabitingStack.isItemEqual(stack))
				return true;
		}
		return false;
	}
	public static boolean canInsert(ItemStack stack, IInventory inventory, ForgeDirection side) {
		if(inventory instanceof ISidedInventory)
		{
			return canInsert(stack, (ISidedInventory)inventory, side);
		}else
			return canInsert(stack, inventory);
	}

	public static boolean canInsert(ItemStack stack, ISidedInventory inventory, ForgeDirection side) {
		int[] slots = inventory.getAccessibleSlotsFromSide(side.ordinal());
		for (int i = 0; i < slots.length; i++) {
			if (inventory.canInsertItem(slots[i], stack, side.ordinal()))
				if (canInsert(stack, inventory, slots[i]))
					return true;
		}
		return false;
	}

	public static ItemStack consumeContainer(ItemStack stack) {
        if (stack.stackSize == 1) {
                if (stack.getItem().hasContainerItem()) {
                        return stack.getItem().getContainerItemStack(stack);
                } else {
                        return null;
                }
        } else {
                stack.splitStack(1);

                return stack;
        }
    }
    
    public static ItemStack extract(ForgeDirection opposite, IInventory inventory) {
        if(inventory instanceof ISidedInventory)
        {
            return extract(opposite, (ISidedInventory)inventory);
        }
        int[] slots = getSlots(inventory.getSizeInventory());
        return extract(slots, inventory);
    }
    
    private static int[] getSlots(int sizeInventory) {
        int[] slots = new int[sizeInventory];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = i;
        }
        return slots;
    }

    public static ItemStack extract(ForgeDirection direction, ISidedInventory inventory)
    {
        int[] slots = inventory.getAccessibleSlotsFromSide(direction.ordinal());
        return extract(slots, inventory);
    }

    public static ItemStack extract(int[] slots, IInventory inventory) { 
        shuffle(slots);
        for (int i = 0; i < slots.length; i++) {
            ItemStack stack = inventory.decrStackSize(slots[i], 1);
            if(stack != null && stack.stackSize > 0)
                return stack;
        }        
        return null;
    }

    private static void shuffle(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}

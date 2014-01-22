package ip.industrialProcessing.utils.nbt;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class NbtHelper {

    public static void writeInventory(ItemStack[] slots, NBTTagCompound nbt) {
	writeInventory(slots, "Slots", nbt);
    }

    public static void writeInventory(ItemStack[] slots, String key, NBTTagCompound nbt) {

	NBTTagList list = new NBTTagList();
	for (int i = 0; i < slots.length; i++) {
	    if (slots[i] != null) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("Slot", i);
		slots[i].writeToNBT(compound);
		list.appendTag(compound);
	    }
	}
	nbt.setTag(key, list);
    }

    public static void readInventory(ItemStack[] slots, NBTTagCompound nbt) {
	readInventory(slots, "Slots", nbt);
    }

    public static void readInventory(ItemStack[] slots, String key, NBTTagCompound nbt) {
	if (nbt.hasKey(key)) {
	    NBTTagList list = nbt.getTagList(key);
	    for (int i = 0; i < list.tagCount(); i++) {
		NBTTagCompound compound = (NBTTagCompound) list.tagAt(i);
		int index = compound.getInteger("Slot");
		ItemStack stack = ItemStack.loadItemStackFromNBT(compound);
		if (index >= 0 && index < slots.length)
		    slots[index] = stack;
	    }
	}
    }

}

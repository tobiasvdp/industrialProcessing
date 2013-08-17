package ip.industrialProcessing.multiblock.block.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IMultiblockInventory {

    int getSizeInventory(int frameID);

    ItemStack getStackInSlot(int frameID, int slot);

    ItemStack decrStackSize(int frameID, int slot, int amount);

    ItemStack getStackInSlotOnClosing(int frameID, int slot);

    void setInventorySlotContents(int frameID, int slot, ItemStack itemstack);

    String getInvName(int frameID);

    boolean isInvNameLocalized(int frameID);

    int getInventoryStackLimit(int frameID);

    boolean isUseableByPlayer(int frameID, EntityPlayer entityplayer);

    void openChest(int frameID);

    void closeChest(int frameID);

    boolean isItemValidForSlot(int frameID, int slot, ItemStack itemstack);

    int[] getAccessibleSlotsFromSide(int frameID, int side);

    boolean canInsertItem(int frameID, int slot, ItemStack itemstack, int side);

    boolean canExtractItem(int frameID, int slot, ItemStack itemstack, int side);

}

package mod.industrialProcessing.blockContainer.multiblock.utils.inventory;

import net.minecraft.item.ItemStack;

public interface IMultiblockInventories {
	 /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    int[] getAccessibleSlotsFromSide(int multiblockID,int var1);

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    boolean canInsertItem(int multiblockID,int i, ItemStack itemstack, int j);

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    boolean canExtractItem(int multiblockID,int i, ItemStack itemstack, int j);
    
    MultiblockItemStack getMultiblockStack(int i);
}

package ip.industrialProcessing.multiblock.block.inventory;

import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TileEntityMultiblockInvInput extends TileEntityMultiblockBlockInv {

	public TileEntityMultiblockInvInput() {
		super();
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		if (hasCore)
			return getCore().canInsertItemForID(i, itemstack, inventoryID);
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return false;
	}

}

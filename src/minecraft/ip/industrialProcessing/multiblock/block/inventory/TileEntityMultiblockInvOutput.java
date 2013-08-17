package ip.industrialProcessing.multiblock.block.inventory;

import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TileEntityMultiblockInvOutput extends TileEntityMultiblockBlockInv {

	public TileEntityMultiblockInvOutput() {
		super();
	}
	@Override
	public int firstValidID(){
		return getCore().firstValidID(false);
	}
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		if (hasCore)
			return getCore().canExtractItemForSlot(i, itemstack);
		return false;
	}
}

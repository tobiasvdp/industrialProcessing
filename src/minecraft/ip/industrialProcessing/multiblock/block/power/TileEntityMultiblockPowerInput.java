package ip.industrialProcessing.multiblock.block.power;

import net.minecraft.item.ItemStack;
import ip.industrialProcessing.multiblock.extended.inventory.worker.power.TileEntityMultiblockBlockInvPowered;

public class TileEntityMultiblockPowerInput extends TileEntityMultiblockBlockInvPowered{

	public TileEntityMultiblockPowerInput() {
		super();
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return false;
	}

}

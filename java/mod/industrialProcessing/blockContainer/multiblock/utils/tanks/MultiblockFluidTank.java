package ip.industrialProcessing.multiblock.utils.tanks;

import ip.industrialProcessing.api.tanks.IPfluidTank;
import net.minecraft.tileentity.TileEntity;

public class MultiblockFluidTank extends IPfluidTank implements IMultiblockFluidTank{
    int multiblockID;
    public MultiblockFluidTank(TileEntity tile, int capacity, int slot, int[] sides, boolean input, boolean output, int multiblockID) {
	super(tile, capacity, slot, sides, input, output);
	this.multiblockID = multiblockID;
    }
    @Override
    public void setMultiblockID(int id) {
	this.multiblockID = id;
    }
    @Override
    public int getMultiblockID() {
	return this.multiblockID;
    }

}

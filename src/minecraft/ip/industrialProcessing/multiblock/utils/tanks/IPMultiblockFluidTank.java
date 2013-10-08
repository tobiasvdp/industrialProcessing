package ip.industrialProcessing.multiblock.utils.tanks;

import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.api.tanks.IPfluidTank;

public class IPMultiblockFluidTank extends IPfluidTank implements IIPMultiblockFluidTank{
    int multiblockID;
    public IPMultiblockFluidTank(TileEntity tile, int capacity, int slot, int[] sides, boolean input, boolean output, int multiblockID) {
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

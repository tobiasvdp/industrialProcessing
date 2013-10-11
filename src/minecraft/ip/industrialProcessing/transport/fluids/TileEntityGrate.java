package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.fluids.BlockFluid;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import net.minecraft.block.Block;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityGrate extends TileEntityFluidMachine {

    private float pressure = 0;

    public TileEntityGrate() {
	addTank(1 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.UP, true, true);
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return true;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public void updateEntity() {
	this.pressure /= 2;
	if (this.pressure > 0)
	    dumpToWorld();
	else
	    suckFromWorld();
    }

    private void suckFromWorld() {
    }

    private void dumpToWorld() {
	dumpAdjacent(xCoord, yCoord, zCoord);
    }

    private boolean dumpAdjacent(int xCoord, int yCoord, int zCoord) {
	if (!(dumpAt(xCoord + 1, yCoord, zCoord) || dumpAt(xCoord - 1, yCoord, zCoord) || dumpAt(xCoord, yCoord, zCoord + 1) || dumpAt(xCoord, yCoord, zCoord - 1) || dumpAt(xCoord, yCoord - 1, zCoord))) {
	    // could not dump below;
	    return false;
	} else
	    return true;
    }

    private boolean dumpAt(int x, int y, int z) {

	int fluidBlockId = this.getTankInfoForSlot(0).fluid.getFluid().getBlockID();
	int id = this.worldObj.getBlockId(x, y, z);
	if (id == 0) {
	    this.worldObj.setBlock(x, y, z, fluidBlockId);
	    return true;
	} else {
	    Block block = Block.blocksList[id];
	    if (block instanceof BlockFluid) {
		return dumpAdjacent(x, y, z);
	    }
	}
	return false;
    }

    @Override
    public void addPressure(ForgeDirection from, float pressure) {
	this.pressure += pressure;
    }

    @Override
    public float getPressure(ForgeDirection from) {
	return pressure;
    }

}

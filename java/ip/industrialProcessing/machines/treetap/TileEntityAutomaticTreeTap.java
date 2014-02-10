package ip.industrialProcessing.machines.treetap;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.machines.TileEntityFluidMachine;

public class TileEntityAutomaticTreeTap extends TileEntityFluidMachine {

    private static final int MAX_COUNTER = 10;
    int counter = 0;
    int totalProgress = 0;

    public TileEntityAutomaticTreeTap() {
	addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.DOWN, false, true);
	LocalDirection[] nodirections = new LocalDirection[0];
	addStack(null, nodirections, true, false);
	addStack(null, nodirections, false, true);
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return false;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	
	ForgeDirection direction = this.getForwardDirection();
        int id = worldObj.getBlockId(xCoord - direction.offsetX, yCoord - direction.offsetY, zCoord - direction.offsetZ);
 
	counter++;
	if (counter == MAX_COUNTER) {
	    counter = 0;
	    IFluidTank tank = this.getTankInSlot(0);
	    if(id == ISetupBlocks.blockRubberLog.blockID)
		tank.fill(new FluidStack(ISetupFluids.itemFluidLatex, 1), true);
	    else if(id == ISetupBlocks.blockPineLog.blockID)
		tank.fill(new FluidStack(ISetupFluids.itemFluidResin, 1), true);
	    totalProgress++;
	    if (totalProgress >= FluidContainerRegistry.BUCKET_VOLUME) {
		totalProgress = 0;
	    }
	}
	getBucketFromTank(2, 3, 2);
    }

    public int getProgress() {
	return totalProgress;
    }

    public int getMaxProgress() {
	return FluidContainerRegistry.BUCKET_VOLUME;
    }

    @Override
    public boolean canWrenchRotate() {
	return false;
    }

    @Override
    public void addPressure(ForgeDirection from, float pressure) {
    }
}

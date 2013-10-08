package ip.industrialProcessing.machines.treetap;

import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidMachine;

public class TileEntityAutomaticTreeTap extends TileEntityFluidMachine {

    private static final int MAX_COUNTER = 10;
    int counter = 0;
    int totalProgress = 0;

    public TileEntityAutomaticTreeTap() {
        addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.DOWN, false, true);
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

        counter++;
        if (counter == MAX_COUNTER) {
            counter = 0;
            IFluidTank tank = this.getTankInSlot(0);
            tank.fill(new FluidStack(FluidRegistry.WATER, 1), true);
            totalProgress++;
            if (totalProgress >= FluidContainerRegistry.BUCKET_VOLUME) {
                totalProgress = 0;
            }
        }
    }

    public int getProgress() {
        return totalProgress;
    }

    public int getMaxProgress() {
        return FluidContainerRegistry.BUCKET_VOLUME;
    }
}

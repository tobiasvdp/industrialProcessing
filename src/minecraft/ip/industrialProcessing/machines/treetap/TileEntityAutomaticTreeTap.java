package ip.industrialProcessing.machines.treetap;

import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidMachine;

public class TileEntityAutomaticTreeTap extends TileEntityFluidMachine {

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
        
        IFluidTank tank = this.getTankInSlot(0);
        
        tank.fill(new FluidStack(FluidRegistry.LAVA, 1), true);
    }
}

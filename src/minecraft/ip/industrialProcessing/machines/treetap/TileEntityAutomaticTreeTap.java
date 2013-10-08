package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.machines.TileEntityFluidMachine;

public class TileEntityAutomaticTreeTap extends TileEntityFluidMachine {

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        // TODO Auto-generated method stub
        return false;
    }

}

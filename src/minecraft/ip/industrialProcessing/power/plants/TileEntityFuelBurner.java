package ip.industrialProcessing.power.plants;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;

public class TileEntityFuelBurner extends TileEntityFluidMachine {

    public TileEntityFuelBurner() {
        addTank(0, LocalDirection.LEFT, true, false);
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
        return false;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        return false;
    }

}

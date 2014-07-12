package mod.industrialProcessing.fluids;

import net.minecraftforge.fluids.FluidTankInfo;

public interface IFluidInfo {

    FluidTankInfo[] getTanks();
    FluidTankInfo getTankInfoForSlot(int slot);

}

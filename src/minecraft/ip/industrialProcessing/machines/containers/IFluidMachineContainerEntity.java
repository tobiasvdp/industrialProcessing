package ip.industrialProcessing.machines.containers;

import net.minecraftforge.fluids.FluidTankInfo;

public interface IFluidMachineContainerEntity {

    FluidTankInfo getTankInfoForSlot(int slot);

}

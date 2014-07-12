package mod.industrialProcessing.blockContainer.multiblock.utils.tanks;

import net.minecraftforge.fluids.FluidTankInfo;

public interface IMultiblockFluidInfo {
    FluidTankInfo[] getTanks();
    FluidTankInfo getTankInfoForSlot(int slot);
}

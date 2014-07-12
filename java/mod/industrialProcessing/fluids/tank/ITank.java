package mod.industrialProcessing.fluids.tank;

import mod.industrialProcessing.fluids.IFluidInfo;
import net.minecraftforge.fluids.IFluidHandler;

public interface ITank extends IPressuredTank, IFluidHandler, IFluidInfo, IMachineTanks {
	IPfluidTank getTank(int index);
}

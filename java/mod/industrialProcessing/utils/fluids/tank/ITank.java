package mod.industrialProcessing.utils.fluids.tank;

import mod.industrialProcessing.utils.fluids.IFluidInfo;
import net.minecraftforge.fluids.IFluidHandler;

public interface ITank extends IPressuredTank, IFluidHandler, IFluidInfo {
	IPfluidTank getTank(int index);
}

package ip.industrialProcessing.utils;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public class FluidTransfers {
    public static int transfer(int maxAmount, IFluidHandler fromHandler, ForgeDirection fromSide, IFluidHandler toHandler, ForgeDirection toSide) {
	FluidStack availableStack = fromHandler.drain(fromSide, maxAmount, false);
	int maxFill = toHandler.fill(toSide, availableStack, false);
	FluidStack drainedStack = fromHandler.drain(fromSide, maxFill, true);
	return toHandler.fill(toSide, drainedStack, true);
    }

    public static int transfer(int maxAmount, IFluidHandler fromHandler, ForgeDirection fromSide, IFluidTank toTank) {
	FluidStack availableStack = fromHandler.drain(fromSide, maxAmount, false);
	int maxFill = toTank.fill(availableStack, false);
	FluidStack drainedStack = fromHandler.drain(fromSide, maxFill, true);
	return toTank.fill(drainedStack, true);
    }

    public static int transfer(int maxAmount, IFluidTank fromTank, IFluidHandler toHandler, ForgeDirection toSide) {
	FluidStack availableStack = fromTank.drain(maxAmount, false);
	int maxFill = toHandler.fill(toSide, availableStack, false);
	FluidStack drainedStack = fromTank.drain(maxFill, true);
	return toHandler.fill(toSide, drainedStack, true);
    }

    public static int transfer(int maxAmount, IFluidTank fromTank, IFluidTank toTank) {
	FluidStack availableStack = fromTank.drain(maxAmount, false);
	int maxFill = toTank.fill(availableStack, false);
	FluidStack drainedStack = fromTank.drain(maxFill, true);
	return toTank.fill(drainedStack, true);
    }
}

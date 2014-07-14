package mod.industrialProcessing.fluids.tank;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public interface IMachineTanks {

	boolean tankContains(int slot, Fluid fluid, int amount);

	FluidStack getFluidStackInSlot(int slot);
	
	boolean tankHasRoomFor(int slot, FluidStack stack);
	boolean tankHasRoomFor(int slot, Fluid fluid, int amount);
	
	boolean addToTank(int index, Fluid fluid, int amount);

	boolean removeFromTank(int index, Fluid fluid, int amount);
}

package mod.industrialProcessing.blockContainer.multiblock.utils.tanks;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public interface IMultiblockMachineTank {
	boolean tankContains(int mulID, int slot, Fluid fluid, int amount);

	boolean tankHasRoomFor(int mulID, int slot, FluidStack stack);
	boolean tankHasRoomFor(int mulID, int slot, Fluid fluid, int amount);
	
	boolean addToTank(int mulID, int index, Fluid fluid, int amount);

	boolean removeFromTank(int mulID, int index, Fluid fluid, int amount);
}

package ip.industrialProcessing.machines;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class MachineFluidTank {
	public MachineFluidTank(FluidTank tank, int[] sides, boolean input,
			boolean output) {
		this.tank = tank;
		this.sides = sides;
		this.input = input;
		this.output = output; 
	}
	public FluidTank tank;
	public int[] sides;
	public boolean input;
	public boolean output;
}

package ip.industrialProcessing.machines;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class MachineFluidTank extends FluidTank{
	public MachineFluidTank(TileEntity tile, int capacity, int[] sides, boolean input,
			boolean output) {
		super(capacity);
		this.tile = tile;
		this.sides = sides;
		this.input = input;
		this.output = output; 
	} 
	public int[] sides;
	public boolean input;
	public boolean output;
}

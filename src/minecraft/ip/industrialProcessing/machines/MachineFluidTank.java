package ip.industrialProcessing.machines;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class MachineFluidTank extends FluidTank {
	public MachineFluidTank(TileEntity tile, int capacity, int[] sides,
			boolean input, boolean output) {
		super(capacity);
		this.tile = tile;
		this.sides = sides;
		this.input = input;
		this.output = output;
	}

	public int[] sides;
	public boolean input;
	public boolean output;

	@Override
	public FluidTank readFromNBT(NBTTagCompound nbt) {
		if (!nbt.hasKey("Empty")) {
			FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt);

			if (fluid != null) {
				setFluid(fluid);
			}
		} else {
			setFluid(null);
		}
		return this;
	}
}

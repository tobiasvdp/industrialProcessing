package ip.industrialProcessing.multiblock.utils.tank;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class MultiblockTank extends FluidTank{
	public MultiblockTank(TileEntity tile, int capacity,
			boolean input, boolean output) {
		super(capacity);
		this.tile = tile;
		this.input = input;
		this.output = output;
	}

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

	public boolean getIsInput() {
		return input;
	}
}

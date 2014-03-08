package mod.industrialProcessing.fluids.tank;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class IPfluidTank extends FluidTank implements IIPfluidTank {
    public IPfluidTank(TileEntity tile, int capacity, int slot, int[] sides, boolean input, boolean output) {
	super(capacity);
	this.slot = slot;
	this.tile = tile;
	this.sides = sides;
	this.input = input;
	this.output = output;
    }

    public int[] sides;
    public boolean input;
    public boolean output;
    public int slot;

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

    @Override
    public void setTankCapacity(int capacity) {
	this.capacity = capacity;
    }

    @Override
    public void setFluidAmount(int amount) {
	if (this.fluid != null)
	    this.fluid.amount = amount;
    }

    @Override
    public void setFluidID(int fluidID) {
	if (this.fluid != null)
	    this.fluid.fluidID = fluidID;
	else
	    this.fluid = new FluidStack(fluidID, 0);
    }

    @Override
    public int getTankCapacity() {
	return capacity;
    }

    @Override
    public int getFluidID() {
	if (this.fluid != null)
	    return fluid.fluidID;
	return 0;
    }

    @Override
    public boolean isConnectedToSide(ForgeDirection side) {
	for(int i =0;i<sides.length;i++){
	    if(sides[i] == side.ordinal())
		return true;
	}
	return false;
    }
}

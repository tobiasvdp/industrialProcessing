package mod.industrialProcessing.gui.containers.handlers;

import mod.industrialProcessing.fluids.IFluidInfo;
import mod.industrialProcessing.gui.binding.ITankBinding;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public class TankHandler extends BindingHandlerBase<ITankBinding> {

    private static final int INDEX_CAPACITY = 0;
    private static final int INDEX_AMOUNT = 1;
    private static final int INDEX_FLUIDID = 2;
    private IFluidInfo entity;
    private int tankSlot;

    public TankHandler(int tankSlot, IFluidInfo entity) {
	super(3);
	this.entity = entity;
	this.tankSlot = tankSlot;
    }

    @Override
    public void readFromEntity() {
	FluidTankInfo tankInfo = this.entity.getTankInfoForSlot(this.tankSlot);
	FluidStack fluidStack = tankInfo.fluid;
	int capacity = tankInfo.capacity;
	int fluidAmount = fluidStack == null ? 0 : fluidStack.amount;
	int fluidID = fluidStack == null ? -1 : fluidStack.fluidID;

	this.setValue(INDEX_CAPACITY, capacity);
	this.setValue(INDEX_AMOUNT, fluidAmount);
	this.setValue(INDEX_FLUIDID, fluidID);
    }

    @Override
	public void updateBinding(ITankBinding binding) {
	binding.setCapacity(this.getValue(INDEX_CAPACITY));
	binding.setFluidAmount(this.getValue(INDEX_AMOUNT));
	binding.setFluidID(this.getValue(INDEX_FLUIDID));
    }
}

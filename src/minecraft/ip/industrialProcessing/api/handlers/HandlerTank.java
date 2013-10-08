package ip.industrialProcessing.api.handlers;

import ip.industrialProcessing.api.tanks.ITank;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressInfoTank;
import net.minecraftforge.fluids.FluidTankInfo;

public class HandlerTank implements IHandlerTank {
    private ITank tank;
    private int slot;
    private boolean[] hasChanged;
    private int offset;

    public HandlerTank(ITank tank, int slot) {
	this.tank = tank;
	this.slot = slot;
	this.hasChanged = new boolean[getValueCount()];
	for (int i = 0; i < getValueCount(); i++) {
	    hasChanged[i] = false;
	}
    }

    @Override
    public int getValueCount() {
	return 3;
    }

    @Override
    public int getValue(int i) {

	/*FluidTankInfo tank = this.tank.getTankInfoForSlot(this.slot);
	switch (i) {
	case 0:
	    return tank.fluid == null ? 0 : tank.fluid.amount;
	case 1:
	    return tank.capacity;
	case 2:
	    return tank.fluid == null ? -1 : tank.fluid.fluidID;
	}*/
	return 0;
    }

    @Override
    public int[] getValueStorage() {
	/*int[] value = new int[3];
	FluidTankInfo tank = this.tank.getTankInfoForSlot(this.slot);
	value[0] = tank.fluid == null ? 0 : tank.fluid.amount;
	value[1] = tank.capacity;
	value[2] = tank.fluid == null ? -1 : tank.fluid.fluidID;
	return value;*/return null;
    }

    public static InfoTank getInfo(IHandlerTank handler) {
	InfoTank value = new InfoTank();
	int[] store = handler.getValueStorage();
	value.amount = store[0];
	value.capacity = store[1];
	value.fluidId = store[2];
	return value;
    }

    @Override
    public boolean hasChanged(int i) {
	return hasChanged[i];
    }

    @Override
    public int getIndexOffset() {
	return this.offset;
    }

    @Override
    public void setIndexOffset(int offset) {
	this.offset = offset;
    }

    @Override
    public void put(int index, int par2) {
	/*hasChanged[index] = true;
	tank.getTankInfoForSlot(par2);
	switch (index) {
	case 0:
	    this.tank.setTankAmount(par2);
	case 1:
	    this.tank.setTankCapacity(par2);

	case 2:
	    this.tank.setTankFluidID(par2);
	}*/
    }
}

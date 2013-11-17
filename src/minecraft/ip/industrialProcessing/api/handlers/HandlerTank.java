package ip.industrialProcessing.api.handlers;

import ip.industrialProcessing.api.info.InfoTank;
import ip.industrialProcessing.api.tanks.IIPfluidTank;
import ip.industrialProcessing.api.tanks.IPfluidTank;
import ip.industrialProcessing.api.tanks.ITank;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressInfoTank;
import net.minecraftforge.fluids.FluidTankInfo;

public class HandlerTank implements IHandlerTank {
    private IPfluidTank tank;
    private InfoTank prevInfo;
    private int offset;

    public HandlerTank(IPfluidTank tank) {
	this.tank = tank;
	prevInfo = new InfoTank();
    }

    @Override
    public int getValueCount() {
	return 3;
    }

    @Override
    public int getValue(int i) {

	switch (i) {
	case 0:
	    return tank.getFluidAmount();
	case 1:
	    return tank.getTankCapacity();
	case 2:
	    return tank.getFluidID();
	}
	return 0;
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
	switch (index) {
	case 0:
	    this.tank.setFluidAmount(par2);break;
	case 1:
	    this.tank.setTankCapacity(par2);break;

	case 2:
	    this.tank.setFluidID(par2);break;
	}
    }

	@Override
	public int getPrevValue(int i) {
		switch (i) {
		case 0:
		    return prevInfo.amount;
		case 1:
		    return prevInfo.capacity;
		case 2:
		    return prevInfo.fluidId;
		}
		return 0;
	}

	@Override
	public void newToOldValues() {
		prevInfo.amount = tank.getFluidAmount();
		prevInfo.capacity = tank.getTankCapacity();
		prevInfo.fluidId = tank.getFluidID();
	}

	public static InfoTank getInfo(IHandlerTank handler) {
		InfoTank tankInfo = new InfoTank();
		tankInfo.amount = handler.getValue(0);
		tankInfo.capacity = handler.getValue(1);
		tankInfo.fluidId = handler.getValue(2);
		return tankInfo;
	}

	@Override
	public void resetPrevValue() {
		prevInfo = new InfoTank();
	}
}

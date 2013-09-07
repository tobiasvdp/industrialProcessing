package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.TileEntityFluidMachine;
import net.minecraftforge.fluids.FluidTankInfo;

public class ProgressBarTankHandler implements IProgressBarHandler {

	private TileEntityFluidMachine machine;
	private int slot;

	public ProgressBarTankHandler(TileEntityFluidMachine machine, int slot) {
		this.machine = machine;
		this.slot = slot;
	}

	@Override
	public int getValueCount() {
		return 3;
	}

	@Override
	public int getValue(int i) {

		FluidTankInfo tank = this.machine.getTankInfoForSlot(this.slot);
		switch (i) {
		case 0:
			return tank.fluid == null ? 0 : tank.fluid.amount;
		case 1:
			return tank.capacity;
		case 2:
			return tank.fluid == null ? -1 : tank.fluid.fluidID;
		}
		return 0;
	}

	public static ProgressInfoTank getInfo(ProgressBarHandlerInfo handler) {
		ProgressInfoTank value = new ProgressInfoTank();
		int[] store = handler.getValueStorage();
		value.amount = store[0];
		value.capacity = store[1];
		value.fluidId = store[2];
		return value;
	}
}

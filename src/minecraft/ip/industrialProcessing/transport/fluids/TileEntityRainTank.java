package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.machines.TileEntityFluidMachine;

public class TileEntityRainTank extends TileEntityFluidMachine {

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		// TODO Auto-generated method stub
		return false;
	}

}

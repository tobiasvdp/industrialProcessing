package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.machines.TileEntityMachine;

public class TileEntityTurbine extends TileEntityMachine {

	
	
	@Override
	protected boolean isValidInput(int slot, int itemID) { 
		return false;
	}

}

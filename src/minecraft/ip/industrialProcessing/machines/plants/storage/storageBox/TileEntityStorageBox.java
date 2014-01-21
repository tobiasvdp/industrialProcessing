package ip.industrialProcessing.machines.plants.storage.storageBox;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;

public class TileEntityStorageBox extends TileEntityMachine{

	public TileEntityStorageBox() {
		LocalDirection[] nodirections = new LocalDirection[0];
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, true, false);
		addStack(null, nodirections, true, false);

	}
	
	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return true;
	}

}

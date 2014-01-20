package ip.industrialProcessing.machines.plants.storage.storageBox;

import ip.industrialProcessing.machines.TileEntityMachine;

public class TileEntityStorageBox extends TileEntityMachine{

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return true;
	}

}

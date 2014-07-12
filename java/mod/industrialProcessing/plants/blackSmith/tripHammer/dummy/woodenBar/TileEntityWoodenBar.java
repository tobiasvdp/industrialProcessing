package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenBar;

import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.plants.blackSmith.tripHammer.TileEntityTripHammer;

public class TileEntityWoodenBar extends TileEntityMultiblockDummy {

	public float getRotation() {
		if (getCore() != null)
			return ((TileEntityTripHammer) getCore()).getRotation();
		return 0;
	}
}

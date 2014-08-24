package mod.industrialProcessing.plants.middleAge.tripHammer.dummy.woodenBar;

import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.plants.middleAge.tripHammer.TileEntityTripHammer;

public class TileEntityWoodenBar extends TileEntityMultiblockDummy {

	public float getRotation() {
		if (getCore() != null)
			return ((TileEntityTripHammer) getCore()).getRotation();
		return 0;
	}
}

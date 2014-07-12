package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenHammer;

import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.dummy.extend.TileEntityMultiblockDummyInv;
import mod.industrialProcessing.plants.blackSmith.tripHammer.TileEntityTripHammer;

public class TileEntityWoodenHammer extends TileEntityMultiblockDummyInv {


	public float getRotation() {
		if (getCore() != null)
			return ((TileEntityTripHammer) getCore()).getRotation();
		return 0;
	}
}

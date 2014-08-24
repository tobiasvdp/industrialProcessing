package mod.industrialProcessing.plants.middleAge.tripHammer.dummy.woodenHammer;

import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.dummy.extend.TileEntityMultiblockDummyInv;
import mod.industrialProcessing.plants.middleAge.tripHammer.TileEntityTripHammer;

public class TileEntityWoodenHammer extends TileEntityMultiblockDummyInv {


	public float getRotation() {
		if (getCore() != null)
			return ((TileEntityTripHammer) getCore()).getRotation();
		return 0;
	}
}

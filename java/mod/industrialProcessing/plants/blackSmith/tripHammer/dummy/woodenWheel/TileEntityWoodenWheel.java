package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenWheel;

import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;

public class TileEntityWoodenWheel extends TileEntityMultiblockDummy {
	int rotation = 0;

	@Override
	public void updateEntity() {
		rotation++;
		rotation++;
		if(rotation >= 360){
			rotation = 0;
		}
		super.updateEntity();
	}

	public float getRotation() {
		return rotation;
	}

}

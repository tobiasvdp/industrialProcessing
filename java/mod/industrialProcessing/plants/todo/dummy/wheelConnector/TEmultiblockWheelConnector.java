package mod.industrialProcessing.plants.todo.dummy.wheelConnector;

import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TEmultiblockWheelConnector extends TileEntityMultiblockDummy implements IAnimationProgress {

	public TEmultiblockWheelConnector() {
		super();
	}

	@Override
	public int getAnimationCount() {
		return 1;
	}

	@Override
	public float getAnimationProgress(float scale, int animationIndex) {
		if(this.getState() == MultiblockState.COMPLETED)
			return getCore().getAnimationProgress(scale, animationIndex);
		return 0;
	}

}

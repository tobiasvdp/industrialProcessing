package ip.industrialProcessing.multiblock.dummy.block.wheelConnector;

import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TEmultiblockWheelConnector extends TEmultiblockDummy implements IAnimationProgress {

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

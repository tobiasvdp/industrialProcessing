package ip.industrialProcessing.multiblock.dummy.block.wheel;

import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TEmultiblockWheel extends TileEntityMultiblockDummy implements IAnimationProgress{
	
	public TEmultiblockWheel() {

	}

	@Override
	public void updateEntity(){
		if(this.getState() == MultiblockState.COMPLETED && getCore().isAnimationEnabled(0)){
			getCore().updateAnimationProgress(0);
		}
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
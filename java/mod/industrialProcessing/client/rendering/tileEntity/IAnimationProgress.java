package mod.industrialProcessing.client.rendering.tileEntity;

public interface IAnimationProgress {
	int getAnimationCount();
    float getAnimationProgress(float scale, int animationIndex);
}

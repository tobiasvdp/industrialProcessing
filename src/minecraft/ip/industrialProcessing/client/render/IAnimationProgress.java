package ip.industrialProcessing.client.render;

public interface IAnimationProgress {
	int getAnimationCount();
    float getAnimationProgress(float scale, int animationIndex);
}

package ip.industrialProcessing.machines;

import ip.industrialProcessing.client.render.IAnimationProgress;

public class AnimationHandler implements IAnimationProgress {
    private static final float DT = 1 / 20f;
    private float speed = 0f;
    private float scale = 1f;
    private AnimationMode mode;
    private float progress;
    private boolean incrementing;

    public void setSpeed(float speed) {
	this.speed = Math.max(0, Math.min(speed, scale / DT));
    }

    public void setScale(float scale) {
	this.scale = Math.max(0, scale);
	this.setSpeed(this.speed);
    }

    public float getScale() {
	return scale;
    }

    public float getSpeed() {
	return speed;
    }

    @Override
    public float getAnimationProgress(float scale) {
	return this.progress * scale;
    }

    public void setAnimationProgress(float progress, float scale) {
	this.progress = progress / scale;
    }

    public void setProgress(float progress) {
	this.progress = progress;
    }

    public float getProgress() {
	return progress;
    }

    public void update() {
	if (speed != 0) {
	    progress += speed * DT;
	    if (incrementing) {
		if (progress > scale) {
		    switch (mode) {
		    case CLAMP:
			progress = scale;
			break;
		    case MIRROR:
			incrementing = !incrementing;
			progress = 2 * scale - progress;
			break;
		    case WRAP:
			progress -= scale;
			break;
		    }
		}
	    } else if (progress < 0) {
		switch (mode) {
		case CLAMP:
		    progress = 0;
		    break;
		case MIRROR:
		    incrementing = !incrementing;
		    progress = 0 - progress;
		    break;
		case WRAP:
		    progress += scale;
		    break;
		}
	    }
	}
    }
}

package ip.industrialProcessing.machines.animation;

import ip.industrialProcessing.client.render.IAnimationProgress;

public class AnimationHandler {
	public static final float DT = 1 / 20f;
	private float speed = 0f;
	private float scale = 1f;
	private final AnimationMode mode;
	private float progress;
	private boolean incrementing;

	public AnimationHandler(AnimationMode mode, float scale, boolean incrementing) {
		this.mode = mode;
		this.scale = scale;
		this.incrementing = incrementing;
	}

	public float getScale() {
		return scale;
	}

	public AnimationMode getMode() {
		return mode;
	}

	public void setSpeed(float speed) {
		this.speed = Math.max(0, Math.min(speed, scale / DT));
	}

	public float getSpeed() {
		return speed;
	}
 
	public float getAnimationProgress(float scale) {
		return this.progress * scale / this.scale;
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

			if (incrementing) {
				progress += speed * DT;
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
			} else {
				progress -= speed * DT;
				if (progress < 0) {
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

	public void setIncrementing(boolean incrementing) {
		this.incrementing = incrementing;
	}

	public boolean isIncrementing() {
		return incrementing;
	}
}

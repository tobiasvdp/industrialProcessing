package ip.industrialProcessing.machines.animation;

import net.minecraft.nbt.NBTTagCompound;
import ip.industrialProcessing.client.render.IAnimationProgress;

public class AnimationHandler {
    public static final float DT = 1 / 20f;
    private float speed = 0f;
    private float scale = 1f;
    private final AnimationMode mode;
    private float progress;
    private boolean incrementing;

    private float lastSpeed = 0;
    private float lastProgress = 0;
    private boolean lastIncrementing = false;

    public boolean isChanged() {
        return lastSpeed != speed || lastProgress != progress || lastIncrementing != incrementing;
    }

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
        lastSpeed = speed;
        lastIncrementing = incrementing;
        lastProgress = progress;
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

    public void moveToProgress(float targetProgress, float time) {

        float speed = (targetProgress - this.progress) * DT / time;

        boolean incrementing = speed > 0;
        if (!incrementing)
            speed = -speed;
        setSpeed(speed);
        setIncrementing(incrementing);
    }

    public void addSpeed(float f) {
        this.setSpeed(this.getSpeed() + f);

    }

    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
        this.speed = par1nbtTagCompound.getFloat("AnimationSpeed");
        this.progress = par1nbtTagCompound.getFloat("AnimationProgress");
        this.incrementing = par1nbtTagCompound.getBoolean("AnimationIncrementing");
    }

    public void writeToNBT(NBTTagCompound par1nbtTagCompound) {

        par1nbtTagCompound.setFloat("AnimationSpeed", this.speed);
        par1nbtTagCompound.setFloat("AnimationProgress", this.progress);
        par1nbtTagCompound.setBoolean("AnimationIncrementing", this.incrementing);
    }
}

package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import net.minecraft.util.Icon;

public class ScrollIcon implements Icon {

    private float progress;

    public ScrollIcon(float progress) {
	this.progress = progress;
    }

    @Override
    public float getMinU() { 
	return 0.0f;
    }

    @Override
    public float getMaxU() { 
	return 1.0f;
    }

    @Override
    public float getInterpolatedU(double d0) {
	return (float) ((getMaxU() - getMinU()) * d0) + getMinU();
    }

    @Override
    public float getMinV() {
	return this.progress;
    }

    @Override
    public float getMaxV() {
	return 1 + this.progress;
    }

    @Override
    public float getInterpolatedV(double d0) {
	return (float) ((getMaxV() - getMinV()) * d0) + getMinU();
    }

    @Override
    public String getIconName() {
	return "scroll" + this.progress;
    }

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}

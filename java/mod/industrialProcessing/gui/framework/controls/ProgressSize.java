package mod.industrialProcessing.gui.framework.controls;

public class ProgressSize {

	public float marginMin;
	public float marginMax;
	public float uvMin;
	public float uvMax;
	public float progressUV;
	public float progressSize;

	public ProgressSize(float marginLeft, float progressSize, float marginRight, float uMin, float progressUV, float uMax) {
		this.marginMin = marginLeft;
		this.marginMax = marginRight;
		this.progressSize = progressSize;
		this.uvMin = uMin;
		this.uvMax = uMax;
		this.progressUV = progressUV;
	}

	public float getOffset(boolean flip, float width) {
		if (flip) {
			return width - marginMax - marginMin - progressSize;
		}
		return 0;
	}

	public float getUVOffset(boolean flip, float width) {
		if (flip) {
			return width - uvMin - uvMax - progressUV;
		}
		return 0;
	}
}

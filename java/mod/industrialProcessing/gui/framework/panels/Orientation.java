package mod.industrialProcessing.gui.framework.panels;

public enum Orientation {
    HORIZONTAL, VERTICAL;

    public Orientation getOpposite() {
	switch (this) {
	case HORIZONTAL:
	    return VERTICAL;

	default:
	    return HORIZONTAL;
	}
    }
}

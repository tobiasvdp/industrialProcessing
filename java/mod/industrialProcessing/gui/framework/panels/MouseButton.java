package mod.industrialProcessing.gui.framework.panels;

public enum MouseButton {
    LEFT, MIDDLE, RIGHT;
    public static MouseButton getButton(int index) {
	switch (index) {
	case 0:
	    return LEFT;
	case 1:
	    return RIGHT;
	default:
	    return null;
	}
    }
}

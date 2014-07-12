package mod.industrialProcessing.utils.rotation;


public enum LocalDirection {
	DOWN(0, 1, 0), UP(0, -1, 0), BACK(0, 0, 1), FRONT(0, 0, -1), LEFT(1, 0, 0), RIGHT(-1, 0, 0), UNKNOWN(0, 0, 0);

	public final int offsetX;
	public final int offsetY;
	public final int offsetZ;
	
	public static final LocalDirection[] VALID_DIRECTIONS = {DOWN, UP, BACK, FRONT, LEFT, RIGHT};

	private LocalDirection(int x, int y, int z) {
		offsetX = x;
		offsetY = y;
		offsetZ = z;
	}
}

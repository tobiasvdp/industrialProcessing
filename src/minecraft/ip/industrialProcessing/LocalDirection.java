package ip.industrialProcessing;

import net.minecraftforge.common.ForgeDirection;

public enum LocalDirection {
	FRONT(0, 0, -1), RIGHT(-1, 0, 0), BACK(0, 0, 1), LEFT(1, 0, 0), UP(0, -1, 0), DOWN(0, 1, 0), UNKNOWN(0, 0, 0);

	public final int offsetX;
	public final int offsetY;
	public final int offsetZ;

	private LocalDirection(int x, int y, int z) {
		offsetX = x;
		offsetY = y;
		offsetZ = z;
	}
}

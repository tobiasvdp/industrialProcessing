package mod.industrialProcessing.utils.rotation;

import java.util.Arrays;

import net.minecraftforge.common.util.ForgeDirection;

public class DirectionUtils {

    private static ForgeDirection[] directions = new ForgeDirection[] { ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH, ForgeDirection.WEST };

    private static LocalDirection[] localDirections = new LocalDirection[] { LocalDirection.FRONT, LocalDirection.RIGHT, LocalDirection.BACK, LocalDirection.LEFT };

    public static ForgeDirection getWorldDirection(LocalDirection direction, ForgeDirection forward) {
        if (forward == ForgeDirection.UP || forward == ForgeDirection.DOWN)
            return null;

        if (direction == LocalDirection.UP)
            return ForgeDirection.UP;
        if (direction == LocalDirection.DOWN)
            return ForgeDirection.DOWN;

        int rotationAmount = getRotationIndex(forward);
        int directionAmount = getRotationIndex(direction);

        directionAmount += rotationAmount;
        directionAmount = directionAmount % 4;
        return directions[directionAmount];
    }

    private static int getRotationIndex(LocalDirection direction) {
        return Arrays.asList(localDirections).indexOf(direction);
    }

    private static int getRotationIndex(ForgeDirection forward) {
        return Arrays.asList(directions).indexOf(forward);
    }

    public static int getRotationYAngle(ForgeDirection forward) {
        return getRotationIndex(forward) * 90;
    }
    
    protected static int[][] rotationMatrix = new int[][] { { 0 }, { 0 }, { 0, 1, 3, 2, 5, 4 }, { 0, 1, 2, 3, 4, 5 }, { 0, 1, 4, 5, 3, 2 }, { 0, 1, 5, 4, 2, 3 } };

	public static LocalDirection getLocalDirection(ForgeDirection dir,ForgeDirection forward) {
		if (forward != null)
			return LocalDirection.VALID_DIRECTIONS[rotationMatrix[forward.ordinal()][dir.ordinal()]];
		return LocalDirection.FRONT;
	}


    public static LocalDirection getLocalDirection(int directionOrdinal, ForgeDirection forwardDirection) {
        ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[directionOrdinal];
        return getLocalDirection(direction, forwardDirection);
    }
}

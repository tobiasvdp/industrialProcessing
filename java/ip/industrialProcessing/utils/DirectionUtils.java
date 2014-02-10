package ip.industrialProcessing.utils;

import ip.industrialProcessing.LocalDirection;

import java.util.Arrays;

import net.minecraftforge.common.ForgeDirection;

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

    public static LocalDirection getLocalDirection(ForgeDirection direction, ForgeDirection forward) {
        if (direction == ForgeDirection.DOWN)
            return LocalDirection.DOWN;
        if (direction == ForgeDirection.UP)
            return LocalDirection.UP;
        int rotationAmount = getRotationIndex(forward);
        int directionAmount = getRotationIndex(direction);

        directionAmount -= rotationAmount;
        directionAmount = directionAmount % 4;
        if (directionAmount < 0) {
            directionAmount += 4;
        }
        return localDirections[directionAmount];
    }

    public static LocalDirection getLocalDirection(int directionOrdinal, ForgeDirection forwardDirection) {
        ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[directionOrdinal];
        return getLocalDirection(direction, forwardDirection);
    }
}

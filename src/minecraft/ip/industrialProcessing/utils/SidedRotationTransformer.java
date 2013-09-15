package ip.industrialProcessing.utils;

import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ForgeDirection;

public class SidedRotationTransformer {
	private static final int[][] ROTATION_MATRIX_Side = { { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 1, 0, 2, 3, 5, 4, 6 }, { 5, 4, 2, 3, 3, 2, 6 }, { 4, 5, 2, 3, 2, 3, 6 }, { 0, 1, 2, 3, 4, 5, 6 }};
	private static final int[][] ROTATION_MATRIX_Rotation = { { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 5, 4, 6 }, { 0, 1, 2, 3, 3, 2, 6 }, { 0, 1, 2, 3, 2, 3, 6 }, { 0, 1, 2, 3, 4, 5, 6 }};

	public static ForgeDirection transformMetaToForgeDirection(int meta) {
		switch (meta) {
		case 0:
			return ForgeDirection.UP;
		case 1:
			return ForgeDirection.DOWN;
		case 2:
			return ForgeDirection.SOUTH;
		case 3:
			return ForgeDirection.NORTH;
		case 4:
			return ForgeDirection.EAST;
		case 5:
			return ForgeDirection.WEST;
		default:
			return ForgeDirection.UNKNOWN;
		}
	}

	public static ForgeDirection InternalToExternalDirection(ISidedRotation rot, ForgeDirection dir) {
		System.out.println(getRotatedForgeDirection(rot.getOrientationSide(), dir));
		ForgeDirection forgeSides = ForgeDirection.getOrientation(ROTATION_MATRIX_Side[rot.getOrientationSide().ordinal()][dir.ordinal()]);
		return forgeSides.UNKNOWN;
	}

	public static ForgeDirection transformSideAndLookToForgeDirection(ForgeDirection side, float rotationYaw, float rotationPitch) {
		switch (side) {
		case UP:
		case DOWN:
			int dir = MathHelper.floor_double((double) ((rotationYaw * 4F) / 360F) + 0.5D) & 3;
			return getFacingDirectionHorizontal(dir);
		case NORTH:
		case SOUTH:
		case EAST:
		case WEST:
			return getFacingDirectionVertical(rotationPitch, rotationYaw, side);
		default:
			return ForgeDirection.UNKNOWN;
		}
	}

	private static ForgeDirection getFacingDirectionVertical(float rotationPitch, float rotationYaw, ForgeDirection side) {
		float degree = getAbsDegree(rotationYaw, side);
		if (Math.abs(degree) >= Math.abs(rotationPitch)) {
			if (degree > 0.0) {
				return getRotatedForgeDirection(side, ForgeDirection.EAST);
			} else {
				return getRotatedForgeDirection(side, ForgeDirection.WEST);
			}
		} else {
			if (rotationPitch > 0.0)
				return ForgeDirection.DOWN;
			else
				return ForgeDirection.UP;
		}

	}

	private static float getAbsDegree(float rotationYaw, ForgeDirection side) {
		if (side == ForgeDirection.SOUTH) {
			if (rotationYaw < 90)
				rotationYaw = rotationYaw + 360;
		} else {
			if (rotationYaw < 0)
				rotationYaw = rotationYaw + 360;
		}
		switch (side) {
		case NORTH:
			return rotationYaw - 180;
		case EAST:
			return rotationYaw - 270;
		case WEST:
			return rotationYaw - 90;
		case SOUTH:
			return rotationYaw - 360;
		}
		return rotationYaw;
	}

	private static ForgeDirection getRotatedForgeDirection(ForgeDirection side, ForgeDirection localSide) {
		return ForgeDirection.getOrientation(ROTATION_MATRIX_Rotation[side.ordinal()][localSide.ordinal()]);
	}

	public static ForgeDirection getFacingDirectionHorizontal(int dir) {
		switch (dir) {
		case 0:
			return ForgeDirection.SOUTH;
		case 1:
			return ForgeDirection.WEST;
		case 2:
			return ForgeDirection.NORTH;
		case 3:
			return ForgeDirection.EAST;
		}
		return ForgeDirection.UNKNOWN;
	}
}

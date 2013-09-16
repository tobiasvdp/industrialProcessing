package ip.industrialProcessing.utils;

import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ForgeDirection;

public class SidedRotationTransformer {
	private static final int[][] ROTATION_MATRIX_Side = { { 1, 0, 3, 2, 5, 4, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 2, 3, 1, 0, 4, 5, 6 }, { 3, 2, 0, 1, 5, 4, 6 }, { 5, 4, 1, 0, 3, 2, 6 }, { 4, 5, 0, 1, 2, 3, 6 }, { 0, 1, 2, 3, 4, 5, 6 } };
	private static final int[][] ROTATION_MATRIX_Rotation = { { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 5, 4, 6 }, { 0, 1, 2, 3, 3, 2, 6 }, { 0, 1, 2, 3, 2, 3, 6 }, { 0, 1, 2, 3, 4, 5, 6 } };

	private static final int[][][] ROTATION_MATRIX_RotationSided = { { { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 3, 2, 5, 4, 6 }, { 0, 1, 4, 5, 3, 2, 6 }, { 0, 1, 5, 4, 2, 3, 6 }, { 0, 1, 2, 3, 4, 5, 6 } }, { { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 1, 0, 2, 3, 5, 4, 6 }, { 1, 0, 3, 2, 4, 5, 6 }, { 1, 0, 4, 5, 2, 3, 6 }, { 1, 0, 5, 4, 3, 2, 6 }, { 0, 1, 2, 3, 4, 5, 6 } }, { { 2, 3, 0, 1, 5, 4, 6 }, { 2, 3, 1, 0, 4, 5, 6 }, { 2, 3, 2, 3, 4, 5, 6 }, { 2, 3, 2, 3, 4, 5, 6 }, { 2, 3, 4, 5, 0, 1, 6 }, { 2, 3, 5, 4, 1, 0, 6 }, { 2, 3, 2, 3, 4, 5, 6 } }, { { 3, 2, 0, 1, 4, 5, 6 }, { 3, 2, 1, 0, 5, 4, 6 }, { 3, 2, 2, 3, 4, 5, 6 }, { 3, 2, 2, 3, 4, 5, 6 }, { 3, 2, 4, 5, 1, 0, 6 }, { 3, 2, 5, 4, 0, 1, 6 }, { 3, 2, 2, 3, 4, 5, 6 } },
			{ { 4, 5, 0, 1, 2, 3, 6 }, { 4, 5, 1, 0, 3, 2, 6 }, { 4, 5, 2, 3, 1, 0, 6 }, { 4, 5, 3, 2, 0, 1, 6 }, { 4, 5, 2, 3, 4, 5, 6 }, { 4, 5, 2, 3, 4, 5, 6 }, { 4, 5, 2, 3, 4, 5, 6 } }, { { 5, 4, 0, 1, 3, 2, 6 }, { 5, 4, 1, 0, 2, 3, 6 }, { 5, 4, 3, 2, 0, 1, 6 }, { 5, 4, 3, 2, 1, 0, 6 }, { 5, 4, 2, 3, 4, 5, 6 }, { 5, 4, 2, 3, 4, 5, 6 }, { 5, 4, 2, 3, 4, 5, 6 } }, { { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 } }, };

	private static final float[][] GL_ROTATION_MATRIX = { { 0.0f, 0.0f, 0.0f, 180.0f, 270.0f, 90.0f }, { 0.0f, 0.0f, 0.0f, 180.0f, 90.0f, 270, 0f }, { 180.0f, 0.0f, 0.0f, 0.0f, 270.0f, 90.0f }, { 0.0f, 180.0f, 0.0f, 0.0f, 270.0f, 90.0f }, { 90.0f, 270.0f,0.0f,180.0f,0.0f,0.0f }, { 270.0f,90.0f,0.0f,180.0f,0.0f,0.0f }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f } };

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
		return ForgeDirection.getOrientation(ROTATION_MATRIX_RotationSided[rot.getOrientationSide().ordinal()][rot.getOrientationRotation().ordinal()][dir.ordinal()]);
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
		default:
			break;
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

	public static float getGLrotationX(ForgeDirection side, ForgeDirection rotation) {
		return 0.0f;
	}

	public static float getGLrotationY(ForgeDirection side, ForgeDirection rotation) {
		switch (side) {
		case DOWN:
		case UP:
		case NORTH:
		case SOUTH:
		case WEST:
		case EAST:
			return 1.0f;
		default:
			return 0.0f;
		}

	}

	public static float getGLrotationZ(ForgeDirection side, ForgeDirection rotation) {
		return 0.0f;
	}

	public float getGLrotationAngle(ForgeDirection orientationSide, ForgeDirection rotation) {
		return GL_ROTATION_MATRIX[orientationSide.ordinal()][rotation.ordinal()];
	}

	public static float getGLsideX(ForgeDirection side) {
		if (side == ForgeDirection.NORTH)
			return 1.0f;
		if (side == ForgeDirection.SOUTH)
			return -1.0f;
		return 0.0f;
	}

	public static float getGLsideY(ForgeDirection side) {
		return 0.0f;
	}

	public static float getGLsideZ(ForgeDirection side) {
		if (side == ForgeDirection.UP)
			return 1.0f;
		if (side == ForgeDirection.WEST)
			return 1.0f;
		if (side == ForgeDirection.EAST)
			return -1.0f;
		return 0.0f;
	}

	public float getGLsideAngle(ForgeDirection orientationSide) {
		if (orientationSide == ForgeDirection.DOWN)
			return 0.0f;
		if (orientationSide == ForgeDirection.UP)
			return 180.0f;
		return 90;
	}
}

package ip.industrialProcessing.utils;

import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ForgeDirection;

public class SidedRotationTransformer {
    private static final int[][] ROTATION_MATRIX_Side = {
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
    };
    private static final int[][] ROTATION_MATRIX_Rotation = {
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 3, 2, 5, 4, 6},
        {0, 1, 4, 5, 1, 2, 6},
        {0, 1, 5, 4, 2, 1, 6},
        {0, 1, 2, 3, 4, 5, 6},
    };
    
	public static ForgeDirection transformMetaToForgeDirection(int meta){
		switch(meta){
		case 0:return ForgeDirection.UP;
		case 1:return ForgeDirection.DOWN;
		case 2:return ForgeDirection.SOUTH;
		case 3:return ForgeDirection.NORTH;
		case 4:return ForgeDirection.EAST;
		case 5:return ForgeDirection.WEST;
		default:return ForgeDirection.UNKNOWN;
		}
	}
	
	public static ForgeDirection InternalToExternalDirection(ISidedRotation rot,ForgeDirection dir){
		return dir.getRotation(rot.getOrientationSide());
	}
	
	public static ForgeDirection transformSideAndLookToForgeDirection(ForgeDirection side,float rotationYaw, float rotationPitch){
		switch(side){
		case UP:case DOWN:
			int dir = MathHelper.floor_double((double) ((rotationYaw * 4F) / 360F) + 0.5D) & 3;
			return getFacingDirectionHorizontal(dir);
		case NORTH:case SOUTH:case EAST:case WEST:
			return getFacingDirectionVertical(rotationPitch , rotationYaw, side);
		default:
			return ForgeDirection.UNKNOWN;
		}
	}
	
	private static ForgeDirection getFacingDirectionVertical(float rotationPitch, float rotationYaw, ForgeDirection side) {
		float offsetYaw = sideToAngle(side);
		if (Math.abs(rotationYaw - offsetYaw) > Math.abs(rotationPitch)){
			if ((rotationYaw - offsetYaw) > 0.0)
				return getRotatedForgeDirection(side,ForgeDirection.EAST);
			else
				return getRotatedForgeDirection(side,ForgeDirection.WEST);
		}else{
			if (rotationPitch > 0.0)
				return ForgeDirection.DOWN;
			else
				return ForgeDirection.UP;
		}
	}

	private static ForgeDirection getRotatedForgeDirection(ForgeDirection side, ForgeDirection localSide) {
		return ForgeDirection.getOrientation(ROTATION_MATRIX_Rotation[side.ordinal()][localSide.ordinal()]);
	}

	private static float sideToAngle(ForgeDirection side) {
		switch(side){
		case NORTH:return 180;
		case EAST:return 270;
		case SOUTH:return 0;
		case WEST:return 90;
		default: return 180;
		}
	}

	public static ForgeDirection getFacingDirectionHorizontal(int dir) {
		switch (dir) {
		case 0:
			return ForgeDirection.NORTH;
		case 1:
			return ForgeDirection.EAST;
		case 2:
			return ForgeDirection.SOUTH;
		case 3:
			return ForgeDirection.WEST;
		}
		return ForgeDirection.UNKNOWN;
	}
}

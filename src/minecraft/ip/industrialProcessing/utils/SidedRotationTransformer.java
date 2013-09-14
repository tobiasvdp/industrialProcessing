package ip.industrialProcessing.utils;

import net.minecraftforge.common.ForgeDirection;

public class SidedRotationTransformer {

	public static ForgeDirection transformMetaToForgeDirection(int meta){
		switch(meta){
		case 0:break;
		case 1:break;
		case 2:break;
		case 3:break;
		case 4:break;
		case 5:break;
		default:return ForgeDirection.UNKNOWN;
		}
		return ForgeDirection.UNKNOWN;
	}
	
	public static ForgeDirection InternalToExternalDirection(ISidedRotation rot,ForgeDirection dir){
		return dir.getRotation(rot.getOrientationSide());
	}
}

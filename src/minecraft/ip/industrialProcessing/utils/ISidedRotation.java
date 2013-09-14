package ip.industrialProcessing.utils;

import net.minecraftforge.common.ForgeDirection;

public interface ISidedRotation {
	
	public static final SidedRotationTransformer SIDEDTRANSFORMER = new SidedRotationTransformer();

	public void setOrientationSide(ForgeDirection side);
	public void setOrientationSide(int metadata);
	
	public ForgeDirection getOrientationSide();
	public int getOrientationRotation();
	
	public float getGLrotationX();
	public float getGLrotationY();
	public float getGLrotationZ();
	
	
	
}

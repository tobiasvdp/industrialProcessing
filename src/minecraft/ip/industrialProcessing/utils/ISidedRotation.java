package ip.industrialProcessing.utils;

import net.minecraftforge.common.ForgeDirection;

public interface ISidedRotation {
	
	public static final SidedRotationTransformer SIDEDTRANSFORMER = new SidedRotationTransformer();

	public void setOrientationSide(ForgeDirection side);
	public void setOrientationSide(int metadata);
	public void setOrientationRotation(float rotationYaw, float rotationPitch);
	public void setOrientationRotation(ForgeDirection dir);
	
	public ForgeDirection getOrientationSide();
	public ForgeDirection getOrientationRotation();
	
	public float getGLrotationX();
	public float getGLrotationY();
	public float getGLrotationZ();
	
	public ForgeDirection getExternalForgeDirection(ForgeDirection side);
	
}

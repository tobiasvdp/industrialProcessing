package mod.industrialProcessing.utils.rotation;

import net.minecraftforge.common.util.ForgeDirection;

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
	public float getGLrotationAngle();	
	
	public float getGLsideX();
	public float getGLsideY();
	public float getGLsideZ();
	public float getGLsideAngle();
	
	public ForgeDirection getExternalForgeDirection(ForgeDirection side);

	
	
}

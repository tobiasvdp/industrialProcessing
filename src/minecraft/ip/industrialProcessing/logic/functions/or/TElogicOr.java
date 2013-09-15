package ip.industrialProcessing.logic.functions.or;

import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.utils.ISidedRotation;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicOr extends TElogicNode implements ISidedRotation {

	private ForgeDirection orientationSide;
	private ForgeDirection orientationRotation;
	
	public TElogicOr() {
		super();
	}
	
	@Override
	public void setOrientationSide(ForgeDirection side) {
		orientationSide = side;
	}

	@Override
	public void setOrientationSide(int metadata) {
		orientationSide = SIDEDTRANSFORMER.transformMetaToForgeDirection(metadata);
	}

	@Override
	public ForgeDirection getOrientationSide() {
		return orientationSide;
	}

	@Override
	public ForgeDirection getOrientationRotation() {
		return orientationRotation;
	}

	@Override
	public float getGLrotationX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getGLrotationY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getGLrotationZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setOrientationRotation(float rotationYaw, float rotationPitch) {
		orientationRotation = SIDEDTRANSFORMER.transformSideAndLookToForgeDirection(orientationSide, rotationYaw, rotationPitch);
	}

	@Override
	public void setOrientationRotation(ForgeDirection dir) {
		orientationRotation = dir;
	}

	@Override
	public ForgeDirection getExternalForgeDirection(ForgeDirection side) {
		return SIDEDTRANSFORMER.InternalToExternalDirection(this, side);
	}

	@Override
	public float getGLsideX() {
		return SIDEDTRANSFORMER.getGLsideX(getOrientationSide());
	}

	@Override
	public float getGLsideY() {
		return SIDEDTRANSFORMER.getGLsideY(getOrientationSide());
	}

	@Override
	public float getGLsideZ() {
		return SIDEDTRANSFORMER.getGLsideZ(getOrientationSide());
	}

	@Override
	public ForgeDirection[] setConnectableSides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void transition() {
		// TODO Auto-generated method stub
		
	}

}

package ip.industrialProcessing.logic.functions.or;

import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTpacket;
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
		return SIDEDTRANSFORMER.getGLrotationX(getOrientationSide(), getOrientationRotation());
	}

	@Override
	public float getGLrotationY() {
		return SIDEDTRANSFORMER.getGLrotationY(getOrientationSide(), getOrientationRotation());
	}

	@Override
	public float getGLrotationZ() {
		return SIDEDTRANSFORMER.getGLrotationZ(getOrientationSide(), getOrientationRotation());
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
	public float getGLsideAngle() {
		return SIDEDTRANSFORMER.getGLsideAngle(getOrientationSide());
	}

	@Override
	public float getGLrotationAngle() {
		return SIDEDTRANSFORMER.getGLrotationAngle(getOrientationSide(), getOrientationRotation());
	}

	@Override
	public void transition() {
		System.out.println(getBuffer(SIDEDTRANSFORMER.InternalToExternalDirection(this, ForgeDirection.EAST)).get());
		System.out.println(getBuffer(SIDEDTRANSFORMER.InternalToExternalDirection(this, ForgeDirection.WEST)).get());
		if ((Boolean) getBuffer(SIDEDTRANSFORMER.InternalToExternalDirection(this, ForgeDirection.EAST)).get() || (Boolean) getBuffer(SIDEDTRANSFORMER.InternalToExternalDirection(this, ForgeDirection.WEST)).get()) {
		}
		else {
		}

		System.out.println(getBuffer(SIDEDTRANSFORMER.InternalToExternalDirection(this, ForgeDirection.NORTH)).get());
	}

	@Override
	public ForgeDirection[] setConnectableInputSides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForgeDirection[] setConnectableOutputSides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub
		
	}
}

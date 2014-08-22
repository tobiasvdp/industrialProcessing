package mod.industrialProcessing.plants.power.motor.electroMotor;

import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.power.network.IPowerAcceptor;
import mod.industrialProcessing.power.network.PowerHelper;
import mod.industrialProcessing.power.network.SimplePowerStorage;
import mod.industrialProcessing.power.utils.IMechanicalMotionEmitter;
import mod.industrialProcessing.power.utils.IMechanicalMotionReceiver;
import mod.industrialProcessing.utils.handlers.numbers.IProgressable;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityElectroMotor extends TileEntityBlockContainerIP implements IPowerAcceptor, IProgressable, IMechanicalMotionEmitter {

	private static final float DRAG = 0.1f;
	private static final float POWER_TO_TORQUE_RATIO = 1;
	private SimplePowerStorage storage = new SimplePowerStorage(10000);
	private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.CLAMP, 1000, true);
	private LocalDirection motionOutputDirection = LocalDirection.BACK;
	private LocalDirection powerInputSide = LocalDirection.FRONT;
	private float voltage;
	private float lastVoltage;

	private IMechanicalMotionReceiver getGenerator(ForgeDirection dir) {

		TileEntity entity = this.worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
		if (entity instanceof IMechanicalMotionReceiver)
			return (IMechanicalMotionReceiver) entity;
		return null;
	}

	@Override
	public void updateEntity() {

		if (!this.worldObj.isRemote) {
			this.lastVoltage = this.voltage;
			this.voltage = 0f;
		}
		this.animationHandler.update();
	}

	@Override
	public float getResistance(ForgeDirection side, float voltage) {
		return PowerHelper.getResistanceForStorage(storage);
	}

	@Override
	public void applyPower(ForgeDirection side, float coulombs, float voltage) {
		if (canAcceptPower(side)) {
			int joules = (int) PowerHelper.getEnergy(coulombs, voltage);
			this.storage.fillPower(joules, true);
			this.voltage += voltage;
		}
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		return this.powerInputSide == getLocalDirection(side);
	}

	@Override
	public float getProgress(int index) {
		switch (index) {
		case 0:
			return this.lastVoltage;
		case 1:
			return this.animationHandler.getSpeed();
		}
		return 0;
	}

	@Override
	public float getMaxProgress(int index) {
		switch (index) {
		case 0:
			return 250;
		case 1:
			return this.animationHandler.getScale();
		}
		return 0;
	}

	@Override
	public float getSpeed(ForgeDirection direction) {
		return this.animationHandler.getSpeed();
	}

	@Override
	public void setSpeed(ForgeDirection direction, float speed) {
		if (isMotionSource(direction)) {
			this.animationHandler.setSpeed(speed);
		}
	}

	@Override
	public float getAvailableTorque(ForgeDirection direction, float desiredTorque, boolean applyTorque) {
		if (isMotionSource(direction)) {
			return this.storage.drainPower(desiredTorque * POWER_TO_TORQUE_RATIO, applyTorque) / POWER_TO_TORQUE_RATIO;
		}
		return 0;
	}

	@Override
	public boolean isMotionSource(ForgeDirection side) {
		return this.motionOutputDirection == getLocalDirection(side);
	}

}

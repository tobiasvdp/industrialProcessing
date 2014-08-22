package mod.industrialProcessing.power.utils;

import net.minecraftforge.common.util.ForgeDirection;

public interface IMechanicalMotionReceiver extends IMechanicalMotion {

	// float setSpeed(ForgeDirection side, float torque);

	float getResistance(ForgeDirection direction);
	float addTorque(ForgeDirection torque, float amount);

	boolean isMotionTarget(ForgeDirection side);
}

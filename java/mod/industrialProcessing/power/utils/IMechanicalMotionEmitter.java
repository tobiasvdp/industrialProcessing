package mod.industrialProcessing.power.utils;

import net.minecraftforge.common.util.ForgeDirection;

public interface IMechanicalMotionEmitter extends IMechanicalMotion {
	float getAvailableTorque(ForgeDirection direction, float desiredTorque, boolean applyTorque);

	boolean isMotionSource(ForgeDirection side);
}

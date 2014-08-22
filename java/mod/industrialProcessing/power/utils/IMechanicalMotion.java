package mod.industrialProcessing.power.utils;

import net.minecraftforge.common.util.ForgeDirection;

public interface IMechanicalMotion {

	float getSpeed(ForgeDirection direction);

	void setSpeed(ForgeDirection direction, float speed);
}

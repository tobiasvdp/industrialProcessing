package mod.industrialProcessing.power.utils;

import net.minecraftforge.common.util.ForgeDirection;

public interface IMechanicalMotion {
	void setSpeed(ForgeDirection side, float speed);
	float getResistance(ForgeDirection side); 
}

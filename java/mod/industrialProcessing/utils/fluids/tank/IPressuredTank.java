package mod.industrialProcessing.utils.fluids.tank;

import net.minecraftforge.common.util.ForgeDirection;

public interface IPressuredTank {
	float getPressure(ForgeDirection from);
	void addPressure(ForgeDirection from, float pressure);
}

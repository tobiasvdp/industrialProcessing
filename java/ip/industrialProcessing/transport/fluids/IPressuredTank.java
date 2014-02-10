package ip.industrialProcessing.transport.fluids;

import net.minecraftforge.common.util.ForgeDirection;

public interface IPressuredTank {
	float getPressure(ForgeDirection from);
	void addPressure(ForgeDirection from, float pressure);
}

package ip.industrialProcessing.api.tanks;

import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.transport.fluids.IPressuredTank;

public interface ITank extends IPressuredTank, IFluidHandler, IFluidInfo {
	IPfluidTank getTank(int index);
}

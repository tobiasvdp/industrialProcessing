package ip.industrialProcessing.api.tanks;

import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.transport.fluids.IPressuredTank;
import net.minecraftforge.fluids.IFluidHandler;

public interface ITank extends IPressuredTank, IFluidHandler, IFluidInfo {
	IPfluidTank getTank(int index);
}

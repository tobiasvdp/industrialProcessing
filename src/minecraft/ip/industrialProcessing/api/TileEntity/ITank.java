package ip.industrialProcessing.api.TileEntity;

import net.minecraftforge.fluids.FluidTankInfo;

public interface ITank {

	FluidTankInfo getTankInfoForSlot(int slot);

}

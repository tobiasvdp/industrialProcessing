package ip.industrialProcessing.api.tanks;

import net.minecraftforge.common.ForgeDirection;

public interface IIPfluidTank {
    void setTankCapacity(int capacity);
    void setFluidAmount(int amount);
    void setFluidID(int fluidID);
    int getTankCapacity();
    int getFluidAmount();
    int getFluidID();
    boolean isConnectedToSide(ForgeDirection side);
}

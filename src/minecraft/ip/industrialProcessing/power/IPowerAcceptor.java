package ip.industrialProcessing.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerAcceptor {
    int acceptPower(int maxAmount, ForgeDirection side);
    boolean canAcceptPower(ForgeDirection side);
}

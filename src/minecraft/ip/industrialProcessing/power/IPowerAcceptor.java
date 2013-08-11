package ip.industrialProcessing.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerAcceptor extends IPowerEntity {
    int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept);
    boolean canAcceptPower(ForgeDirection side);
}

package ip.industrialProcessing.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerWire extends IPowerEntity {
    WireConnectionState getWireConnection(ForgeDirection direction);
}

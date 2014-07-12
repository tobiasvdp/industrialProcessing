package mod.industrialProcessing.blockContainer.transport;

import net.minecraftforge.common.util.ForgeDirection;

public interface IConnectedTile {
    ConnectionState getConnection(ForgeDirection direction);  
}

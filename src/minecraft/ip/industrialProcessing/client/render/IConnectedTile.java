package ip.industrialProcessing.client.render;

import net.minecraftforge.common.ForgeDirection;

public interface IConnectedTile {
    ConnectionState getConnection(ForgeDirection direction);  
}

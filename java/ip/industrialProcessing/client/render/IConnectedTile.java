package ip.industrialProcessing.client.render;

import net.minecraftforge.common.util.ForgeDirection;

public interface IConnectedTile {
    ConnectionState getConnection(ForgeDirection direction);  
}

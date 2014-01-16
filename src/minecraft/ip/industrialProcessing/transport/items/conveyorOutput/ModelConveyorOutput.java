package ip.industrialProcessing.transport.items.conveyorOutput;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorTransportBase;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.ModelConveyorBeltTile;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.CrossPath;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.ItemPath;

public class ModelConveyorOutput extends ModelConveyorBeltTile {

    @Override
    protected void renderModelConnectedOriented(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {

        ItemPath path =  new CrossPath(tl, front, left, right, back, up, down);
        if (tl instanceof TileEntityConveyorTransportBase) {
            TileEntityConveyorTransportBase belt = (TileEntityConveyorTransportBase) tl;
            drawItems(path, f, belt);
        }
    }
}

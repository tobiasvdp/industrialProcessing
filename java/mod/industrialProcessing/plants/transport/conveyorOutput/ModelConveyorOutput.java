package mod.industrialProcessing.plants.transport.conveyorOutput;

import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.ModelConveyorBeltTile;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.paths.CrossPath;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.paths.ItemPath;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorTransportBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

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

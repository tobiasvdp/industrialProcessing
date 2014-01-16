package ip.industrialProcessing.transport.items.conveyorInput;

import java.util.Arrays;

import net.minecraft.inventory.IInventory;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;

public class TileEntityConveyorInput extends TileEntityConveyorInventoryBase {

    public TileEntityConveyorInput() {
        super();
        Arrays.fill(this.connections, ConnectionMode.INVENTORYINPUT);
        setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
    }

    @Override
    protected TransportConnectionState handleInventoryState(IInventory inventory, ForgeDirection direction, ConnectionMode mode) {
        return TransportConnectionState.INPUT;
    }
}

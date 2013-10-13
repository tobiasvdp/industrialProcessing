package ip.industrialProcessing.transport.items.conveyorOutput;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;

import java.util.Arrays;

public class TileEntityConveyorOutput extends TileEntityConveyorInventoryBase {

	public TileEntityConveyorOutput() {
		super(); 
		setConnectionMode(LocalDirection.FRONT, ConnectionMode.INPUT);
		setConnectionMode(LocalDirection.BACK, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.LEFT, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.LEFT, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.UP, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.DOWN, ConnectionMode.INVENTORYOUTPUT);
	}

}

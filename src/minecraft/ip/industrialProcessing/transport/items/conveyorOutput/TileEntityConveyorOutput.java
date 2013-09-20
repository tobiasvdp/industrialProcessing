package ip.industrialProcessing.transport.items.conveyorOutput;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;

import java.util.Arrays;

public class TileEntityConveyorOutput extends TileEntityConveyorInventoryBase {

	public TileEntityConveyorOutput() {
		super();
		Arrays.fill(this.connections, ConnectionMode.INVENTORYOUTPUT);
		setConnectionMode(LocalDirection.FRONT, ConnectionMode.INPUT);
		setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
	}

}

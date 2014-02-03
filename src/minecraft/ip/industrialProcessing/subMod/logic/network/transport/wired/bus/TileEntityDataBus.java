package ip.industrialProcessing.subMod.logic.network.transport.wired.bus;

import ip.industrialProcessing.subMod.logic.network.microblock.TileEntityLogicTransport;

public class TileEntityDataBus extends TileEntityLogicTransport {

    @Override
    public void updateEntity() {
	for (int i = 0; i < 6; i++)
	    System.out.println(this.lineID[i]);
	super.updateEntity();
    }

}

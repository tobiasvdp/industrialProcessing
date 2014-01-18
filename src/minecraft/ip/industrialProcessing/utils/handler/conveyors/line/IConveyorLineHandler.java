package ip.industrialProcessing.utils.handler.conveyors.line;

import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.plants.IMechanicalMotion;
import ip.industrialProcessing.transport.items.ConveyorLine;
import ip.industrialProcessing.transport.items.ConveyorBeltPowerInput.TileEntityConveyorBeltPowerInput;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorTransportBase;

public interface IConveyorLineHandler {
	public int registerConveyor(TileEntityConveyorConnectionsBase conveyorBelt);
	public void unregisterConveyor(TileEntityConveyorConnectionsBase te);
	public void registerConveyorFromNBT(TileEntityConveyorConnectionsBase conveyorBelt);
	public boolean registerPowercontainer(int id, TileEntityConveyorBeltPowerInput te);
	public void unregisterPowercontainer(int id, TileEntityConveyorBeltPowerInput te);
	public float getResistanceForConveyorLine(int line);
	public float getSpeedForConveyorLine(int line);
}

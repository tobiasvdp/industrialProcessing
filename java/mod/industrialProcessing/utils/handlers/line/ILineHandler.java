package mod.industrialProcessing.utils.handlers.line;

import mod.industrialProcessing.plants.transport.items.ConveyorBeltPowerInput.TileEntityConveyorBeltPowerInput;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;

public interface ILineHandler {
	public int registerLine(TileEntityConveyorConnectionsBase conveyorBelt);
	public void unregisterLine(TileEntityConveyorConnectionsBase te);
	public void registerLineFromNBT(TileEntityConveyorConnectionsBase LineBelt);
	public boolean registerPowercontainer(int id, TileEntityConveyorBeltPowerInput te);
	public void unregisterPowercontainer(int id, TileEntityConveyorBeltPowerInput te);
	public float getResistanceForLine(int line);
	public float getSpeedForLine(int line);
}

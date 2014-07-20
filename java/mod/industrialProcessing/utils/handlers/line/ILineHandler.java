package mod.industrialProcessing.utils.handlers.line;

import java.util.ArrayList;

import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;

public interface ILineHandler {
	public int registerToLine(ILineTileEntity teLine);
	public void unregisterFromLine(ILineTileEntity teLine);
	public void registerToLineFromNBT(ILineTileEntity teLine);
	
	public int registerUtilityToLine(ILineTileEntity teLine);
	public void unregisterUtilityFromLine(ILineTileEntity teLine);
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine);
	
	public ArrayList<ILine> getLines();
}

package mod.industrialProcessing.utils.handlers.line;

import java.util.ArrayList;

import net.minecraftforge.common.util.ForgeDirection;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;

public interface ILineHandler {
	public int registerToLine(ILineTileEntity teLine, ForgeDirection dir);
	public void unregisterFromLine(ILineTileEntity teLine, ForgeDirection dir);
	public void registerToLineFromNBT(ILineTileEntity teLine, ForgeDirection dir);
	
	public int registerUtilityToLine(ILineTileEntity teLine, ForgeDirection dir);
	public void unregisterUtilityFromLine(ILineTileEntity teLine, ForgeDirection dir);
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine, ForgeDirection dir);
	
	public ILine[] getLines();
	public String getName();
}

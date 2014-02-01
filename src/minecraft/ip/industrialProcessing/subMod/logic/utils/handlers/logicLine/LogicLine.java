package ip.industrialProcessing.subMod.logic.utils.handlers.logicLine;

import ip.industrialProcessing.subMod.logic.network.ILogicNode;
import ip.industrialProcessing.subMod.logic.network.ILogicTransport;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.utils.handler.lines.ILine;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.tileentity.TileEntity;

public class LogicLine implements ILine{
	
	ArrayList<ILogicNode> nodes = new ArrayList<ILogicNode>();
	ArrayList<ILogicTransport> transport = new ArrayList<ILogicTransport>();
	int ID = -1;
	
	public LogicLine(int id) {
		this.ID = id;
	}
	
	@Override
	public int registerTransport(TileEntity te) {
		if(te instanceof ILogicTransport && !transport.contains(te)){
		transport.add((ILogicTransport) te);
		return ID;
		}
		return -1;
	}
	@Override
	public boolean unregisterTransport(TileEntity te) {
		transport.remove(te);
		if (transport.size() == 0 && nodes.size() == 0) {
			return true;
		}
		return false;
	}
	@Override
	public int registerDevice(TileEntity te) {
		if (te instanceof ILogicNode && !nodes.contains(te)){
			nodes.add((ILogicNode) te);
			return ID;
			}
			return -1;
	}
	@Override
	public boolean unregisterDevice(TileEntity te) {
		transport.remove(te);
		if (transport.size() == 0 && nodes.size() == 0) {
			return true;
		}
		return false;
	}
	@Override
	public void sendToDevices(Object obj) {

	}
	@Override
	public void registerLine(ILine line) {
		if (line != null && line instanceof LogicLine) {
			transport.addAll(((LogicLine)line).transport);
			nodes.addAll(((LogicLine)line).nodes);
			 
			//TODO interface for line setting
			/*Iterator<TileEntityConveyorConnectionsBase> it = blocks.iterator();
			while (it.hasNext()) {
				it.next().setConveyorLineID(ID);
			}
			*/
		}
	}
	@Override
	public void unregisterLine(ILine line) {
		 
		//TODO interface for line setting
		
	}
	
	

}

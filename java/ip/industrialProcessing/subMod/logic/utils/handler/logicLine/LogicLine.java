package ip.industrialProcessing.subMod.logic.utils.handler.logicLine;

import ip.industrialProcessing.subMod.logic.network.ILogicNode;
import ip.industrialProcessing.subMod.logic.network.ILogicTransport;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.utils.handler.lines.ILine;
import ip.industrialProcessing.utils.handler.lines.ILineDevice;
import ip.industrialProcessing.utils.handler.lines.ILineTransport;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.tileentity.TileEntity;

public class LogicLine implements ILine{
	
	ArrayList<ILineDevice> nodes = new ArrayList<ILineDevice>();
	ArrayList<ILineTransport> transport = new ArrayList<ILineTransport>();
	int ID = -1;
	
	public LogicLine(int id) {
		this.ID = id;
	}
	
	@Override
	public int registerTransport(ILineTransport te) {
		if(te instanceof ILogicTransport && !transport.contains(te)){
		transport.add((ILogicTransport) te);
		return ID;
		}
		return -1;
	}
	@Override
	public boolean unregisterTransport(ILineTransport te) {
		transport.remove(te);
		if (transport.size() == 0 && nodes.size() == 0) {
			return true;
		}
		return false;
	}
	@Override
	public int registerDevice(ILineDevice te) {
		if (te instanceof ILogicNode && !nodes.contains(te)){
			nodes.add((ILogicNode) te);
			return ID;
			}
			return -1;
	}
	@Override
	public boolean unregisterDevice(ILineDevice te) {
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
			 
			Iterator<ILineDevice> it = line.getDevices();
			while(it.hasNext()){
				ILineDevice dev = it.next();
				for(int i =0;i<6;i++){
					if(line.getID() == dev.getLineID(i))
					dev.setLineID(i, this.getID());
				}
			}
			Iterator<ILineTransport> it2 = line.getTransport();
			while(it2.hasNext()){
				ILineTransport dev = it2.next();
				for(int i =0;i<6;i++){
					if(line.getID() == dev.getLineID(i))
					dev.setLineID(i, this.getID());
				}
			}
		}
	}
	@Override
	public void unregisterLine(ILine line) {
		 
		//TODO interface for line setting
		
	}

	@Override
	public Iterator<ILineDevice> getDevices() {
		return nodes.iterator();
	}

	@Override
	public Iterator<ILineTransport> getTransport() {
		return transport.iterator();
	}

	@Override
	public int getID() {
		return ID;
	}
	
	

}
